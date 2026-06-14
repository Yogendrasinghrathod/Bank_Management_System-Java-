package bankOp.accounts;

import bankOp.core.Account;
import bankOp.core.Customer;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, Customer customer, double interestRate) {
        super(accountNumber, balance, customer);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
