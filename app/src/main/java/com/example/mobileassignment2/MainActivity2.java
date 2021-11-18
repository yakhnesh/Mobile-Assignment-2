package com.example.mobileassignment2;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText addresstxt, lat_txt, lon_txt;
    Button adddb ,viewb;
    DBHandler dbHandler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addresstxt = findViewById(R.id.a_txt);
        lat_txt = findViewById(R.id.Lat_txt);
        lon_txt = findViewById(R.id.long_txt);
        adddb = findViewById(R.id.add_button);
        viewb = findViewById(R.id.view_button);

        dbHandler = new DBHandler(MainActivity2.this);

        adddb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_Address = addresstxt.getText().toString();
                String str_Latitude =lat_txt.getText().toString();
                String str_Longitude = lon_txt.getText().toString();

                if (str_Address.isEmpty() && str_Latitude.isEmpty() && str_Longitude.isEmpty() ) {
                    Toast.makeText(MainActivity2.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNew(str_Address, str_Latitude, str_Longitude);
                Toast.makeText(MainActivity2.this, "geocode has been added", Toast.LENGTH_SHORT).show();
                addresstxt.setText("");
                lat_txt.setText("");
                lon_txt.setText("");
            }
        });

        viewb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, ViewGeo.class);
                startActivity(intent);
            }
        });


    }
}