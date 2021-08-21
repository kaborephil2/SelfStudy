/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Objects;

public abstract class Employee {
    private String name;
    private Date hireDate;
    
    public Employee() {
    }
    
    public Employee(String name, Date hireDate) {
        setName(name);
        setHireDate(hireDate);
    }

    //Business methods
    public abstract void pay();
    
    public void work() {
        System.out.println(getName() + " working hard since " + getHireDate());
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate();
    }

    @Override
    public boolean equals(Object obj) {
        boolean value = false;
        if (obj instanceof Employee) {
            Employee emp2 = (Employee) obj;
            value = Objects.equals(this.getName(), emp2.getName()) && Objects.equals(this.getHireDate(),emp2.getHireDate());
        }
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHireDate());
    }
}