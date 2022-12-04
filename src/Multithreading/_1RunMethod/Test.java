package Multithreading._1RunMethod;

class Test implements Runnable {
    private int x;

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test).start();
        new Thread(test).start();
    }

    public synchronized void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("x = " + ++x + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}