package Aug21.cafe;

import java.util.*;
import java.util.stream.Collectors;

public class Cafe {

    private final List<Employee> employees;
    private final String name;
    private final int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {

        if (isInTheList(name)) {
            this.employees.remove(this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null));
            return true;
        }

        return false;
    }

    private boolean isInTheList(String name) {
        return this.employees.stream().anyMatch(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(1).findAny().orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        return String.format("Employees working at Cafe %s:%n%s",
                this.name, this.employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
