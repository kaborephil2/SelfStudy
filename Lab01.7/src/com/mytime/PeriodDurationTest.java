/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime;

import java.time.*;

public class PeriodDurationTest {

    /**
     * main() calls each of the test methods in turn (currently commented out).
     * To run one test method at a time, uncomment the call to the one you want to execute.
     */
    public static void main(String[] args) {
        testAgeDifference();
        testNextBirthday();
        testNextHalleysComet();
        testPerformance();
        testSpecialEvent();
    }

    /**
     * TASK: what is the age difference (in years and months)
     * between your parents, or any other 2 people you know?
     * Note: do not round up or down to the nearest month, just ignore any extra days.
     * 
     * RESULT:
     */
    public static void testAgeDifference() {
        // Done
        LocalDate friend1 = LocalDate.of(1989,12,9);
        LocalDate friend2 = LocalDate.of(1993, 4, 1);
        Period ageDifference = Period.between(friend1, friend2);
        System.out.println("Age difference is :" + ageDifference.getYears() + " year " + ageDifference.getMonths() + " Months");
    }

    /**
     * TASK: how long is it until your next birthday (in months and days)?
     * Note: for testability, you can hardcode today's date using of(), instead of using now().
     * Note: consider using the until() method of LocalDate to determine the answer (more API exposure).
     * 
     * RESULT: 
     */
    public static void testNextBirthday() {
        // Done
        int year = Year.now().getValue();

        LocalDate today = MonthDay.of(8,19).atYear(year);
        LocalDate mybirthday = MonthDay.of(10, 1).atYear(year);

        Period dayOfBirthday = today.until(mybirthday);
        System.out.println("Birthday date: " + dayOfBirthday.getMonths() + " Months " + dayOfBirthday.getDays() + " days");
    }
    
    /**
     * TASK: Halley's comet orbits the sun every 75-76 years, and was last seen from Earth in 1986.
     *  1. Model its orbit as an integral number of years, using Period or Duration as appropriate.
     *  2. Calculate the year of its next appearance on Earth.
     * Note: consider using the Year class (more API exposure).
     * 
     * RESULT:
     */
    public static void testNextHalleysComet() {
        // Done
        Period orbitDate = Period.ofYears(75);
        Year last = Year.of(1986);
        Year next = last.plus(orbitDate);
        System.out.println("next appearance on Earth: " + next);
    }
    
    /**
     * TASK: run the test below and compare the results of these two techniques to measure execution time of a method:
     *  - System.nanoTime() before and after the call, then get the difference and convert to millis.
     *  - Instant.now() before and after the call, then get the Duration between them and convert to millis.
     * 
     * RESULT:
     *  System.nanoTime() is more precise. Read the Javadoc for this method, and then for Instant.now().
     *  See also http://stackoverflow.com/questions/20689055/java-8-instant-now-with-nanosecond-resolution.
     */
    public static void testPerformance() {
        long start1 = System.nanoTime();
        businessWork();
        long end1 = System.nanoTime();
        
        double elapsedMillis1 = (end1 - start1) / 1_000_000.0;
        System.out.println("Execution time (ms) via System.nanoTime(): " + elapsedMillis1);
        
        
        Instant start2 = Instant.now();
        businessWork();
        Instant end2 = Instant.now();
        
        Duration duration = Duration.between(start2, end2);
        double elapsedMillis2 = duration.toNanos() / 1_000_000.0;
        System.out.println("Execution time (ms) via Instant.now(): " + elapsedMillis2);
    }
    
    /**
     * OPTIONAL: scientists have found that something very special occurs in regular intervals,
     * specifically every 5 hours, 5 minutes, and 5 seconds.
     * For testing purposes, the last special event occurred on Feb 18, 2020 at 10:16:48am.
     *  1. Model this interval as a Period or Duration, as appropriate.
     *  2. Determine when the next 3 occurrences of this special event will be.
     * 
     * RESULT:
     */
    public static void testSpecialEvent() {
        // Done
        Duration specialEvent = Duration.ofHours(5).plusMinutes(5).plusSeconds(5);
        LocalDateTime lastEvent = LocalDateTime.of(2020, 2, 18,10,16,48);

        LocalDateTime nextEvent = lastEvent.plus(specialEvent);
        LocalDateTime nextEvent2 = nextEvent.plus(specialEvent);
        LocalDateTime nextEvent3 = nextEvent2.plus(specialEvent);

        System.out.println("First event: " + nextEvent);
        System.out.println("Second event: " + nextEvent2);
        System.out.println("Third event: " + nextEvent3);
    }
    

    /**
     * This method simulates actual business work.
     * It takes between 0 and 1500ms to complete.
     */
    private static void businessWork() {
        try { Thread.sleep((long) (Math.random() * 1500)); }
        catch (InterruptedException ignored) {}
    }
}