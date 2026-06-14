package bankOp.accounts;

import bankOp.core.Customer;

public class StudentAccount extends SavingsAccount {
    private double scholarshipAmount;

    public StudentAccount(String accountNumber, double balance, Customer customer, double interestRate, double scholarshipAmount) {
        super(accountNumber, balance, customer, interestRate);
        this.scholarshipAmount = scholarshipAmount;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }
}
