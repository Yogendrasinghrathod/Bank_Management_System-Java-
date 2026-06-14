package bankOp.accounts;

import bankOp.core.Account;
import bankOp.core.Customer;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, Customer customer, double overdraftLimit) {
        super(accountNumber, balance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
