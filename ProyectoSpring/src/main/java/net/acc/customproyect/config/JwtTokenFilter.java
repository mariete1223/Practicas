package net.acc.customproyect.config;


import java.io.Console;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.LogManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.hazelcast.collection.impl.txnqueue.operations.TxnReservePollOperation;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.entitiesDTO.MedicoDTO;
import net.acc.customproyect.entitiesDTO.PacienteDTO;
import net.acc.customproyect.entitiesDTO.UsuarioDTO;
import net.acc.customproyect.service.UsuarioService;



@Component
public class JwtTokenFilter extends OncePerRequestFilter {
	
	private static final String CLIENT_ID="80071081849-ot7tl281gg8ksgukh4m1ce6fbsghg11j.apps.googleusercontent.com"; 
	
	private HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
	
	private  Map<Long, String> mapHazelCast = hzInstance.getMap("data");
	
	@Autowired
	private UsuarioService usuarioService;
	

	 private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JwtTokenFilter.class);


	private GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
			.setAudience(Collections.singletonList(CLIENT_ID))
			.build();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        String role="NoRole";
        
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            try {
            	
        	String[] tokenParts= authHeader.split(" ");
            GoogleIdToken idToken = verifier.verify(tokenParts[1]);
            System.out.println(idToken);
            
            if(idToken!=null) {
            	
            	Payload payload = idToken.getPayload();
            	String nombreUsuario = (String)payload.get("given_name");
           
            	UsuarioDTO usuario = usuarioService.getUsuarioByName(nombreUsuario);
            	
            	if(usuario== null) {
            		
            		usuario= new UsuarioDTO();
            		usuario.setNombre(nombreUsuario);
            		usuario.setApellidos((String)payload.get("family_name"));
            		usuario.setEmail((String)payload.get("email"));
            		Long userId = usuarioService.saveUsuario(usuario).getUsuarioId();
            		usuario.setUsuarioId(userId);
            		//hace falta un setId?
            		mapHazelCast.put(userId, tokenParts[1]);
            		System.out.println("\n\n\n"+mapHazelCast.get(userId)+"\n\n\n");
            		
            	}
            	
            	System.out.println("\n\n\n"+mapHazelCast.get(usuario.getUsuarioId())+usuario.getUsuarioId()+"\n\n\n");
            	if(mapHazelCast.get(usuario.getUsuarioId())==null) {
            		// si es null, le damos valor, luego comprobamos que concuerden los dos tokens
            		mapHazelCast.put(usuario.getUsuarioId(), tokenParts[1]);
        
            		
            	}
            	if(usuario instanceof PacienteDTO) {
            		role="Paciente";
            	}
            	else if (usuario instanceof MedicoDTO) {
            		role="Medico";
            	}
            	//if(mapHazelCast.get(usuario.getUsuarioId()).equals(tokenParts[1])) {
            		response.setHeader("Role", role);
            		filterChain.doFilter(request, response);
            	//}
            	/*else {
            		
            		System.out.println("NotSameToken");
            		log.error("Invalid Authorization");
                	response.setHeader("error", "Invalid Authorization");
                	response.sendError(HttpServletResponse.SC_FORBIDDEN);
                	
            	}	*/
            	
            }
            else {
            	log.error("Invalid Authorization");
            	response.setHeader("error", "Invalid Authorization");
            	response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
            
            } catch (Exception e) {
            	
            	System.out.println("catch");
            	log.error("Error with JWT in {}", e.getMessage());
            /*	response.setContentLength("prueba".length());
            	response.getOutputStream().write("prueba".getBytes());*/
            	response.setHeader("error", e.getMessage());
            	response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            	
            }
		
        }else {
        	
        	System.out.println("else");
        	log.error("Invalid Authorization");
        	response.setHeader("error", "Invalid Authorization");
        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        	
        }

	
	}
}
	
