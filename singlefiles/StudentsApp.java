package singlefiles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsApp {
    public static void main(String[] args) {
        StudentDataBase.students = new Student[1];

        try (Scanner read = new Scanner(System.in)) {
            for (int i = 0; i < StudentDataBase.students.length+1; i++) {
                System.out.printf("Input %d student's data: \n", i + 1);
                try {
                    StudentDataBase.addStudent(read.nextLine(), read.nextLine(), read.nextInt());
                } catch (InputMismatchException e) {
                    System.err.println("Please, input an integer grade.");
                    i--;
                    read.nextLine();
                    continue;
                } catch (IndexOutOfBoundsException e){
                    System.err.printf("No more students available to enter. (max %d)\n", StudentDataBase.students.length);
                }
                read.nextLine();
            }
            
        } 
        StudentDataBase.printAllStudents();
        
    }
}

class StudentDataBase {
    public static Student[] students;
    public static int lastIndex = 0;
    
    public static void addStudent(String fullName, String groupName, int generalGrade) throws InputMismatchException, IndexOutOfBoundsException{

            students[lastIndex] = new Student(fullName, groupName, generalGrade);
            lastIndex++;
    }
    public static void printAllStudents(){
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i]);
            }
        }
    }

}

class Student {
    private String fullName;
    private String groupName;
    private int  generalGrade;
    public Student(String fullName, String groupName, int generalGrade) {
        this.fullName = fullName;
        this.groupName = groupName;
        this.generalGrade = generalGrade;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public int getGeneralGrade() {
        return generalGrade;
    }
    public void setGeneralGrade(int generalGrade) {
        this.generalGrade = generalGrade;
    }
    @Override
    public String toString() {
        return "Student [fullName=" + fullName + ", groupName=" + groupName + ", generalGrade=" + generalGrade + "]";
    }
    
}
