import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { selectPacientes, fetchPacientes, selectLoading } from '../component/Paciente/PacienteSlice';
import Loading from '../component/Loading/Loading';
import NotFound from './NotFound';

function Paciente() {
    var pacientes = useSelector(selectPacientes);
    var loading: boolean = useSelector(selectLoading).match("pending") != null;
    var Dispatch = useDispatch();
    


    useEffect(() => {
        if (pacientes.length === 0) {
            Dispatch(fetchPacientes());
        }
    }, []);

    return (
        <div>
            
            {loading && <Loading />}
            {!loading && <NotFound/>}

        </div>        
        
    );



}

export default Paciente;
