package Multithreading.WaitNotify._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadExample {
    static final List<String> data = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        new DataReceiver().start();
        new DataProcessor().start();
    }

    static class DataReceiver extends Thread {
        @Override
        public void run() {
            setName("DataReceiver");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    System.out.println(getName() + " waiting for a new data input");
                    String line = reader.readLine();
                    synchronized (data) {
                        System.out.println(getName() + " in synchronized block");
                        data.add(line);
                        System.out.println(getName() + " notifying the DataProcessor. data size is " + data.size());
                        data.notify();
                        if ("exit".equals(line)) break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static class DataProcessor extends Thread {
        @Override
        public void run() {
            setName("DataProcessor");
            synchronized (data) {
                System.out.println(getName() + " in synchronized block");
                while (true) {
                    try {
                        if (data.isEmpty()) {
                            System.out.println(getName() + " is waiting for a new data");
                            data.wait();
                        }

                        String line = data.remove(0);
                        System.out.println(getName() + " removing the line " + line);
                        if ("exit".equals(line)) break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            } // synchronized
        }
    }
}
