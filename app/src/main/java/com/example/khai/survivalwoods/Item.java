package com.example.khai.survivalwoods;

import java.io.Serializable;

public class Item implements Serializable{
        private String name;
        private int count;

        public Item(String name){
                this.name = name;
                count = 1;
        }
        public String getItemName(){
                return name;
        }
        public String getCount() {
                String countS = Integer.toString(count);
                return countS;
        }
}