package Multithreading._1RunMethod;

public class Example {
    public static void main(String[] args) {
        Runnable r = () -> System.out.print("Cat");

        Thread t = new Thread(r) {
            public void run() {
                System.out.print("Dog");
            }
        };
        t.start();

    }
}