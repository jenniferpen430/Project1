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

    public Date() {} //create an object with today’s date (see Calendar class)

    public boolean isValid() {}

    @Override
    public int compareTo(Date date) {

    }


}