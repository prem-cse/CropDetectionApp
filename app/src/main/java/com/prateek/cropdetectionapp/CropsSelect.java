package com.prateek.cropdetectionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class CropsSelect extends AppCompatActivity {

    GridView gridView;

    int images[] = {R.drawable.apple,R.drawable.beans,
            R.drawable.capsicum,
            R.drawable.citrus,
            R.drawable.cotton,
            R.drawable.grapes,
            R.drawable.cucumber,
            R.drawable.mango,
            R.drawable.maize,
            R.drawable.melon,
            R.drawable.cabbage,
            R.drawable.papaya,
            R.drawable.peanut,
            R.drawable.potato
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_crops_select);

        gridView = (GridView) findViewById(R.id.images_grid_view); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), images);
        gridView.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(CropsSelect.this, Selected.class);
                intent.putExtra("image", images[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });



    }
}
