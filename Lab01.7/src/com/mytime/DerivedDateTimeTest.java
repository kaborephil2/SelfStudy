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

import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class DerivedDateTimeTest {

    /**
     * main() calls each of the test methods in turn (currently commented out).
     * To run one test method at a time, uncomment the call to the one you want to execute.
     */
    public static void main(String[] args) {
        testPresidentsFirst100Days();
        testPopularBirthdays();
        testEarlyRetirement();
        testLaborDay();
        testElectionDay();
        testAnniversary();
    }
    
    /**
     * TASK: new American presidents are often measured by their performance during the first 100 days in office.
     * Inauguration Day 2017 is Jan 20.  When is this president's 100-day deadline?
     * 
     * RESULT: 
     */
    public static void testPresidentsFirst100Days() {
        // Done
        LocalDate inaugurationDay = LocalDate.of(2017, 1, 20);
        LocalDate president100Days = inaugurationDay.plusDays(100);
        System.out.println("The president's 100-day deadline is: " + president100Days);
    }

    /**
     * TASK: Certain times of the year seem to have more birthdays than other times.
     * Some believe that this is because more babies are conceived during certain times of year.
     * Below, assume a due date 38 weeks after conception, during a non-leap-year.
     * 
     * RESULT: 
     */
    public static void testPopularBirthdays() {
        // Done: what is the average birthday of someone conceived on Valentine's Day?
        LocalDate averageBirthday = LocalDate.of(2021, 2, 14);
        LocalDate valentineDay = averageBirthday.plusWeeks(38);
        System.out.println("The average birthday of someone conceived on Valentine's Day is: " +valentineDay);
        
        // Done: what is the average birthday of someone conceived on New Year's Eve (after midnight)?
        LocalDate newYear = LocalDate.of(2021,1,1);
        LocalDate conceivedNewYear = newYear.plusWeeks(38);
        System.out.println("The average birthday of someone conceived on New Year's Eve is: " + conceivedNewYear);
    }
    
    /**
     * TASK: you've saved diligently your whole life and plan to retire as soon as
     * you can take distributions from your 401(k) penalty-free, which is when you turn 59 1/2.
     * When will / did you retire?
     * 
     * RESULT: 
     */
    public static void testEarlyRetirement() {
        // Done
        LocalDate myBirthday = LocalDate.of(1986,10,1);
        LocalDate retirementSavings = myBirthday.plusYears(59).plusMonths(6);
        System.out.println("My retirement date from now is :" + retirementSavings);
    }
    
    /**
     * TASK: when was Labor Day during the year you were born?
     * Note: start with a LocalDate equal to your birthday.
     * Note: Labor Day is the first Monday in Sept.
     * 
     * RESULT: 
     */
    public static void testLaborDay() {
        //Done
        LocalDate myBirthday = LocalDate.of(1986,10,1);
        LocalDate laborDay = myBirthday.withMonth(11).with(firstInMonth(DayOfWeek.MONDAY));
        System.out.println("The Labor day from my birth year was: " + laborDay);
    }
    
    /**
     * OPTIONAL: Election Day in the United States is defined as the Tuesday immediately after the 1st Monday in November.
     * When is Election Day 2024?
     * 
     * RESULT: 
     */
    public static void testElectionDay() {
        // Done
        LocalDate presidential = LocalDate.of(2024,11,1);
        LocalDate electionDay = presidential.withMonth(11).with(firstInMonth(DayOfWeek.TUESDAY));
        System.out.println("Presidential election in 2024 is: " + electionDay);
    }
    
    /**
     * OPTIONAL: Akesh and Samanta were married on 6/6/1969.
     * They are planning their 50th wedding anniversary, and would like to throw a big party.
     * If their anniversary does not fall on a Saturday, they'd like to have their party the following Saturday.
     * What is the date of the party?
     * 
     * RESULT: 
     */
    public static void testAnniversary() {
        // Done
        LocalDate marriageDate = LocalDate.of(1969,6,6);
        LocalDate weddingAnniversary = marriageDate.plusYears(50);
        LocalDate partyDay = weddingAnniversary.with(nextOrSame(DayOfWeek.SATURDAY));
        System.out.println(" Akesh and Samantha wedding party: " + partyDay);
    }
}