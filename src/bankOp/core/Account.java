package bankOp.core;

public abstract class Account implements Transaction {
    private String accountNumber;
    private double balance;
    private Customer customer;

    public Account(
        String accountNumber,
        double balance,
        Customer customer
    ) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Customer Name: " + customer.getCustomerName());
    }
}
