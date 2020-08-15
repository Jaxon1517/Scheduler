package com.example.scheduler;

public class ActivityPosts {
    String Title;
    String Desc;

    public ActivityPosts(){}

    public ActivityPosts(String Title, String Desc){
        this.Title = Title;
        this.Desc = Desc;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDesc() {
        return Desc;
    }
    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

}

