package com.vottech.mobile.signup.data;

public interface SignUpListener
{
    void onSignUpSuccess(String response);
    void onSignUpFailure(String response);
}
