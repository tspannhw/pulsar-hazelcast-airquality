package com.pulsardeveloper.pulsarhazelcastairquality.models;

import java.util.StringJoiner;

public class Category {

    private Integer Number;
    private String Name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
        super();
    }

    /**
     * 
     * @param number
     * @param name
     */
    public Category(Integer number, String name) {
        super();
        this.Number = number;
        this.Name = name;
    }

    public Integer getNumber() {
        return Number;
    }
    public void setNumber(Integer number) {
        this.Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Category.class.getSimpleName() + "[", "]")
                .add("number=" + Number)
                .add("name='" + Name + "'")
                .toString();
    }
}