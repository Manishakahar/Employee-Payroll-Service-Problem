package com.blz.empolyeepayroll.model;

//Creating EmployeePayrollData class
public class EmployeePayrollData {
    private int Emp_id;
    private String name;
    private double salary;

    //Creating Constructor for EmployeePayrollData
    public EmployeePayrollData(int Emp_id, String name, double salary) {
        this.Emp_id = Emp_id;
        this.name = name;
        this.salary = salary;
    }

    //Overriding toString() method
    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "Emp_id=" + Emp_id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

