package com.example.task;

public class Venues {
    String Name;
    String Category;
    String Icon;
    String Address;
    String latitude;
    String longitude;
    Double latitudeDouble;
    Double longitudeDouble;

    public void setAddress(String address) {
        this.Address = address;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public void setIcon(String icon) {
        this.Icon = icon;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Double getLatitude() {
        latitudeDouble = Double.parseDouble(latitude);
        return latitudeDouble;
    }

    public Double  getLongitude() {
        longitudeDouble= Double.parseDouble(longitude);
        return longitudeDouble;
    }

    public String getAddress() {
        Address.replace("[","");
        return Address;
    }

    public String getIcon() {

        return Icon;
    }

    public String getCategory() {
        return Category;
    }

    public String getName() {
        return Name;
    }

}
