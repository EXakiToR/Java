package singlefiles;
import java.util.Scanner;

public class DrawCakeWithFor {

    public static void main(String[] args) {

    final int SMOKE  = 1; 
    final int FIRE   = 2; 
    final int CANDLE = 3; 
    final int CREAM  = 4; 
    final int BASE   = 5; 
    int lines, elements, width;
    Scanner read = new Scanner(System.in);
    System.out.print("Input cake witdth: ");
    width = read.nextInt();
    for(int level=1; level<=5 ;level++) {
        switch(level) {
            case SMOKE:
            for(lines=1; lines<=2; lines++) {
                System.out.print(" ");
                for(elements=1; elements<=width/2; elements++) {
                    System.out.print(". ");
                }
                System.out.println();
            }
            break;
            case FIRE:
            System.out.print(" ");
            for(elements=1; elements<=width/2; elements++) {
                    System.out.print("^ ");
                }
                System.out.println();
            break;
            case CANDLE:
            System.out.print(" ");            
            for(elements=1; elements<=width/2; elements++) {
                System.out.print("| ");
            }
            System.out.println();
            break;
            case CREAM:
            for(elements=1; elements<=width; elements++) {
                System.out.print("~");
            }
            System.out.println();
            break;
            case BASE:
            for(lines=1; lines<=3; lines++) {
                for(elements=1; elements<=width; elements++) {
                    System.out.print("#");
                }
                System.out.println();
            }
            break;
        }
    }
    read.close();

    }
}
