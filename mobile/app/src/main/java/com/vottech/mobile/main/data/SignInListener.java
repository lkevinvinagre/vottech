package com.vottech.mobile.main.data;

public interface SignInListener
{
    void onSignInSuccess(String response);
    void onSignInFailure(String response);
}
