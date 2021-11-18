package com.example.mobileassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    EditText latitude;
    EditText longitude;
    Button getAddress;
    TextView addresstxt;
    Button databasePress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitude = (EditText)findViewById(R.id.textview_latitude);
        longitude = (EditText)findViewById(R.id.textview_longitude);
        getAddress = (Button) findViewById(R.id.button_address);
        addresstxt = (TextView) findViewById(R.id.textview_getAddress);
        databasePress = (Button)findViewById(R.id.database_button);

        getAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double str_latitude = Double.parseDouble(latitude.getText().toString());
                double str_longitude = Double.parseDouble(longitude.getText().toString());
                String Addr = "";
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocation(str_latitude, str_longitude, 1);
                    StringBuilder strReturnedAddress = new StringBuilder("");
                    strReturnedAddress.append(addresses.get(0).getAddressLine(0));
                    Addr = strReturnedAddress.toString();
                    addresstxt.setText(Addr);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        databasePress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}