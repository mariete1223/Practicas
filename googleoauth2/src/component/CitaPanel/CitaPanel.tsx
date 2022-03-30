import { useDispatch, useSelector } from "react-redux";
import { Navigate, NavLink, useNavigate } from "react-router-dom";
import cita from "../../model/Cita";
import { deleteCita } from "../../service/citaService";
import { get_citas_pending, get_citas_received, selectCitas, selectCitaSelected, set_selected } from "../CitaState/CitaSlice";
import './CitaPanel.css';

interface Properties {
    cita: cita;
    /*key: ConstrainULong;*/
}

function CitaPanel({ cita }: Properties) {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const citas = useSelector(selectCitas);

    const updateCita = () => {
        dispatch(set_selected(cita));

        navigate("/updateCita");
    }

    const eliminarCita = () => {
        deleteCita(cita.citaId);
        dispatch(get_citas_pending(""));
        dispatch(get_citas_received(citas.filter((cita2) => { return cita2.citaId != cita.citaId })));
    }

    return (

        <div className="panelCita">
            <h2>Cita con {cita.medico.nombre + " " + cita.medico.apellidos}</h2>
            <p>Esta cita esta programada para el dia <span>{cita.fechaHora.toString()}</span>, con motivo "{cita.motivoCita}"</p>
            <p>Quiere <span>cambiar</span> la cita?</p>
            <div className="panelButton">

                <button onClick={updateCita}>Cambiar</button>
                <button onClick={eliminarCita}>Eliminar</button>
            </div>
            
        </div>
        
        
        );



}

export default CitaPanel;