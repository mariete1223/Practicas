import { useState } from "react";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router";
import { selectEmail } from "../component/AuthorizationState/authorizationSlice";
import { fetchMedicos, selectMedicos } from "../component/MedicoState/MedicoSlice";
import cita from "../model/Cita";
import diagnosticoDTO from "../model/DiagnosticoDTO";
import paciente from "../model/Paciente";
import pacienteDTO from "../model/PacienteDTO";
import { postCita } from "../service/citaService";
import { findBy } from "../service/medicoService";
import './NuevaCitaForm.css';


function NuevaCitaForm() {
    var errorCampos = false;
    var medicos = useSelector(selectMedicos);
    const emailUsuario = useSelector(selectEmail);
    const dispatch = useDispatch();
    useEffect(() => {

        dispatch(fetchMedicos());

    }, []);

    const navigate = useNavigate();
    const [datos, setDatos] = useState({
        fechaHora: '',
        motivoCita: '',
        medico: 'no valido',


    });

    const submit = (event) => {
        const diagnostico: diagnosticoDTO = {
            enfermedad: "dolor de cabeza",
            valoracionEspecialista: "tomar ibuprofeno"
        };

        const paciente: pacienteDTO = {
            nombre: "",
            apellidos: "",
            direccion: "",
            email: emailUsuario,
            NSS: "",
            numTarjeta: "",
            telefono: "",
        };
       
        var medico = findBy(medicos, datos.medico);
        if (medico != undefined && datos.fechaHora != ""  && datos.motivoCita!="") {
            var newcita: cita = {
                citaId: 0,
                fechaHora: new Date(datos.fechaHora),
                motivoCita: datos.motivoCita,
                medico: medico,
                attribute11: 3,
                diagnostico: diagnostico,
                paciente: paciente,


            };
           
            errorCampos = false;
            postCita(newcita);
            navigate("/myInfo/MisCitas");
        }
        else {
            var p = document.getElementById("Aviso");
            if (p != null) {
                p.style.display = "block";
            }

            var icon = document.getElementById("image1");
            if (icon != null) {
                icon.style.top = "calc(50% - 12px)";
            }
           
            const inputs = document.getElementsByTagName("input");
            for (var i = 0; i < inputs.length; i++) {
                inputs[i].value = "";
            }
        };
       
    };




    const handleChange = (event) => {
        console.log(event);
        setDatos({
            ...datos,
            [event.target.name]: event.target.value
        })

    };

    return (
        <div className="UpdateForm">
            <div id="Cita-new-form" className="form">
                <h2>Nueva Cita</h2>
                <div className="input">
                    <label>Hora de la Cita: </label>
                    <input onChange={handleChange}  type="text" placeholder="Hora" className="form-control" name="fechaHora"></input>



                    <label>Seleccione Medico:</label><br />
                    <select onChange={handleChange}  name="medico" className="ComboBox" defaultValue="no valido" >
                        <option  value="no valido">Ninguno</option>
                        {medicos.map((medico) => <option key={String(medico.usuarioId)} value={String(medico.usuarioId)}>{medico.nombre + " " + medico.apellidos}</option>)}
                    </select>
                    <i id="image1"></i>

                    <label> Motivo: </label>
                    <input onChange={handleChange} className="Ultimo" type="text" placeholder="Motivo cita" name="motivoCita"></input>
                    <p id="Aviso">*Rellene todos los campos</p>
                    <button onClick={submit} className="btn btn-primary">Crear Cita</button>
                </div>

            </div>
        </div>
    );
}

export default NuevaCitaForm;