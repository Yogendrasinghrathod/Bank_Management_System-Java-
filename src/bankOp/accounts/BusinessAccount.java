package bankOp.accounts;

import bankOp.core.Customer;

public class BusinessAccount extends CurrentAccount {
    private String companyName;
    private String gstNumber;

    public BusinessAccount(String accountNumber, double balance, Customer customer, double overdraftLimit, String companyName, String gstNumber) {
        super(accountNumber, balance, customer, overdraftLimit);
        this.companyName = companyName;
        this.gstNumber = gstNumber;
    }

    public String generateGSTReport() {
        return "GST No: " + gstNumber + ", Company: " + companyName;
    }
}
