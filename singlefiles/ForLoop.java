package singlefiles;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        short x, y, i;
        for (i = 10; i >= 2; i -= 2) {
            System.out.println(i);
        }
        Scanner read = new Scanner(System.in);
        System.out.print("Input x dimension: ");
        short xDimension = read.nextShort();
        System.out.print("Input y dimension: ");
        short yDimension = read.nextShort();
        System.out.println();
        for (y = 1; y <= yDimension; y++) {

            for (x = 1; x <= xDimension; x++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        read.close();
    }
}
