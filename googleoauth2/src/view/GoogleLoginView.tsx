import { render } from '@testing-library/react';
import React, { useEffect } from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import { GoogleLogin, GoogleLogout } from 'react-google-login';
import { useSelector, useDispatch } from 'react-redux';
import { selectGoogleToken, setGoogleToken, setLoggedIn, selectIsLoggedIn, authorice } from '../component/Authorization/authorizationSlice';
import { profile } from 'console';

function GoogleLoginView() {
    var dispatch = useDispatch();
    var loggedIn = useSelector(selectIsLoggedIn);
    var googleToken = useSelector(selectGoogleToken);

    const googleLogin = (response: any) => {
        console.log(response);
        dispatch(authorice(true, response));
    };

    const googleLogout = () => {
        dispatch(authorice(false, ''));
    };

    const prueba = () => {
        console.log(loggedIn);
        console.log(googleToken);
    }

    return (
            <div>

            {loggedIn  && <h1>Estas Logeado</h1>}
                    {!loggedIn && <h1>no estas logeado</h1>}
                    <button onClick={prueba}>AAA</button>
            {!loggedIn &&
                <GoogleLogin
                clientId="80071081849-ot7tl281gg8ksgukh4m1ce6fbsghg11j.apps.googleusercontent.com"
                buttonText="Login with Google"
                onSuccess={googleLogin}
                onFailure={googleLogin}
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
);
}

export default GoogleLoginView;
