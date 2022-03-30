import paciente from '../../model/Paciente'
import { createSlice, Dispatch, PayloadAction } from '@reduxjs/toolkit';
import { AppDispatch, RootState } from '../../app/store';

import { fetchAllPacientes } from '../../service/pacienteService';

interface PacienteState {
    pacientes: paciente[],
    loading: string,
};

const initialState: PacienteState = {
    pacientes: [],
    loading: "idle",

};

export const pacienteSlice = createSlice({

    name: 'pacientes',
    initialState,
    reducers: {
        get_pacientes_pending: (state, action: any) => {
            if (state.loading == 'idle') {
                state.loading = "pending";
            }
        },
        get_pacientes_failure: (state, action: PayloadAction<any>) => {
            if (state.loading == "pending") {
                state.loading = "idle";
            }
        },
        get_pacientes_received: (state, action: PayloadAction<paciente[]>) => {
            if (state.loading == "pending") {
                state.loading = "idle";
                state.pacientes = action.payload;
            }
        },
    },
});

export const { get_pacientes_pending, get_pacientes_received, get_pacientes_failure } = pacienteSlice.actions;

export const selectPacientes = (state: RootState) => state.paciente.pacientes;
export const selectPacientesLoading = (state: RootState) => state.paciente.loading;
function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
export const fetchPacientes = () => async (dispatch: AppDispatch) => {
    dispatch(get_pacientes_pending(""));
    delay(100);
     await fetchAllPacientes().then(res =>
                        dispatch(get_pacientes_received(res.data)))
         .catch(err => {
             dispatch(get_pacientes_failure(""));
             return Promise.reject(err);

         });
    

}

export default pacienteSlice.reducer;