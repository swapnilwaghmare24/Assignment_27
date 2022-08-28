package com.bridgelabz.employeepayrolltest;

import com.bridgelabz.employeedataservice.EmployeeData;
import com.bridgelabz.employeedataservice.EmployeeService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {
    @Test
    public void ThreeEmployeesWhenGivenToFileShouldMatchEmployeeEntries(){
        List<EmployeeData> employeePayrollList=new ArrayList<>();
        EmployeeData[] employeePayrollArray = {
                new EmployeeData(1,"swapnil",50000),
                new EmployeeData(2,"prashant",100000),
                new EmployeeData(3,"sandip",300000)
        };
        employeePayrollList= Arrays.asList(employeePayrollArray);
        EmployeeService employeeService = new EmployeeService(employeePayrollList);
        employeeService.writeEmployeeData(EmployeeService.IOService.FILE_IO);
        employeeService.readEmployeeData(EmployeeService.IOService.FILE_IO);
        Assert.assertEquals(3,employeeService.countEntries(EmployeeService.IOService.FILE_IO));
    }


}
