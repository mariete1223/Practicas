import axios from "axios";
import Global from "../Global"

export function fetchAllMedicos() {
    var url = Global.urlCentroMedico;
    var request = "/medicos";
    return axios.get(url + request
    ).then((response) => { return response; });
}

