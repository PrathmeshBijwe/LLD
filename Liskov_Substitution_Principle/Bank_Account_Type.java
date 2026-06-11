//Incorrect approach
//
//class BankAccount {
//    public void withdraw(double amount) {
//        System.out.println("Withdrawing " + amount);
//    }
//}
//
//class FixedDepositAccount extends BankAccount {
//    @Override
//    public void withdraw(double amount) {
//        throw new UnsupportedOperationException("Cannot withdraw from Fixed Deposit!");
//    }
//}

//Correct approach

interface Account {
    double getBalance();
}

interface WithdrawableAccount extends Account {
    void withdraw(double amount);
}

class SavingsAccount implements WithdrawableAccount {
    private double balance = 1000;
    public double getBalance() { return balance; }
    public void withdraw(double amount) { balance -= amount; }
}

class FixedDepositAccount implements Account {
    private double balance = 5000;
    public double getBalance() { return balance; }
}
