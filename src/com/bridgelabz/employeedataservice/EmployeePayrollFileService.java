package com.bridgelabz.employeedataservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePayrollFileService<T> {
    public static final String FILE_NAME = "employee-payroll.txt";


    public void writeEmployeePayrollData(List employeePayrollList) {

        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employeePayroll ->{
            String str = employeePayroll.toString().concat("\n");
            empBuffer.append(str);
        });

        try {
            Files.write(Paths.get(FILE_NAME),empBuffer.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void readEmployeePayrollData() {
        try {
            List<String> list= Files.lines(Paths.get(FILE_NAME)).collect(Collectors.toList());
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public long countEntries() {
        long count1 = 0;
        try {
            count1=Files.lines(Paths.get(FILE_NAME)).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count1;
    }
}
