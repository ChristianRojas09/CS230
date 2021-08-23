package com.gamingroom;

public class Entity {

    private long id;
    private String name;

    public Entity() { //default constructor
        this.id = 0;
        this.name = "";
    }
    //Constructor for id and name
    public Entity(long id, String name) {
        //call the default constructor:
        this();
        this.id = id;
        this.name = name; 
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Entity [id = " + id + ", name = " + name + "]"; 
    }
}
