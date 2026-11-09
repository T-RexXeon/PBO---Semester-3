package W10.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class MainTask1 {
    public static void main(String[] args) {
        ArrayList<Student<?>> studentList = new ArrayList<>();
        
        studentList.add(new Student<String>("S01", "Zack", "Computer Science", "Bandung"));
        studentList.add(new Student<Integer>("S02", "Adrian", 101, "Jakarta"));
        studentList.add(new Student<String>("S03", "Budi", "Information Systems", "Surabaya"));
        studentList.add(new Student<Integer>("S04", "Diana", 102, "Malang"));
        studentList.add(new Student<String>("S05", "Celine", "Computer Science", "Semarang"));

        Collections.sort(studentList, Comparator.comparing(Student::getName));

        System.out.println("=== ArrayList Sorted by Name ===");
        for (Student<?> s : studentList) {
            System.out.println(s);
        }

        Vector<Student<?>> studentVector = new Vector<>();
        studentVector.addAll(studentList);

        System.out.println("\n=== Students in Computer Science Department (Vector) ===");
        for (Student<?> s : studentVector) {
            if (s.getDepartment() instanceof String) {
                String dept = (String) s.getDepartment();
                if (dept.equalsIgnoreCase("Computer Science")) {
                    System.out.println(s);
                }
            }
        }
    }
}