import cita from '../../model/Cita';
import { createSlice, Dispatch, PayloadAction } from '@reduxjs/toolkit';
import { AppDispatch, RootState } from '../../app/store';

import { fetchAllCitas } from '../../service/citaService';
import { setLoggedIn, setUsuario } from '../AuthorizationState/authorizationSlice';
import medico from '../../model/medico';
import { fetchAllMedicos } from '../../service/medicoService';

interface MedicoState {
    medicos: medico[],
    loading: string,
    success: boolean,
};

const initialState: MedicoState = {
    medicos: [],
    loading: "idle",
    success: true,


};

export const citaSlice = createSlice({

    name: 'medicos',
    initialState,
    reducers: {
        get_medicos_pending: (state, action: any) => {
            if (state.loading == 'idle') {
                state.loading = "pending";
            }
        },
        get_medicos_failure: (state, action: PayloadAction<any>) => {
            if (state.loading == "pending") {
                state.loading = "idle";
                state.success = false;
            }
        },
        get_medicos_received: (state, action: PayloadAction<medico[]>) => {
            if (state.loading == "pending") {
                state.loading = "idle";
                state.medicos = action.payload;
                state.success = true;
            }
        },
    },
});

export const { get_medicos_failure, get_medicos_pending, get_medicos_received } = citaSlice.actions;

export const selectMedicos = (state: RootState) => state.medico.medicos;
export const selectMedicoLoading = (state: RootState) => state.medico.loading;


export const fetchMedicos = () => async (dispatch: AppDispatch) => {
    dispatch(get_medicos_pending(""));
    await fetchAllMedicos().then(res => {
        dispatch(get_medicos_received(res.data))
        dispatch(setUsuario(res.headers.Role))
    })
        .catch(err => {
            dispatch(get_medicos_failure(""));
            //asumo que es porq el token era invalido
            dispatch(setLoggedIn(false));
            return Promise.reject(err);

        });


}

export default citaSlice.reducer;