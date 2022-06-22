package Options;

public class Zad2 {

    private int accountBalance;

    public Zad2() {
        accountBalance = 0;
    }

    public Zad2(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean withdraw(int amount) {
        if (amount > accountBalance) {
            return false;
        }
        accountBalance -= amount;
        return true;
    }

    public void transfer(int amount) {
        accountBalance += amount;
    }

    public int getAccountBalance() {
        return accountBalance;
    }
}