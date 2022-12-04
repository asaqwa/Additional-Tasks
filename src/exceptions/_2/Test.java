package exceptions._2;

public class Test {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.print("Catch Exception ");
        }
    }

    public static void method1() {
        try {
            System.out.print("Try ");
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.print("Catch ArithmeticException ");
            throw e;
        } finally {
            System.out.print("Finally ");
        }
    }
}