import cita from '../../model/Cita';
import { createSlice, Dispatch, PayloadAction } from '@reduxjs/toolkit';
import { AppDispatch, RootState } from '../../app/store';

import { fetchAllCitas } from '../../service/citaService';
import { setLoggedIn, setUsuario } from '../AuthorizationState/authorizationSlice';

interface CitaState {
    citas: cita[],
    loading: string,
    success:boolean,
    selected:cita,
};

const initialState: CitaState = {
    citas: [],
    loading: "idle",
    success: true,
    selected: {} as cita,

};

export const citaSlice = createSlice({

    name: 'citas',
    initialState,
    reducers: {
        get_citas_pending: (state, action: any) => {
            if (state.loading == 'idle') {
                state.loading = "pending";
            }
        },
        get_citas_failure: (state, action: PayloadAction<any>) => {
            if (state.loading == "pending") {
                state.loading = "idle";
                state.success = false;
            }
        },
        get_citas_received: (state, action: PayloadAction<cita[]>) => {
            if (state.loading == "pending") {
                state.loading = "idle";
                state.citas = action.payload;
                state.success = true;
            }
        },
        set_selected: (state, action: PayloadAction<cita>) => {
            state.selected = action.payload;
        }
    },
});

export const { get_citas_received, get_citas_failure, get_citas_pending, set_selected } = citaSlice.actions;

export const selectCitas = (state: RootState) => state.cita.citas;
export const selectCitaLoading = (state: RootState) => state.cita.loading;
export const selectCitaSelected = (state: RootState) => state.cita.selected;


export const fetchCitas = () => async (dispatch: AppDispatch) => {
    dispatch(get_citas_pending(""));
    await fetchAllCitas().then(res => { 
        dispatch(get_citas_received(res.data))
        dispatch(setUsuario(res.headers.Role))
        })
        .catch(err => {
            dispatch(get_citas_failure(""));
            //asumo que es porq el token era invalido
            dispatch(setLoggedIn(false));
            return Promise.reject(err);

        });


}

export default citaSlice.reducer;