import java.util.*;

class Student {
    private String name;
    private double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return String.format("Student{name='%s', marks=%.2f}", name, marks);
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
            new Student("Prashant", 82),
            new Student("Amit", 65),
            new Student("Riya", 90),
            new Student("Karan", 74),
            new Student("Neha", 88)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)   // filter condition
                .sorted(Comparator.comparingDouble(Student::getMarks)) // sort by marks (ascending)
                .map(Student::getName)            // map to names only
                .forEach(System.out::println);    // print names
    }
}

