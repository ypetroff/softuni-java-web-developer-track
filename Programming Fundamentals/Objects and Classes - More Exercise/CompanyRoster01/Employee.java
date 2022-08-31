package CompanyRoster01;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private  int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    String printDepartmentEmployees() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
