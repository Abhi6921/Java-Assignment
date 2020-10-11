package com.guitar.shop.model;

public class Manager extends Person {
    private EmployeeType employeeType;
    public Manager(String firstName, String lastName, String username, String password) {
        super(firstName,lastName,username,password);
        employeeType = EmployeeType.MANAGER;
    }
}
