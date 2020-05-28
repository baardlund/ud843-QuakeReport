package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Earthquake {

    // @param magnitude earth quake magnitude
    private double magnitude;

    // @param city location of earthquake
    private String location, distance, direction, city;

    // @param date , the  date of the earthquake

    private long dateUnix;
    private Date date;


    private String url;





    public Earthquake(double magnitude, String location, long date, String url) {
        this.magnitude = magnitude;
        this.location = location;
        splitLocation(location);
        this.dateUnix = date;
        this.date = new Date(date);
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    private void splitLocation(String location){
        city="";
        Pattern pattern = Pattern.compile("^\\d");
        Matcher m = pattern.matcher(location);
        if(m.find()) {
            String[] loc = location.split(" ");
            distance = loc[0];
            direction = loc[1];

            for (int i = 3; i <  loc.length; i++) {
                city += loc[i] + " ";
            }
        }
        else{
            city = location;
            distance="";
            direction="";
            }
    }

    public String getLocationOffset(){
        if(distance=="" && direction=="")
            return "";
        else
            return distance + " " + direction + " of";
    }

    public String getPrimaryLocation(){
        return city;
    }


    //dirty code on time formats, clean up later...
    public String getDateToDisplay(){
        return formatDate(date) + " " + formatTime(date);
    }

    public String getDate() {
        return  formatDate(date);
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("DD, MMM, yyyy");
        return dateFormatter.format(dateObject);
    }

    public String getTime(){
        return formatTime(date);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:MM");
        return timeFormat.format(dateObject);
    }

    public String getUrl(){
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
}