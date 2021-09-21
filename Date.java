package albums;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //test bed main
    public static void main(String[] args) {
        Date date1 = new Date("09/19/2001");
        System.out.println("this date is " + date1.isValid());

        Date date2 = new Date("10/25/2022");
        System.out.println("this date is " + date2.isValid());

        Date date3 = new Date("04/23/2020");
        System.out.println("this date is " + date3.isValid());
    }


    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");

        this.month = Integer.parseInt(st.nextToken().trim());
        this.day = Integer.parseInt(st.nextToken().trim());
        this.year = Integer.parseInt(st.nextToken().trim());

    }

    //create an object with today’s date (see Calendar class)
    public Date(){
        int MONTH_OFFSET = 1;

        Calendar today = Calendar.getInstance();

        this.day = today.get(Calendar.DAY_OF_MONTH);
        this.month = today.get(Calendar.MONTH) + MONTH_OFFSET;
        this.year = today.get(Calendar.YEAR)
    }

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPETEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    public static final int YEAR_MIN = 1980;
    public static final int DAY_NORM = 30;
    public static final int DAY_MAX = 31;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int LEAP_DAYS = 29;
    public static final int NON_LEAP = 28;
    public static final int DAY_MIN = 28;

    //checking if date is valid
    public boolean isValid() {
        Date todaysDate = new Date();

        if(year < YEAR_MIN || year > Calendar.getInstance().get(Calendar.YEAR) || (year == Calendar.getInstance().get(Calendar.YEAR) && month>Calendar.getInstance().get(Calendar.MONTH))
                || (year==Calendar.getInstance().get(Calendar.YEAR) && month==Calendar.getInstance().get(Calendar.MONTH)
                && day>Calendar.getInstance().get(Calendar.DAY_OF_MONTH))){
            return false;
        }
        else if(month < JANUARY || month < DECEMBER || day < DAY_MIN){
            return false;
        }
        else if((month == JANUARY  || month == MARCH || month  == MAY || month  == JULY || month == AUGUST || month  == OCTOBER || month == DECEMBER) && day > DAY_MAX ){
            return false;
        }
        else if((month == APRIL || month == JUNE || month == SEPETEMBER || month ==  NOVEMBER) && day > DAY_NORM){
            return false;
        }
        else if (month == FEBRUARY) { //check leap year
            if (year % QUADRENNIAL == 0) { //STEP 1
                if (year % CENTENNIAL == 0) { //STEP 2
                    if (year % QUATERCENTENNIAL == 0) { //STEP 3
                        if (day > LEAP_DAYS) { //STEP 4
                            return false;
                        }
                    } else { //STEP 5
                        if (day > NON_LEAP) {
                            return false;
                        }
                    }
                } else {
                    if (day > LEAP_DAYS) {
                        return false;
                    }
                }
            } else {
                if (day > NON_LEAP) {
                    return false;
                }
            }
        }
        return true;
    }


    //
    @Override
    public int compareTo(Date date) {
        int GREATER = 1;
        int LESSTHAN = -1;
        int EQUAL = 0;
        // 09/19/1990 vs 09/18/1991 should return -1
        // 09/19/1991 vs 09/18/1990 should return 1
        // 09/19/1990 vs 08/18/1990 should return 1
        if(year > date.getYear() || (year == date.getYear() && month > date.getMonth()) ||  ){
            return GREATER;
        }
        else if(){
            return LESSTHAN;
        }
        return EQUAL;
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

}