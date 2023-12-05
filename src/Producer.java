class Producer implements Runnable {

    private BankAccount bankAccount;

    public Producer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.deposit(10);
        }
    }
}
