package Dec20.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {

    public List<Employee> employees;
    public String name;
    public int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Employee employee) {

        if(this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        return String.format("Employees working at Bakery %s:%n%s",
                this.name, this.employees.stream().map(Employee::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
