package bankOp.accounts;

import bankOp.core.Customer;

public class SeniorCitizenFD extends FixedDepositAccount {
    private double extraInterestRate;

    public SeniorCitizenFD(String accountNumber, double balance, Customer customer, double interestRate, int tenure, double extraInterestRate) {
        super(accountNumber, balance, customer, interestRate, tenure);
        this.extraInterestRate = extraInterestRate;
    }

    public double getExtraInterestRate() {
        return extraInterestRate;
    }
}
