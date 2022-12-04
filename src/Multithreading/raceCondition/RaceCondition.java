package Multithreading.raceCondition;

public class RaceCondition implements Runnable {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    private void makeWithdrawal(int amount) {
        if (getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            withdraw(amount);
            System.out.printf("%s completes the withdrawal. The balance is %d%n",
                    Thread.currentThread().getName(), getBalance());
        } else {
            System.out.printf("not enough in account for %s to withdraw %d%n",
                    Thread.currentThread().getName(), getBalance());
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            makeWithdrawal(10);
            if (getBalance() < 0) System.out.println("the account is overdrawn!");
        }
    }
}