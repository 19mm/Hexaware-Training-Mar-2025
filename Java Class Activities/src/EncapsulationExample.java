class BankAccount {
    private double balance; // Private variable (hidden data)
 
    public BankAccount(double initialBalance) {  // Constructor
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative.");
        }
    }
 
    // Public method to deposit money (controlled access)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
 
    // Public method to withdraw money (controlled access)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
 
    // Public method to check balance (controlled access)
    public double getBalance() {
        return balance;
    }
}
 
// Execution Class
public class EncapsulationExample {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(5000); // Initial balance
 
        myAccount.deposit(2000);
        myAccount.withdraw(1000);
        System.out.println("Current Balance: " + myAccount.getBalance());
    }
}
 