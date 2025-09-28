import java.util.*;

// Employee class
class Employee {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    // toString() for easy printing
    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%d, salary=%.2f}", name, age, salary);
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        // Create list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Prashu", 22, 60000));
        employees.add(new Employee("Amit", 25, 50000));
        employees.add(new Employee("Riya", 21, 70000));
        employees.add(new Employee("Karan", 23, 55000));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        // Sort by name (alphabetically)
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("\nSorted by Name:");
        employees.forEach(System.out::println);

        // Sort by age (ascending)
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        // Sort by salary (descending)
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\nSorted by Salary (Descending):");
        employees.forEach(System.out::println);
    }
}

