package singlefiles;

import java.util.InputMismatchException;
import java.util.Scanner;
/*Be wise with your input! (the code cannot properly handle the Inputmismatch exception,
but otherwise it works) */

public class StudentsApp {
    public static void main(String[] args) {

        try (Scanner read = new Scanner(System.in)) {
            int option;
            boolean repeat = true;
            CLI.displayOptions = true;
            while(repeat){
                option = CLI.printMenu();
                switch (option){
                    case 1: 
                        System.out.print("Input student data:\n>> ");
                        StudentsDataBase.addStudent(read.nextLine(), read.nextLine(), read.nextInt());
                        read.nextLine();
                        break;
                    case 2:
                        System.out.print("Input student's number to delete:\n>> ");
                        StudentsDataBase.deleteStudentByIndex(read.nextInt());
                        read.nextLine();
                        break;
                    case 3:
                        System.out.print("Input student's new name then his number:\n>> ");
                        StudentsDataBase.updateStudentsNameByIndex(read.nextLine(), read.nextInt());
                        read.nextLine();
                        break;
                    case 4: 
                        System.out.print("Input student's new group name then his number:\n>> ");
                        StudentsDataBase.updateStudentsGroupByIndex(read.nextLine(), read.nextInt());
                        read.nextLine();
                        break;
                    case 5:
                        System.out.print("Input student's new general grade then his number:\n>> ");
                        StudentsDataBase.updateStudentsGeneralGradeByIndex(read.nextInt(), read.nextInt());
                        read.nextLine();
                        break;
                    case 6:
                        //
                        StudentsDataBase.printStudentsList();
                        break;
                    case 7:
                        //
                        CLI.displayOptions = CLI.displayOptions == false ? true : false;
                        break;
                    case 8:
                        //
                        repeat = false;
                        break;
                    default:
                        System.err.println("Invalid option!");
                        continue;
                    
                }
            }
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
    }
}

class CLI{
    public static boolean displayOptions;
    public static int printMenu() {
        if(displayOptions){
            System.out.print("Options:\n" +
            "\t1. Add student (in sequence: full name, group name, general grade)\n" +
            "\t2. Delete student (by number)\n" +
            "\t3. Update student name\n" +
            "\t4. Update student group name\n" +
            "\t5. Update student generalGrade\n" +
            "\t6. Print students list\n" +
            "\t7. Don't display these options everytime (or display them again)\n" +
            "\t8. Exit\n");
        }
        System.out.print(">> ");
        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        return read.nextInt();
        
    }
}

class StudentsDataBase {
    public static Student[] students = new Student[0];
    public static int lastIndex = 0;
    
    public static void addStudent(String fullName, String groupName, int generalGrade) throws InputMismatchException, IndexOutOfBoundsException{

        Student[] afterAddingStudents = new Student[students.length + 1];
        afterAddingStudents[afterAddingStudents.length - 1] = new Student(fullName, groupName, generalGrade);
        for (int i = 0; i < afterAddingStudents.length - 1; i++) {
            afterAddingStudents[i] = students[i]; 
        }
        students = afterAddingStudents;
    }
    public static void printStudentsList(){
        System.out.println("Students list:");
        if (students.length == 0) {
            System.out.println("\tNo students.");
        } else {
            for (int i = 0; i < students.length; i++) {
                    System.out.println(i + 1 + ". " + students[i]);
                }
            }
    }
    public static void updateStudentsNameByIndex(String newName, int index) throws IndexOutOfBoundsException{
        if (index > 0 && index <= students.length){
            students[index-1].setFullName(newName);
        } else {
            System.err.println("No student at this number.");
            printStudentsList();
        }
        
        
    }
    public static void updateStudentsGroupByIndex(String newGroup, int index) throws IndexOutOfBoundsException{
        if (index > 0 && index <= students.length){
            students[index-1].setGroupName(newGroup); 
        } else {
            System.err.println("No student at this number.");
            printStudentsList();
        }
        
    }
    public static void updateStudentsGeneralGradeByIndex(int newGeneralGrade, int index) throws IndexOutOfBoundsException{
        if (index > 0 && index <= students.length){
            students[index-1].setGeneralGrade(newGeneralGrade); 
        } else {
            System.err.println("No student at this number.");
            printStudentsList();
        }
        
    }
    public static void deleteStudentByIndex(int deleteIndex) throws IndexOutOfBoundsException{
        if (deleteIndex > 0 && deleteIndex <= students.length) {
            Student[] afterDeletionStudents = new Student[students.length - 1];
            if(students.length == 1){
                students = new Student[0];
            } else {
                for (int i = 0, j = 0; i < students.length; i++, j++) {
                    i = i == deleteIndex - 1 ? ++i : i;
                    afterDeletionStudents[j] = students[i];
                }
                students = afterDeletionStudents;
            }
            
        } else {
            System.err.println("No student at this number.");
            printStudentsList();
        }
        
    }
}

class Student {
    private String fullName;
    private String groupName;
    private int  generalGrade;
    public Student(String fullName, String groupName, int generalGrade) {
        setFullName(fullName);
        setGroupName(groupName);
        setGeneralGrade(generalGrade);
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
