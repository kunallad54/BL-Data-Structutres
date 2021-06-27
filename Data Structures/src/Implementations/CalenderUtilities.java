package Implementations;

public class CalenderUtilities {

    /**
     * Purpose : To check whether year is leap year or not
     * @param year taken from user
     * @return true if leap year else false
     */
    public static boolean isLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        return false;
    }

    /**
     * Purpose : Calculating day of week
     *
     * @param day input from user
     * @param month input from  user
     * @param year input from user
     * @return day from 0 to 6 ...0 means sunday and so on
     */
    public static int dayOfWeek(int day,int month,int year){
        int y1, x, m, d1;
        y1 = year - (14 - month) / 12;
        x = y1 + (y1 / 4) - (y1 / 100) + (y1 / 400);
        m = month + 12 * ((14 - month) / 12) - 2;
        d1 = (day + x + 31 * m / 12) % 7;
        return d1;
    }

    public static void printCalender(int day,int days){
        String[][] cal = new String[6][7];
        int temp;

    }


}
