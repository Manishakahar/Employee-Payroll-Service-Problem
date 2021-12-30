package com.blz.employeepayroll.service;

import com.blz.employeepayroll.model.EmployeePayrollData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Creating main class
public class EmployeePayrollService {

    private static final IOService FILE_IO = null;

    public enum IOService {CONSOLE_IO, FILE_IO}
    //Creating object of EmployeePayrollData class
    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollDataList) {
    }
    //  main() method
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Service");
        ArrayList<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
    }

    // read method
    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee name");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary = consoleInputReader.nextDouble();
        employeePayrollDataList.add(new EmployeePayrollData(id, name, salary));
    }

    // write method
    void writeEmployeePayrollData(IOService fileIo) {
        System.out.println("\n Writing Employee Payroll Roster to Console\n" + employeePayrollDataList);
    }

}