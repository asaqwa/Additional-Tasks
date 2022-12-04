package Multithreading.raceCondition;

public class RaceConditionTest {
    public static void main(String[] args) {
        Runnable rc = new RaceCondition();
        new Thread(rc, "Ted").start();
        new Thread(rc, "Laura").start();
    }
}
