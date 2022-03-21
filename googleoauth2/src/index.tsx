import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import MenuInicial from './view/App';
import { store } from './app/store';
import { Provider, useSelector, useDispatch } from 'react-redux';
import * as serviceWorker from './serviceWorker';
import axios from 'axios';
import { selectGoogleToken } from './component/Authorization/authorizationSlice';
import { get_failure } from './component/Paciente/PacienteSlice';


axios.defaults.headers.common['Authorization'] = `${store.getState().authorization.googleToken.tokenId}`;
axios.interceptors.request.use(
    (req) => {
        console.log(req);
        return req;
    },
    (err) => {
        var Dispatch = useDispatch();
        Dispatch(get_failure(""));
        return Promise.reject(err);
    }
);

axios.interceptors.response.use(
    (req) => {
        return req;
    },
    (err) => {
       
        return Promise.reject(err);
    }
);
        

ReactDOM.render(
    <React.StrictMode>
        <Provider store={store}>
            <MenuInicial />
        </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
