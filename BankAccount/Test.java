public class Test{
    public static  void main(String args[]){
        
        BankAccount newArmenBank = new BankAccount(30.0 , 70.0);
        newArmenBank.depositChecking(20.0);
        newArmenBank.getChecking();
        newArmenBank.getSaving();

        BankAccount newMaralBank = new BankAccount(50.0, 50.0);
        newMaralBank.depositSavings(50.0);
        newMaralBank.getSaving();



        //Withdrawl
        newArmenBank.withdrawChecking(10.0);
        newArmenBank.getChecking();
        
        
        BankAccount.printTotalBalance();
        BankAccount.printTotalAccounts();
    }
}