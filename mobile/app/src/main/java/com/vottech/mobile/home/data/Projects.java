package com.vottech.mobile.home.data;

public class Projects {

    private int id;
    private String name;
    private String description;
    private int votes;

    public Projects(){}

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setVotes(int votes)
    {
        this.votes = votes;
    }
    public int getVotes()
    {
        return this.votes;
    }
}
