import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { AppDispatch, RootState } from '../../app/store';
import medico from '../../model/medico';
import paciente from '../../model/Paciente';
import usuario from '../../model/UsuarioDTO';

//clase autorizacion con sus atributos, representa el estado
interface AuthorizationState {
    loggedIn: boolean,
    googleToken: any,
    usuario?: string,
    email: string,
    
};

//estado inicial de state para este slice
const initialState: AuthorizationState = {
    loggedIn: false,
    googleToken: '',
    email: '',
};


// creamos actions asociados a los reducers establecidos
export const authorizationSlice = createSlice({
    name: 'authorization',
    initialState,
    reducers: {
        setLoggedIn: (state, action: PayloadAction<boolean>) => {
            state.loggedIn = action.payload;
        },
        setGoogleToken: (state, action: PayloadAction<any>) => {
            state.googleToken = action.payload;
        },
        setUsuario: (state, action: PayloadAction<string>) => {
            state.usuario = action.payload;
        },
        setEmail: (state, action: PayloadAction<string>) => {
            state.email = action.payload;
        }
    },
});

export const authorice = (log:boolean, token:any) => async (dispatch: AppDispatch) => {
    dispatch(setGoogleToken(token));
    dispatch(setLoggedIn(log));

}



//three actions used to change his respective value of the Redux State
export const { setLoggedIn, setGoogleToken, setUsuario, setEmail } = authorizationSlice.actions;

export const selectIsLoggedIn = (state: RootState) => state.authorization.loggedIn;
export const selectGoogleToken = (state: RootState) => state.authorization.googleToken;
export const selectUsuario = (state: RootState) => state.authorization.usuario;
export const selectEmail = (state: RootState) => state.authorization.email;


export default authorizationSlice.reducer;

