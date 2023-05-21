package appliancestest;

public class Main {
    public static void main(String[] args) {
        Test hTest = new HeatingTest();
        Test sTest = new SpinTest();

        if (hTest.test()) {
            System.out.println("All heating tests passed!");
        } else {
            System.err.println("Some heating tests failed!");
        }

        if (sTest.test()) {
            System.out.println("All spining tests passed!");
        } else {
            System.err.println("Some spining tests failed!");
        }
    }
}
