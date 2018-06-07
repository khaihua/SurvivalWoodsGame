package com.example.khai.survivalwoods;

import java.io.Serializable;

public class Player implements Serializable{
    String name;
    private int health;
    private int hunger;
    private int thirst;
    Inventory inventory = new Inventory();

    {
        health = 100;
        hunger = 100;
        thirst = 100;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void changeHealth(int n){
        health = health + n;
    }
    public int getHealth(){
        return health;
    }
    public void changeHunger(int n){
        hunger = hunger + n;
        if(hunger < 0){
            hunger = 0;
        }
    }
    public int getHunger(){
        return hunger;
    }
    public void changeThirst(int n){
        thirst = thirst + n;
        if(thirst < 0){
            thirst = 0;
        }
    }
    public int getThirst(){
        return thirst;
    }
}
