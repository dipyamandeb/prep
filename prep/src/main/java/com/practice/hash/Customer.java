package com.practice.hash;

public class Customer {
    private int id;
    @Override
    public int hashCode() {
        return id;
    }
     
    public boolean equals(Object obj){
        return true;
    }
    private String name;
     
    Customer(int id,String name){
        this.id = id;
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
     
}