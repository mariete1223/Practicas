
import { useSelector } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { selectUsuario } from '../AuthorizationState/authorizationSlice';
import './navBar.css';
import { FaFacebookSquare, FaTwitterSquare, FaInstagramSquare, FaBars, FaWindowClose } from 'react-icons/fa';
import { useState } from 'react';


const  NavBar = () => {

    var usuario = useSelector(selectUsuario);

    const [click, setClick] = useState(false);

    const handleClick = () => setClick(!click);

    return (
        <header className="navBar">
        <nav className="main-nav">
            <div className="nav-container">
            <NavLink className="nav-logo" to="/">
                <h2><span>C</span>entro <span>M</span>edico</h2>
            </NavLink>
                    
                        <ul className={ click ? "nav-menu active" : "nav-menu" }>
                            <li className="nav-item">
                           
                            <NavLink onClick={handleClick} className="nav-link"  to="/" > Login</NavLink>
                            </li>

                            <li className="nav-item">
                            <NavLink onClick={handleClick} className="nav-link" to="/myInfo/misCitas" >Mis Citas</NavLink>
                            </li>

                            {usuario == "Medico" &&
                            <li className="nav-item">
                            <NavLink onClick={handleClick} className="nav-link"  to="/myInfo" >Ver Citas</NavLink>
                            </li>
                            }

                            <li className="nav-item">
                            <NavLink onClick={handleClick} className="nav-link"  to="/nuevaCitaForm" >Nueva Cita</NavLink>
                           
                            </li>    

                        </ul>
                    

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
                    <div className="nav-icon" onClick={handleClick}>
                        <i className="bars-icon">{click ? <FaWindowClose/> : <FaBars/> }</i>
                    </div>
            </div>
        </nav>
            
        </header>
   );
}



export default NavBar;