import { BrowserRouter, Route, Routes } from 'react-router-dom';
import GoogleLoginView from './GoogleLoginView'
import NotFound from './NotFound';
import NavBar from '../component/NavBar/NavBar';
import Paciente from './PacienteView';

function MenuInicial() {
    
    return (
        <BrowserRouter>
            <NavBar/> 
            <Routes>
                <Route path="/" element={<GoogleLoginView />} />
                <Route path="/pruebas" element={<Paciente />} />
                <Route path="*" element={<NotFound/> } />
            </Routes>
        </BrowserRouter>
    );
}

export default MenuInicial;
