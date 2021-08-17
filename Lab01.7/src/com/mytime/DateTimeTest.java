/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeTest {

    /**
     * main() calls each of the test methods in turn (currently commented out).
     * To run one test method at a time, uncomment the call to the one you want to execute.
     */
    public static void main(String[] args) {
        testNow();
        testCreate();
        testParse();
        testFormat();
    }

    /**
     * TASK: create current date, time, and date-time via now() and then print them.
     */
    public static void testNow() {
        // Current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("current date: " + currentDate);

        //Current time
        LocalTime localTime = LocalTime.now();
        System.out.println("current time: " + localTime);

        //Current date-time
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        System.out.println("current Local Date Time: " + currentLocalDateTime);


    }
    
    /**
     * TASK: implement the TODOs and print your results.
     */
    public static void testCreate() {
        // Done: create your birthday via of(). What day of the week were you born on?
        LocalDate birthday = LocalDate.of(1993, 04, 01);
        DayOfWeek dayOfWeek = birthday.getDayOfWeek();
        System.out.println("The day of the week you were born was on: " + dayOfWeek);
            
        // Done: use of() to create a value representing the 1st lunar landing - it happened on 7/20/69 at 3:18pm Eastern Time.
        // Note: ignore time-zone, just assume Eastern Time is the local time.
        LocalDateTime lunarLanding = LocalDateTime.of(1969,07, 20, 15, 18);
        System.out.println("The 1st lunar landing happened on: " + lunarLanding);
    }

    /**
     * TASK: implement the TODOs and print your results.
     */
    public static void testParse() {
        // Done: create your birthday by parsing a text representation in standard format.
        LocalDate birthday = LocalDate.parse("1993-04-01");
        System.out.println("Your birthday is: " + birthday);

        // OPTIONAL: now create it by parsing text in the form "2/6/2014" (this is Feb 6, not Jun 2).
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthday2 = LocalDate.parse("04/01/1993", dateFormatter);
        System.out.println("Your birthday is: " + DateTimeFormatter.ofPattern("04/01/1993", Locale.ENGLISH).format(birthday2));
    }
    
    /**
     * TASK: create formatted display strings for the date below, in the specified formats.
     */
    public static void testFormat() {
        LocalDate hastings = LocalDate.of(1066, 10, 14);
        
        // Done: 10/14/1066
        System.out.println("Date 14/10/1066 format is: " + DateTimeFormatter.ofPattern("10/14/1066", Locale.ENGLISH).format(hastings));
        
        // Done: 14-10-1066
        System.out.println("Date 14-10-1066 format is: " + DateTimeFormatter.ofPattern("10-14-1066", Locale.ENGLISH).format(hastings));

        // OPTIONAL: October 14, 1066
        System.out.println("Date October 14, 1066 format is: " + DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH).format(hastings));
    }
}