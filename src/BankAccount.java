class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        System.out.println("Starting balance $" + balance);
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        double temp = balance;
        temp = temp + amount;
        try {
            // artificial processing delay
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("after deposit balance = $" + temp);
        balance = temp;
    }

    public synchronized void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient funds");
            return;
        }

        double temp = balance;
        temp = balance - amount;
        try {
            // artificial processing delay
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("after withdraw balance = $" + temp);
        balance = temp;
    }
}