package com.bridgelabz.employeedataservice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService
{
    public List<EmployeeData> employeePayrollList = new ArrayList<>();

    public enum IOService {
        CONSOLE_IO,
        FILE_IO
    }

    EmployeeService() {

    }

   public EmployeeService(List<EmployeeData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;

    }

    public void writeEmployeeData(IOService ioService) {

        if (IOService.CONSOLE_IO.equals(ioService)) {
            EmployeePayrollConsoleService<EmployeeData> obj;
            obj = new EmployeePayrollConsoleService();
            obj.writeEmployeePayrollData();
        } else if (IOService.FILE_IO.equals(ioService)) {
            EmployeePayrollFileService<EmployeeData> obj;
            obj = new EmployeePayrollFileService();
            obj.writeEmployeePayrollData(employeePayrollList);
        }
    }

    public void readEmployeeData(IOService ioService) {

        if (IOService.CONSOLE_IO.equals(ioService)) {
            EmployeePayrollConsoleService<EmployeeData> obj;
            obj = new EmployeePayrollConsoleService();
            obj.readEmployeePayrollData();
        } else if (IOService.FILE_IO.equals(ioService)) {
            EmployeePayrollFileService<EmployeeData> obj;
            obj = new EmployeePayrollFileService();
            obj.readEmployeePayrollData();
        }
    }
    public long countEntries(IOService ioService){

        long count=0;
        if (IOService.CONSOLE_IO.equals(ioService)) {
            EmployeePayrollConsoleService<EmployeeData> obj;
            obj = new EmployeePayrollConsoleService();
            count = obj.countEntries();
        } else if (IOService.FILE_IO.equals(ioService)) {
            EmployeePayrollFileService<EmployeeData> obj;
            obj = new EmployeePayrollFileService();
            count= obj.countEntries();
        }
        return count;
    }
}
