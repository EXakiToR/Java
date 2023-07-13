package singlefiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDataWriting {
    private static Scanner read = new Scanner(System.in);

    private static boolean askYesOrNo() {
        String ans = read.next().toLowerCase();
        if (ans.equals("yes") || ans.equals("ye") || ans.equals("y")) {
            return true;
        }
        return false;
    }

    private static void askData() throws IOException {
        String name, lastname;
        int age, rating;
        System.out.print("> Your name: ");
        name = read.next();
        read.nextLine();
        System.out.print("> Your last name: ");
        lastname = read.next();
        read.nextLine();
        System.out.print("Your age: ");
        age = read.nextInt();
        System.out.print("Your rating in the system: ");
        rating = read.nextInt();
        File file = new File("UserData.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("File " + file.getName() + " was created with entered data.");
        }
        FileWriter fw = new FileWriter(file, true);
        fw.write(name + " ");
        fw.write(lastname + " ");
        fw.write(age + " ");
        fw.write(rating + "\n");
        fw.flush();
    }

    public static void main(String[] args) throws IOException {

        File searchedFile = new File("UserData.txt");
        if (searchedFile.exists()) {
            System.out.println("Hi, " + new Scanner(searchedFile).next() + "!");
            System.out.print("Would you like to delete existing file UserData? (y/n): ");
            if (askYesOrNo()) {
                searchedFile.delete();
                System.out.println("Deleted.");
            } else {
                System.out.print("Ok, we'll keep it.\nDo you want to be asked again to enter data? (y/n): ");
                if (askYesOrNo()) {
                    askData();
                } else {
                    System.out.println("Ok, we'll not bother you for now.");

                }
                return;
            }
        }
        askData();
    }
}
