package singlefiles;
import java.util.Scanner;

public class SwitchCalendar {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        byte dayOfWeek, calendarType;
        System.out.print("Input day of week you wish (integer): ");
        dayOfWeek = read.nextByte();
        System.out.print("0 - Monday first day, 1 - Sunday first day: ");
        calendarType = read.nextByte();

        String outputDay;
        if (dayOfWeek >= 1 && dayOfWeek <= 7 && calendarType >= 0 && calendarType <= 1) {
            switch (dayOfWeek - 1 + (calendarType == 0 ? 1 : 0)) {
                case 0: outputDay = "Sun"; break;
                case 1: outputDay = "Mon"; break;
                case 2: outputDay = "Tue"; break;
                case 3: outputDay = "Wed"; break;
                case 4: outputDay = "Thu"; break;
                case 5: outputDay = "Fri"; break;
                case 6: outputDay = "Sat"; break;
                default:
                    outputDay = "Invalid input";
            }
        } else {
            outputDay = "Invalid input";
        }

        System.out.println(outputDay);
        read.close();
    }
}
