import cita from "../model/Cita";
import React, { Fragment, useState } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { selectCitaSelected } from "../component/CitaState/CitaSlice";
import { useEffect } from "react";
import { updateCita } from "../service/citaService";
import { fetchMedicos, selectMedicos } from "../component/MedicoState/MedicoSlice";
import './CambioCitaForm.css';
import { useNavigate } from "react-router";


function CambioCitaRender() {


    var cita = useSelector(selectCitaSelected);
    var medicos = useSelector(selectMedicos);
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const [datos, setDatos] = useState({
        fechaHora: '',
        motivoCita: '',
        medico: '',

    })
   

    useEffect(() => {

        dispatch(fetchMedicos());

    }, []);

    const submit = (event) => {
        var newcita: cita = { ...cita };
        
        if (datos.motivoCita != "") {
            newcita.motivoCita = datos.motivoCita;
        }
        if (datos.fechaHora != "") {
            newcita.fechaHora = new Date(datos.fechaHora);
        }
        if (datos.medico != "") {
            const medico = findBy(datos.medico)
            if (medico == undefined) {
                navigate("/myInfo")
            }
            else {
                newcita.medico = medico;
            }
        }

        
        updateCita(newcita);
        navigate("/myInfo/MisCitas");
    }


    function findBy(medicoId: string) {
        return medicos.filter((medico) => {
            return String(medico.usuarioId) == medicoId;
        }).pop();
}




    const handleChange = (event) => {
        setDatos({
            ...datos,
            [event.target.name]: event.target.value
        })
       
    }

    const mostrar = () => {
        console.log(JSON.stringify(cita));
    }

    return (
        <div className="UpdateForm">
            <div className="form">
                <h2>Cambio Cita</h2>
                <div className="input">
                    <label>Hora de la Cita: </label>
                    <input onChange={handleChange} type="text" placeholder={cita.fechaHora.toString()} className="form-control" name="fechaHora"></input>
                    
                
                
                    <label>Seleccione Medico:</label><br/>
                    <select onChange={handleChange} name="nombreApellidos" className="ComboBox">
                        {medicos.map((medico) => <option key={String(medico.usuarioId)} value={String(medico.usuarioId)}>{medico.nombre + " " + medico.apellidos}</option>)}
                    </select>
                    <i></i>
                
                    <label> Motivo: </label>
                    <input onChange={handleChange} className="Ultimo" type="text" placeholder={cita.motivoCita} name="motivoCita"></input>

                    <button onClick={submit} className="btn btn-primary">Cambiar</button>
                </div>
                
            </div>
        </div>

    );

}

export default CambioCitaRender;