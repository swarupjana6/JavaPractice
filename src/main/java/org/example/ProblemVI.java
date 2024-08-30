package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProblemVI {

    /*

        Example 1:

        Input:  str1 = "ih", str2 = "hibuthi",
        Output: 0,5
     */


    public static List<Integer>  strStr(String str1, String str2) {

        List<Integer> positions = new ArrayList<>();
        int index = str2.indexOf(str1);

        while (index >= 0) {
            positions.add(index);
            index = str2.indexOf(str1, index + 1);
        }

        return positions;

    }


    static class Employee {
        int id;
        String name;
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class EmployeeRepository {
        public Employee getEmployee(int id) {
            return new Employee(id, "name");
        }
    }

    static class EmployeeService {
        public Employee getEmployee(Employee employee) {
            EmployeeRepository employeeRepository = new EmployeeRepository();
            employee = employeeRepository.getEmployee(employee.id);
            return employee;
        }
    }


    public static void main(String[] args) {

        System.out.println(strStr("hi", "hibuthi")); //strStr("hi", "hibuthi");
        List<Integer> empId = new ArrayList<>();
        EmployeeService employeeService = new EmployeeService();
        /*empId.stream()
                .forEach(id -> employeeService.getEmployee(EmployeeRepository::getEmployee));*/


    }
}