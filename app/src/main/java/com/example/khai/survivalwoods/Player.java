package com.example.khai.survivalwoods;
import java.io.Serializable;

public class Player implements Serializable {
    String name;
    private int health;
    private int hunger;
    private int thirst;
    Inventory items = new Inventory();

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
    }
    public int getHunger(){
        return hunger;
    }
    public void changeThirst(int n){
        thirst = thirst + n;
    }
    public int getThirst(){
        return thirst;
    }
}
