package com.example.khai.survivalwoods;

public class Item{
        private String name;
        private int count;

        public Item(String name, int id){
                this.name = name;
                count = 1;
        }
        public String getItemName(){
                return name;
        }

}
