package com.ram.demo.spboot;

import java.util.Date;

public class Employee{
    private long id;
    private String name;
 
    public Employee() {
    }
 
    public Employee(String name, String department) {
        this.id = (new Date()).getTime();
        this.name = name;
        this.department = department;
    }
 
    private String department;
 
    public long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDepartment() {
        return department;
    }
 
    public void setDepartment(String department) {
        this.department = department;
    }
 
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}