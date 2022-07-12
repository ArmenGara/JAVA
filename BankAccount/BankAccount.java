public class BankAccount{
    private double checkingBalance =0.0;
    private double savingBalance = 0.0;
    // Class Varaiable
    private static int totalAccounts = 0;
    private static double totalBalance = 0.0;
    
    // Empty Constructor
    public BankAccount(){
        this.checkingBalance = 0;
        this.savingBalance = 0;
        totalAccounts++;
    }
    // Full Constructor
    public BankAccount( double checkingBalance, double savingBalance){
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        totalAccounts++;
        totalBalance = checkingBalance + savingBalance + totalBalance;
    }
    
    public static void printTotalAccounts(){
        System.out.println(totalAccounts);
    }
    
    public static void printTotalBalance(){
        System.out.println(totalBalance);
    }
    // Other Methods

    // Getters
    public double getChecking(){
        System.out.println(this.checkingBalance);
        return this.checkingBalance;
    }

    public double getSaving(){
        System.out.println(this.savingBalance);
        return this.savingBalance;
    }

    //Setters
    public double depositChecking(double checkingBalance){
        this.checkingBalance += checkingBalance;
        System.out.println("Checking Balance: " + this.checkingBalance);
        totalBalance += checkingBalance;
        return this.checkingBalance;
    }
    public double depositSavings(double savingBalance){
        this.savingBalance += savingBalance;
        System.out.println("Saving Balance: " + this.savingBalance);
        totalBalance += savingBalance;
        return this.savingBalance;
    }

    public double withdrawChecking(double checkingbalance){
        if(this.checkingBalance >= checkingBalance){
            this.checkingBalance -= checkingBalance;
            System.out.println("Checking Balance " + this.checkingBalance);
            totalBalance -= checkingBalance;
            return this.checkingBalance;
            }
            System.out.println("Insufficient Funds!");
            return this.checkingBalance;
    }

    public double withdrawSaving(double savingbalance){
        if(this.savingBalance >= savingBalance){
            this.savingBalance -= savingBalance;
            System.out.println("Saving Balance " + this.savingBalance);
            totalBalance -= savingBalance;
            return this.savingBalance;
            }
            System.out.println("Insufficient Funds!");
            return this.savingBalance;
    }

    public double printBalanceTotal(){
        double sum = this.checkingBalance + this.savingBalance;
        System.out.println("Account Total: " + sum);
        return sum;
    }
    
}
