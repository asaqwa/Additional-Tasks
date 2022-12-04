package exceptions._1;


public class Test {
    public static String someMethod() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException | OutOfMemoryError e) {
//            e = new NullPointerException("new Exception"); // Cannot assign a value to final variable 'e'
            return "catch";
        } finally {
            return "finally";
        }
    }

    public static void main(String[] args) {
        System.out.println(someMethod());
    }
}