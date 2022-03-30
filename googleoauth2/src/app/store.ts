import { configureStore, ThunkAction, Action, getDefaultMiddleware } from '@reduxjs/toolkit';
import pacienteReducer from '../component/PacienteState/PacienteSlice';
import authorizationReducer from '../component/AuthorizationState/authorizationSlice';
import citaReducer from '../component/CitaState/CitaSlice';
import medicoReducer from '../component/MedicoState/MedicoSlice';

export const store = configureStore({
    reducer: {
        paciente: pacienteReducer,
        authorization: authorizationReducer,
        cita: citaReducer,
        medico: medicoReducer,
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({ serializableCheck: false }),
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
