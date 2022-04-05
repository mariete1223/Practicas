import axios from "axios";
import Global from "../Global"
import cita from "../model/Cita";

export function fetchAllCitas() {
    var url = Global.urlCentroMedico;
    var request = "/citas";
    return axios.get(url + request
    ).then((response) => { return response; });
}

export function updateCita(cita:cita) {
    var url = Global.urlCentroMedico;
    var request = "/citas/" + cita.citaId;


    return axios.put(url+request,
        JSON.stringify(cita)

    ).then((response) => { return response; });
}

export function deleteCita(citaId: ConstrainULong) {
    var url = Global.urlCentroMedico;
    var request = "/citas/" + citaId;

    return axios.delete(url+request
     
    ).then((response) => { return response; });
}

export function postCita(cita: cita) {
    var url = Global.urlCentroMedico;
    var request = "/citas";

    return axios.post(url + request,
        JSON.stringify(cita)
    ).then((response) => { return response; });
}
