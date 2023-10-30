package com.example.zeitmanagement;

public class Employee {
    private String name;
    private String password;
    private int employeeID;

    public Employee(String name, String password, int employeeId) {
        this.name = name;
        this.password = password;
        this.employeeID = employeeId;
    }

    // Getters and setters for the name and password
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeId) {
        this.employeeID = employeeId;
    }

}


