
import java.util.ArrayList;

public class StudentsCollection {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("John Lorem Ipsum", "English translation", 6.7f));
        students.add(new Student("Mary Dolor Sit", "Computer science", 7.2f));
        students.add(new Student("Ashley Amet Consectuar", "Biology", 8.5f));
        students.add(new Student("Connor Adepsit Elit", "Programming", 9f));
        students.add(new Student("Liam Lectus Risus", "Music", 9.6f));
        System.out.println("Before: \n" + students);
        Integer indexOfTheBest = 4;
        students.get(indexOfTheBest).grade += .1f;
        ArrayList<Student> bestStudents = new ArrayList<Student>();
        bestStudents.add(students.get(2));
        bestStudents.add(students.get(3));
        bestStudents.add(students.get(4));
        System.out.println("After: \n" + students);
        System.out.println("Best students: \n" + bestStudents);

    }
}

class Student {
    String fullname;
    String specialty;
    Float grade;

    public Student(String fullname, String specialty, Float grade) {
        this.fullname = fullname;
        this.specialty = specialty;
        this.grade = grade;
    }

    // Obeject by default has toString(), so it's being overridden by subclass to
    // specify desired behavior
    @Override
    public String toString() {
        return "\n\tStudent [fullname=" + fullname + ", specialty=" + specialty + ", grade="
                + String.format("%1$.2f", grade) + "]\n";
    }

}