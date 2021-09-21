package albums;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    }

    //create an object with today’s date (see Calendar class)
    public Date(){

    }

    //
    public Date(Date date){

    }

    //checking if date is valid
    public boolean isValid() {
    }

    //returns today's date
    public Date today(){
        return new Date();
    }

    //
    @Override
    public int compareTo(Date date) {

    }

    //
    @Overide
    public String toString(){
        return month + "/" + day + "/" + year;
    }

    //Gets the day of the Date obj
    public int getDay(){
        return day;
    }

    //Gets the month of the Date obj
    public int getMonth(){
        return month;
    }

    //Gets the year of the Date obj
    public int getYear(){
        return year;
    }
    //test bed
    public static void main(String[] args){

    }

}