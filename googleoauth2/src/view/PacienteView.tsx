import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { fetchCitas, selectCitaLoading, selectCitas } from '../component/CitaState/CitaSlice';
import Loading from '../component/Loading/Loading';
import { Link , Outlet, Route, Routes } from 'react-router-dom';
import NotFound from './NotFound';
import Citas from '../component/CitasView/Citas';
import './PacienteView.css';
import SideNav from '../component/SideBar/SideBar';

function Paciente() {
    var citas = useSelector(selectCitas);
    var loading: boolean = useSelector(selectCitaLoading).match("pending") != null;
    var Dispatch = useDispatch();


    useEffect(() => {
        
        Dispatch(fetchCitas());
        
    }, []);

    const mostrar = () => {
        console.log(citas);
    }

    return (
        <div className="PacienteView-Container">
           
            <Outlet/>
            {loading && <Loading />}
            

        </div>        
        
    );
}

export default Paciente;
/*{!loading &&
                < Citas />}*/