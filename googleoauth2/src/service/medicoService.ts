import axios from "axios";
import Global from "../Global"
import medico from "../model/medico";

export function fetchAllMedicos() {
    var url = Global.urlCentroMedico;
    var request = "/medicos";
    return axios.get(url + request
    ).then((response) => { return response; });
}

export function findBy(medicos:medico[],medicoId: string) {
    return medicos.filter((medico) => {
        return String(medico.usuarioId) == medicoId;
    }).pop();
}