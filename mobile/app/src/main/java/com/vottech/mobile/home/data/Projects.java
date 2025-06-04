package com.vottech.mobile.home.data;

public class Projects {

    private int banner;
    private String title;
    private String description;
    private int votes;

    public Projects(){}

    public void setBanner(int banner)
    {
        this.banner = banner;
    }
    public int getBanner()
    {
        return this.banner;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
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
