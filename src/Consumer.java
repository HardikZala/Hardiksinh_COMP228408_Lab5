class Consumer implements Runnable {

    private BankAccount bankAccount;

    public Consumer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.withdraw(10);
        }
    }
}