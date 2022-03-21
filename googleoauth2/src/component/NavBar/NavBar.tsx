
import { NavLink } from 'react-router-dom';
import './navBar.css';


function NavBar() {

    return (
        <div>
        <h1 className="padding"></h1>
        <nav>
            <ul>
                <li>
                    <NavLink to="/" > Login</NavLink>
                 </li>

                <li>
                    <NavLink to="/pruebas" >Prueba</NavLink>
                </li>
                <li>
                    <NavLink to="/NotFound" >NotFound</NavLink>
                </li>
            </ul>
        </nav>
            
        </div>
   );
}

export default NavBar;