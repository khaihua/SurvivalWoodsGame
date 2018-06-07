package com.example.khai.survivalwoods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class InventoryScreen extends AppCompatActivity {
    private ListView itemList;
    private TextView noItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_screen);
        itemList = findViewById(R.id.itemList);
        noItems = findViewById(R.id.noItems);
        noItems.setVisibility(View.INVISIBLE);
        Player player = (Player) getIntent().getSerializableExtra("player_data");
        int count = 20;
        for (int i=0;i<player.inventory.items.length;i++) {
            if (player.inventory.items[i] == null) {
                count--;
            }
        }
        String[] listItems = new String[count];
        for(int i = 0; i < count; i++){
            Item item = player.inventory.getItemAt(i);
            listItems[i] = item.getItemName() + " " + item.getCount();
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        itemList.setAdapter(adapter);
    }
}
