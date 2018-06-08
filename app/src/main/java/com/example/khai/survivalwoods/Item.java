package com.example.khai.survivalwoods;

import java.io.Serializable;

public class Item implements Serializable{
        private String name;
        private int count;

        public Item(String name, int number){
                this.name = name;
                count = number;
        }
        public int Count(){
                return count;
        }
        public String getItemName(){
                return name;
        }
        public String getCount() {
                String countS = Integer.toString(count);
                return countS;
        }
        public void decreaseCount(){
                count = count - 1;
        }
        public void increaseCount(){
                count = count +1;
        }
}