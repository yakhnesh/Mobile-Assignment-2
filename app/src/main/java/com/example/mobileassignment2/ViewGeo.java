package com.example.mobileassignment2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewGeo extends AppCompatActivity {
    private ArrayList<GeoModel> geoModelArrayList;
    private DBHandler dbHandler;
    private GeoRVAdapter geoRVAdapter;
    private RecyclerView geoRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);

        geoModelArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewGeo.this);

        geoModelArrayList = dbHandler.readGeo();


        geoRVAdapter = new GeoRVAdapter(geoModelArrayList, ViewGeo.this);
        geoRV = findViewById(R.id.idRVGeo);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewGeo.this, RecyclerView.VERTICAL, false);
        geoRV.setLayoutManager(linearLayoutManager);

        geoRV.setAdapter(geoRVAdapter);
    }
}

