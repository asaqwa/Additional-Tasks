package Multithreading.tryCatchTrap;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        // To check and work with data it is better not to use a constantly changing variable thread.
        // Better use the static method of the Thread instead.
        Thread.yield();
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}