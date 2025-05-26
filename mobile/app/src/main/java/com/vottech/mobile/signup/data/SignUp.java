package com.vottech.mobile.signup.data;

public class SignUp {

    private String name;
    private String email;
    private String password;
    private String faceData;
    private String imagePath;
    private String faceId;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setEmail()
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setFaceData(String faceData)
    {
        this.faceData = faceData;
    }

    public String getFaceData()
    {
        return this.faceData;
    }

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public String getImagePath()
    {
        return this.imagePath;
    }

    public void setFaceId(String faceId)
    {
        this.faceId = faceId;
    }

    public String getFaceId()
    {
        return this.faceId;
    }

    public SignUp(){}

}
