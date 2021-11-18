package com.example.mobileassignment2;

public class GeoModel {
    private String Address;
    private String Latitude;
    private String Longitude;
    private int id;

    public String getAddress(){
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }
    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GeoModel(String Address, String Latitude, String Longitude){
        this.Address = Address;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }

}
