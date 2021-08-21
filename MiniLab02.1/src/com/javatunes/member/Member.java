/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.member;

public class Member {
    // Adding a parameter name in the ctor will give a compiler error, because any class has one default ctor,
    //if there no custom ctor.
    public Member(String name) {
        // NOTE: there is a call to super() here! as the first line of code
        // What's the superclass of Member?  Is there a no-arg ctor in that class?
        System.out.println("Member ctor");
    }
}