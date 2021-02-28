package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    int[] images = {

        R.drawable.australia, R.drawable.bangladesh, R.drawable.bhutan,
        R.drawable.canada, R.drawable.china, R.drawable.denmark,
        R.drawable.england, R.drawable.finland, R.drawable.ghana,
        R.drawable.india, R.drawable.japan, R.drawable.pakistan

    };

    MyAdapter myAdapter;
    String [] title, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewId);

        title = getResources().getStringArray(R.array.country_names);
        desc = getResources().getStringArray(R.array.country_desc);

        myAdapter =  new MyAdapter(this, title, desc, images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Toast.makeText(getApplicationContext(), "onitem click : " + position, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onItemLongClick(int position, View v) {

                Toast.makeText(getApplicationContext(), "onitemlong click : " + position, Toast.LENGTH_LONG).show();

            }
        });

    }
}