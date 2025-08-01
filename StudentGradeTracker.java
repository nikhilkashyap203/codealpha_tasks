import java.util.ArrayList;
import java.util.Scanner;

// Student class to hold name and marks
class Student {
    String name;
    ArrayList<Integer> marks;

    Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    double getAverage() {
        if (marks.isEmpty()) return 0.0;
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.size();
    }

    int getHighest() {
        if (marks.isEmpty()) return 0;
        int highest = marks.get(0);
        for (int mark : marks) {
            if (mark > highest) highest = mark;
        }
        return highest;
    }

    int getLowest() {
        if (marks.isEmpty()) return 0;
        int lowest = marks.get(0);
        for (int mark : marks) {
            if (mark < lowest) lowest = mark;
        }
        return lowest;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Student> studentList = new ArrayList<>();
            
            System.out.print("Enter number of students: ");
            int numStudents = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < numStudents; i++) {
                System.out.print("\nEnter name of student " + (i + 1) + ": ");
                String name = sc.nextLine();
                Student student = new Student(name);
                
                System.out.print("Enter number of subjects for " + name + ": ");
                int numSubjects = sc.nextInt();
                
                for (int j = 0; j < numSubjects; j++) {
                    System.out.print("Enter marks for subject " + (j + 1) + ": ");
                    int mark = sc.nextInt();
                    student.marks.add(mark);
                }
                
                sc.nextLine(); // consume newline
                studentList.add(student);
            }
            
            // Display summary report
            System.out.println("\n===== STUDENT SUMMARY REPORT =====");
            for (Student s : studentList) {
                System.out.println("Name: " + s.name);
                System.out.println("Marks: " + s.marks);
                System.out.printf("Average Marks: %.2f\n", s.getAverage());
                System.out.println("Highest Marks: " + s.getHighest());
                System.out.println("Lowest Marks: " + s.getLowest());
                System.out.println("----------------------------------");
            }
        }
    }
}