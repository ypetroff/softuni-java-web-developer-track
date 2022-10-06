package CompanyRoster02;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;
    private double averageSalary;

    public Department(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
        this.averageSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
