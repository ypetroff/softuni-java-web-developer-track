package CompanyRoster02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        while (numberOfEmployees-- > 0) {
            Employee employee;
            String[] employeeData = scanner.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            if(employeeData.length == 6) {
                String email = employeeData[4];
                int age = Integer.parseInt(employeeData[5]);
                 employee = new Employee(name, salary, position, department, email, age);
            }else if( employeeData.length == 5){
                try{
                  int age =  Integer.parseInt(employeeData[4]);
                     employee = new Employee(name, salary, position, department, age);
                }catch(Exception e) {
                     employee = new Employee(name, salary, position, department, employeeData[4]);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }
            employeeList.add(employee);
        }

        List<String> departments = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        List<Department> averagePerDepartment = departments.stream()
                .map(department -> new Department(department, employeeList.stream().
                        filter(employee -> employee.getDepartment().equals(department))
                        .collect(Collectors.toList())))
                .sorted(Comparator.comparingDouble(Department::getAverageSalary).reversed())
                .collect(Collectors.toList());

        Department department = averagePerDepartment.get(0);
        department.getEmployeeList().sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", department.getName());
        department.getEmployeeList().forEach(employee -> System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
    }
}
