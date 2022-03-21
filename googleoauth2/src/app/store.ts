import { configureStore, ThunkAction, Action, getDefaultMiddleware } from '@reduxjs/toolkit';
import pacienteReducer from '../component/Paciente/PacienteSlice'
import authorizationReducer from '../component/Authorization/authorizationSlice'

export const store = configureStore({
    reducer: {
        paciente: pacienteReducer,
        authorization: authorizationReducer,
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
