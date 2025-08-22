public class BankAccount {

    private int balance ;
    
    public synchronized void deposit(long amount) {
        balance += amount ;
    }

    public synchronized void withdraw(long amount) {
        if(balance>=amount) 
            balance -= amount ;
    }
    
    public double getBalance(){
        return this.balance;
    }

}