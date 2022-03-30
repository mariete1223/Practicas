import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import MenuInicial from './view/App';
import { store } from './app/store';
import { Provider, useSelector, useDispatch } from 'react-redux';
import * as serviceWorker from './serviceWorker';
import axios, { AxiosRequestConfig } from 'axios';
import { selectGoogleToken } from './component/AuthorizationState/authorizationSlice';



axios.interceptors.request.use(
    (req: AxiosRequestConfig) => {
        const token = store.getState().authorization.googleToken.tokenId;
        req.headers = {
            'Authorization': "Bearer " + token,
            'Access-Control-Allow-Origin': "http://localhost:3000",
            'Content-Type': "application/json; charset=utf-8"
        }
        /*req.headers['Authorization'] = "Bearer " + token;
        req.headers['Access-Control-Allow-Origin'] = "http://localhost:3000";
        req.headers['Content-Type'] = "application/json; charset=utf-8";*/
        
        return req;
    },
    (err) => {

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
