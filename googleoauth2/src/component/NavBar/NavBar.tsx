
import { useSelector } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { selectUsuario } from '../AuthorizationState/authorizationSlice';
import './navBar.css';
import { FaFacebookSquare, FaTwitterSquare, FaInstagramSquare } from 'react-icons/fa';


const  NavBar = () => {

    var usuario = useSelector(selectUsuario);



    return (
        <header className="navBar">
        <h1 className="padding"></h1>
        <nav className="main-nav">
            <div className="logo">
                <h2><span>C</span>entro <span>M</span>edico</h2>
            </div>
                    <div className="menu-link" id="ida">
                        <ul>
                        <li>
                           
                                <NavLink className="NavLink" to="/" > Login</NavLink>
                            </li>

                            <li>
                            <NavLink className="NavLink" to="/myInfo/misCitas" >Mis Citas</NavLink>
                            </li>

                            {usuario == "Medico" &&
                                <li>
                            && <NavLink className="NavLink" to="/myInfo" >Ver Citas</NavLink>
                                </li>
                            }

                        <li>
                            <NavLink className="NavLink" to="/NotFound" >NotFound</NavLink>
                           
                            </li>    

                        </ul>
                </div>

                <div className="social-media">
                    <ul className="social-media-desktop">
                        <li>
                            <a href="#"><FaFacebookSquare /></a>
                        </li>
                        <li>
                            <a href="#"><FaTwitterSquare /></a>
                        </li>
                        <li>
                            <a href="#"><FaInstagramSquare /></a>
                        </li>
                    </ul>
                </div>
                

        </nav>
            
        </header>
   );
}



export default NavBar;