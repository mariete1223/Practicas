import { BrowserRouter, Navigate, Route, Routes, useNavigate } from 'react-router-dom';
import GoogleLoginView from './GoogleLoginView'
import NotFound from './NotFound';
import NavBar from '../component/NavBar/NavBar';
import Paciente from './PacienteView';
import { useSelector } from 'react-redux';
import { selectIsLoggedIn, selectUsuario } from '../component/AuthorizationState/authorizationSlice';
import CambioCitaForm from './CambioCitaForm';
import { selectCitaSelected } from '../component/CitaState/CitaSlice';
import Cita from '../component/CitasView/Citas';

function MenuInicial() {
    
    var logged = useSelector(selectIsLoggedIn);
    var isCitaSelected = useSelector(selectCitaSelected).citaId!=null;

    const show = () => {
        console.log(logged);
    }
    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<GoogleLoginView />} />

                <Route path="/myInfo" element={
                    logged ? <Paciente /> : <Navigate to="/" /> } >
                <Route path="misCitas" element={<Cita />} />
                 </Route>
                <Route path="/updateCita/*" element={isCitaSelected ? <CambioCitaForm /> : <Navigate to="/myInfo" />} />
                    
               
                <Route path="*" element={<NotFound/> } />
            </Routes>
        </BrowserRouter>
    );
}

export default MenuInicial;
