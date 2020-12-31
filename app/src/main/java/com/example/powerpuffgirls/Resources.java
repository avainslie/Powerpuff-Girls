package com.example.powerpuffgirls;

public class Resources {

    private String Name;
    private String Description;
    private String Link;


    // Need this for FireStore
    public Resources() { }

    public Resources(String name, String description, String link) {
        Name = name;
        Description = description;
        Link = link;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
