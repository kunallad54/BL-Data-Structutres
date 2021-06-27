/*******************************************************************************************************
 *
 * Purpose : A program Calendar.java that takes the month and year as command-line
 *           arguments and prints the Calendar of the month. Store the Calendar in an 2D Array,
 *           the first dimension the week of the month and the second dimension stores the day
 *           of the week.Prints Calendar in 2D form
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 *
 ********************************************************************************************************/

package DataStructureMain;
import java.util.Scanner;

public class Calender {

    /**
     * Purpose : Calculating the day of week
     *
     * @param month input from user
     * @param day input from user
     * @param year input from user
     * @return day from 0 to 6 ...0 is Sunday and so on
     */
    public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

    /**
     * Purpose : To check whether year is leap year or not
     *
     * @param year taken from user
     * @return true if leap year else false
     */
    public static boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
        if  (year % 400 == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Command - line arguments
        //int month = Integer.parseInt(args[0]);    // month (Jan = 1, Dec = 12)
        //int year = Integer.parseInt(args[1]);     // year

        System.out.println("Enter the month : ");
        int month = scanner.nextInt();
        System.out.println("Enter the year : ");
        int year = scanner.nextInt();

        // months[i] = name of month i
        String[] months = {
                "",                               // leave empty so that months[1] = "January"
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };

        // days[i] = number of days in month i
        int[] days = {
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        // check for leap year if yes then feb will have 29 days
        if (month == 2 && isLeapYear(year))
            days[month] = 29;


        // print calendar header
        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");

        // starting day
        int d = day(month, 1, year);

        // print the calendar
        for (int i = 0; i < d; i++)
            System.out.print("   ");
        for (int i = 1; i <= days[month]; i++) {
            System.out.printf("%2d ",i);
            if (((i + d) % 7 == 0) || (i == days[month]))
                System.out.println();
        }

    }
}