package singlefiles;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {

        try {
            int value = readInteger();
            System.out.println("Entered value: " + value);
        } catch (ValueOutOfRangeException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter an integer.");
        }

    }

    public static int readInteger() throws ValueOutOfRangeException, InputMismatchException {
        try (Scanner read = new Scanner(System.in)) {
            System.out.print("Enter value in range [0..1000]: ");
            int value = read.nextInt();
            if (value < 0 || value > 1000) {
                throw new ValueOutOfRangeException("Value out of range: [0..1000]");
            }
            return value;
        }
    }
}

class ValueOutOfRangeException extends Exception {
    public ValueOutOfRangeException(String message) {
        super(message);
    }
}
