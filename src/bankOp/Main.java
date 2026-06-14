package bankOp;

import bankOp.core.*;
import bankOp.accounts.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Customer customer1, customer2, customer3;
    
    public static void main(String[] args) {
        try {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║   Welcome to Bank Management System    ║");
            System.out.println("╚════════════════════════════════════════╝\n");
            
            // Initialize some test customers
            initializeCustomers();
            
            boolean running = true;
            while (running) {
                displayMenu();
                int choice = getUserChoice();
                
                switch (choice) {
                    case 1:
                        testSavingsAccount();
                        break;
                    case 2:
                        testStudentAccount();
                        break;
                    case 3:
                        testCurrentAccount();
                        break;
                    case 4:
                        testBusinessAccount();
                        break;
                    case 5:
                        testFixedDeposit();
                        break;
                    case 6:
                        testSeniorCitizenFD();
                        break;
                    case 7:
                        runAllTests();
                        break;
                    case 0:
                        System.out.println("\nThank you for using Bank Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("❌ Invalid choice. Try again.\n");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static void initializeCustomers() {
        customer1 = new Customer("C001", "Raj Kumar");
        customer2 = new Customer("C002", "Priya Singh");
        customer3 = new Customer("C003", "Arjun Patel");
        System.out.println("✓ Customers loaded successfully\n");
    }
    
    private static void displayMenu() {
        System.out.println("What would you like to test?");
        System.out.println("1. Savings Account");
        System.out.println("2. Student Account");
        System.out.println("3. Current Account");
        System.out.println("4. Business Account");
        System.out.println("5. Fixed Deposit Account");
        System.out.println("6. Senior Citizen FD");
        System.out.println("7. Run All Tests");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }
    
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
    
    private static void testSavingsAccount() {
        System.out.println("\n--- 💰 SAVINGS ACCOUNT ---");
        SavingsAccount savingsAcc = new SavingsAccount("SA001", 5000, customer1, 4.5);
        
        try {
            savingsAcc.displayDetails();
            System.out.println("Interest Rate: " + savingsAcc.getInterestRate() + "%");
            System.out.println("Interest Earned: ₹" + String.format("%.2f", savingsAcc.calculateInterest()));
            
            System.out.print("\nDeposit ₹1000? (y/n): ");
            if (scanner.nextLine().toLowerCase().startsWith("y")) {
                savingsAcc.deposit(1000);
                System.out.println("✓ New Balance: ₹" + savingsAcc.getBalance());
            }
            
            System.out.print("Withdraw ₹500? (y/n): ");
            if (scanner.nextLine().toLowerCase().startsWith("y")) {
                savingsAcc.withdraw(500);
                System.out.println("✓ New Balance: ₹" + savingsAcc.getBalance());
            }
        } catch (Exception e) {
            System.out.println("⚠ Error in Savings Account: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testStudentAccount() {
        System.out.println("\n--- 🎓 STUDENT ACCOUNT ---");
        StudentAccount studentAcc = new StudentAccount("STU001", 2000, customer2, 3.5, 5000);
        
        try {
            studentAcc.displayDetails();
            System.out.println("Scholarship: ₹" + studentAcc.getScholarshipAmount());
            System.out.println("Interest Rate: " + studentAcc.getInterestRate() + "%");
            studentAcc.deposit(500);
            System.out.println("✓ After depositing ₹500, Balance: ₹" + studentAcc.getBalance());
        } catch (Exception e) {
            System.out.println("⚠ Error in Student Account: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testCurrentAccount() {
        System.out.println("\n--- 📊 CURRENT ACCOUNT ---");
        CurrentAccount currentAcc = new CurrentAccount("CA001", 10000, customer3, 5000);
        
        try {
            currentAcc.displayDetails();
            System.out.println("Overdraft Limit: ₹" + currentAcc.getOverdraftLimit());
            currentAcc.withdraw(3000);
            System.out.println("✓ After withdrawal, Balance: ₹" + currentAcc.getBalance());
        } catch (Exception e) {
            System.out.println("⚠ Error in Current Account: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testBusinessAccount() {
        System.out.println("\n--- 🏢 BUSINESS ACCOUNT ---");
        BusinessAccount businessAcc = new BusinessAccount("BA001", 50000, customer1, 10000, 
                                                           "Tech Solutions Ltd", "18AABCU9603R1Z0");
        try {
            businessAcc.displayDetails();
            System.out.println("Overdraft Limit: ₹" + businessAcc.getOverdraftLimit());
            System.out.println("\n" + businessAcc.generateGSTReport());
            businessAcc.deposit(5000);
            System.out.println("✓ After deposit, Balance: ₹" + businessAcc.getBalance());
        } catch (Exception e) {
            System.out.println("⚠ Error in Business Account: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testFixedDeposit() {
        System.out.println("\n--- 📈 FIXED DEPOSIT ACCOUNT ---");
        FixedDepositAccount fdAcc = new FixedDepositAccount("FD001", 100000, customer2, 6.5, 5);
        
        try {
            fdAcc.displayDetails();
            double maturity = fdAcc.calculateMaturityAmount();
            System.out.println("Principal: ₹100,000");
            System.out.println("Rate: 6.5% p.a.");
            System.out.println("Duration: 5 years");
            System.out.println("Maturity Amount: ₹" + String.format("%.2f", maturity));
        } catch (Exception e) {
            System.out.println("⚠ Error in FD Account: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testSeniorCitizenFD() {
        System.out.println("\n--- 👴 SENIOR CITIZEN FD (Special Benefit) ---");
        SeniorCitizenFD seniorFdAcc = new SeniorCitizenFD("SFD001", 200000, customer3, 6.5, 3, 1.0);
        
        try {
            seniorFdAcc.displayDetails();
            System.out.println("Base Rate: 6.5%");
            System.out.println("Senior Citizen Bonus: +" + seniorFdAcc.getExtraInterestRate() + "%");
            double maturity = seniorFdAcc.calculateMaturityAmount();
            System.out.println("Effective Rate: 7.5%");
            System.out.println("Maturity Amount (3 years): ₹" + String.format("%.2f", maturity));
        } catch (Exception e) {
            System.out.println("⚠ Error in Senior Citizen FD: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void runAllTests() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Running comprehensive test suite...");
        System.out.println("=".repeat(50) + "\n");
        
        testSavingsAccount();
        testStudentAccount();
        testCurrentAccount();
        testBusinessAccount();
        testFixedDeposit();
        testSeniorCitizenFD();
        
        System.out.println("✓ All tests completed successfully!");
    }
}
