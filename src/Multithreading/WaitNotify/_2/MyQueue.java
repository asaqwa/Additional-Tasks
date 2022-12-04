package Multithreading.WaitNotify._2;

public class MyQueue {
    private int sequence = 0;
    private int n;
    boolean valueSet = false;

    public synchronized int get() {
        while (!valueSet) {
            sequence++;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Пoлyчeнo: " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            sequence--;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueSet = true;
        this.n = n;
        System.out.println("Oтпpaвлeнo: " + n);
        notify();
    }

    public int getSequence() {
        return sequence;
    }
}