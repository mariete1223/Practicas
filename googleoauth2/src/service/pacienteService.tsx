import axios from "axios";
import { useSelector } from "react-redux";
import Global from "../Global"
import { selectGoogleToken } from '../component/Authorization/authorizationSlice'

export function fetchAll(){
    var url = Global.urlCentroMedico;
    var request = "/pacientes";
    return axios.get(url + request 
    ).then((response) => { return response; });
}
