package com.bridgelabz.employeedataservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollConsoleService<T> {
    List<EmployeeData> employeeDataList;

    static Scanner sc=new Scanner(System.in);
    EmployeeData employeeData=new EmployeeData();
    public EmployeePayrollConsoleService()
    {

    }
    public EmployeePayrollConsoleService(List<EmployeeData> employeeDataList)
    {
        this.employeeDataList=employeeDataList;
    }
    public void readEmployeePayrollData() {
        System.out.println("Enter id");
        int id= sc.nextInt();
        employeeData.setId(id);
        System.out.println("Enter name");
        String name= sc.next();
        employeeData.setName(name);
        System.out.println("Enter salary");
        Double salary= sc.nextDouble();
        employeeData.setSalary(salary);
        employeeDataList.add(employeeData);
    }
    public void writeEmployeePayrollData() {
        System.out.println("Writing data to console : "+employeeDataList);
    }
    public long countEntries() {
        long count=employeeDataList.stream().count();
        return count;
    }

    public static void main(String[] args) {
        List<EmployeeData> employeeDataList=new ArrayList<>();
        EmployeePayrollConsoleService consoleService=new EmployeePayrollConsoleService<>(employeeDataList);
        boolean repeat=true;
        while(repeat)
        {
            consoleService.readEmployeePayrollData();
            System.out.println("do you wnat to add another employee data type y to continue");
            char choice = sc.next().charAt(0);
            if (choice == 'y')
                repeat = true;
            else
                repeat = false;
        }
        consoleService.writeEmployeePayrollData();
        System.out.println(consoleService.countEntries());
    }
}
