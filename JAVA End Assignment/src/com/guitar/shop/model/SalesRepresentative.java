package com.guitar.shop.model;

public class SalesRepresentative extends Person{
    private EmployeeType employeeType;
    public SalesRepresentative(String firstName,String lastName, String username,String password) {
        super(firstName,lastName,username,password);
        employeeType = EmployeeType.SALES_REPRESENTATIVE;
    }
}
