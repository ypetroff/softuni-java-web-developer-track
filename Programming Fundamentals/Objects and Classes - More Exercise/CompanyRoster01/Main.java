package CompanyRoster01;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Employee> departments = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] employeesData = scanner.nextLine().split(" ");
            String name = "";
            double salary = 0;
            String position = "";
            String department = "";
            String email = "n/a";
            int age = -1;

            for (int j = 0; j < employeesData.length; j++) {

                if (j == 0) {
                    name = employeesData[j];
                } else if (j == 1) {
                    salary = Double.parseDouble(employeesData[j]);
                } else if (j == 2) {
                    position = employeesData[j];
                } else if (j == 3) {
                    department = employeesData[j];
                } else if (j == 4) {
                    Pattern pattern = Pattern.compile("@");
                    Matcher matcher = pattern.matcher(employeesData[j]);
                    if (matcher.find()) {
                        email = employeesData[j];
                    }else {
                        age = Integer.parseInt(employeesData[j]);
                        break;
                    }

                } else {
                    age = Integer.parseInt(employeesData[j]);
                }

            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            departments.add(employee);

        }
        double maxAverage = 0;
        String highestSalaryDepartment = "";

        for (int i = 0; i < departments.size(); i++) {
            String currentDepartment = departments.get(i).getDepartment();
            int counter = 1;
            double salarySum = departments.get(i).getSalary();
            double averageSalary = salarySum;

//            if(departments.size() == 1) {
//                highestSalaryDepartment = currentDepartment;
//                break;
//            }

            for (int j = i + 1; j < departments.size() - 1; j++) {
                if (currentDepartment.equals(departments.get(j).getDepartment())) {
                    counter++;
                    salarySum += departments.get(j).getSalary();
                }


                    averageSalary = salarySum / counter;



            }
            if (averageSalary >= maxAverage) {
                maxAverage = averageSalary;
                highestSalaryDepartment = currentDepartment;
            }

        }
        String department = highestSalaryDepartment;


        List<Employee> result = departments.stream()
                .filter(p -> p.getDepartment().equals(department))
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        Collections.reverse(result);

        if(numberOfEmployees != 0) {
            System.out.println("Highest Average Salary: " + department);
            result.forEach(p -> System.out.println(p.printDepartmentEmployees()));
        }

    }

}
