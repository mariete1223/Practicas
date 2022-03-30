package net.acc.customproyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@EnableCaching
@SpringBootApplication
public class ExampleProyectApplication {

	public static void main(String[] args) {
		 
		SpringApplication.run(ExampleProyectApplication.class, args);
	}

}
