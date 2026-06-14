package bankOp.accounts;

import bankOp.core.Account;
import bankOp.core.Customer;

public class FixedDepositAccount extends Account {
    private int tenure;
    private double interestRate;

    public FixedDepositAccount(String accountNumber, double balance, Customer customer, double interestRate, int tenure) {
        super(accountNumber, balance, customer);
        this.tenure = tenure;
        this.interestRate = interestRate;
    }

    public double calculateMaturityAmount() {
        return getBalance() * Math.pow(1 + (interestRate / 100), tenure);
    }
}
