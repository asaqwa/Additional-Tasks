package exceptions._5;

public class Test {
    static String str = "";

    public static void main(String[] args) {
        try {
            str += "a";
            throw new Exception();
        } catch (Exception e) {
            str += "b";
        } finally {
            str += "c";
            method1();
            str += "d";
        }
        System.out.println(str);
    }

    static void method1() {
        int y = 8 / 0;
    }
}