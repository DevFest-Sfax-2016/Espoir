package com.espoir.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.espoir.app.AdapterGridView.CustomAdapter;
import com.espoir.app.AdapterGridView.ItemObject;

import java.util.ArrayList;
import java.util.List;

public class Types extends AppCompatActivity {
GridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mGridView=(GridView) findViewById(R.id.gridViewGallery);
        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), allItems);
        mGridView.setAdapter(customAdapter);



    }
    private List<ItemObject> getAllItemObject() {

        List<ItemObject> items = new ArrayList<>();
    items.add(new ItemObject("PHOTOGRAPHIE", "one"));
    items.add(new ItemObject("PEINTURE", "fete"));
    items.add(new ItemObject("THEATRE", "for"));
    items.add(new ItemObject("MUSIQUE", "coiffure"));
    items.add(new ItemObject("MODE", "five"));
    return items; }
}
