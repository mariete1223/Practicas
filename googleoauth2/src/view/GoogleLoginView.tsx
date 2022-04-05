import { render } from '@testing-library/react';
import React, { useEffect } from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import { GoogleLogin, GoogleLogout } from 'react-google-login';
import { useSelector, useDispatch } from 'react-redux';
import "./GoogleLoginView.css";
import { selectGoogleToken, setGoogleToken, setLoggedIn, selectIsLoggedIn, authorice, setEmail } from '../component/AuthorizationState/authorizationSlice';
import { profile } from 'console';
import loginImg from  '../assets/login.png';

function GoogleLoginView() {
    var dispatch = useDispatch();
    var loggedIn = useSelector(selectIsLoggedIn);
    var googleToken = useSelector(selectGoogleToken);

    const googleLogin = (response: any) => {
        console.log(response);
        dispatch(authorice(true, response));
        console.log(response.profileObj.email);
        dispatch(setEmail(response.profileObj.email));
    };

    const googleLogout = () => {
        dispatch(authorice(false, ''));
    };

    const prueba = () => {
        console.log(loggedIn);
        console.log(googleToken);
    }

    return (
        <div className="backgroundcover">
        <div className="container">

            <div className="loginImage">
                <img src={loginImg} width="300" style={{ position: 'relative' }} alt="login" />
            </div>
            <div className="GoogleDiv">

                <h1>Login</h1>
                <div>
                {!loggedIn &&
                <GoogleLogin
                clientId="80071081849-ot7tl281gg8ksgukh4m1ce6fbsghg11j.apps.googleusercontent.com"
                buttonText="Login with Google"
                onSuccess={googleLogin}
                //onFailure={googleLogin}
                cookiePolicy="single_host_origin"
                uxMode="redirect"
                redirectUri="http://localhost:3000"
                isSignedIn={true}
                />}

                {loggedIn &&
                <GoogleLogout
                    clientId="80071081849-ot7tl281gg8ksgukh4m1ce6fbsghg11j.apps.googleusercontent.com"
                    buttonText="LogOut with google"
                    onLogoutSuccess={googleLogout}
                    onFailure={googleLogout}
                />
                }
                </div>


            </div>
            </div>
        </div>
);
}

export default GoogleLoginView;
