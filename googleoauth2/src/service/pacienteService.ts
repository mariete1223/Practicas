import axios from "axios";
import Global from "../Global"

export function fetchAllPacientes(){
    var url = Global.urlCentroMedico;
    var request = "/pacientes";
    return axios.get(url + request 
    ).then((response) => { return response; });
}
