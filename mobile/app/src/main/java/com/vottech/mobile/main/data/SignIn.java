package com.vottech.mobile.main.data;

public class SignIn {

    private String userOrMail;
    private String password;

    public void setUserOrMail(String userOrMail)
    {
        this.userOrMail = userOrMail;
    }
    public String getUserOrMail()
    {
        return this.userOrMail;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }
}
