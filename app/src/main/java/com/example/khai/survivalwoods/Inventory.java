package com.example.khai.survivalwoods;

import java.io.Serializable;

public class Inventory implements Serializable{
    private static final int MAX_INVENTORY_SIZE = 20;

    public Item[] items = new Item[MAX_INVENTORY_SIZE];

    public Inventory() {
    }

    public void addItem(Item item) {
        int slot = findFreeSlot();
        if (slot >= 0) {
            items[slot] = item;
        }
    }

    public Item removeItem(Item item) {
        for (int i=0;i<items.length;i++) {
            if (items[i].equals(item)) {
                Item temp = items[i];
                items[i] = null;
                return temp;
            }
        }

        return null;
    }

    public Item getItemAt(int index) {
        return items[index];
    }
    public int getInventorySize() {
        return MAX_INVENTORY_SIZE;
    }

    private int findFreeSlot() {
        for (int i=0;i<items.length;i++) {
            if (items[i] == null) {
                return i;
            }
        }

        return -1;
    }
}

