package iss;

public class FixedDepositAccount extends BankAccount{
    private float interest = 3;
    private int duration = 6;
    private boolean interestChanged = false;
    private boolean durationChanged = false;

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);    
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
        this.interestChanged = true;
    }

    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.interestChanged = true;
        this.duration = duration;
        this.durationChanged = true;
    }

    public void setDuration(int duration) {
        if(!durationChanged) {
            this.duration = duration;
            this.durationCharged = true;
        } 
    }

    public void setInterest(float interest) {
        if(!interestChanged) {
            this.interest = interest;
            this.interestChanged = true;
        }
    }

    public float getInterest() {
        return this.interest;
    }

    @Override
    public void deposit(float money) {

    }

    @Override 
    public void withdraw(float money) {

    }

    @Override
    public float getBalance() {
        return super.getBalance() + (this.getInterest()/100 * super.getBalance()) ;
    }

    @Override
    public void setBalance(float money) {

    }
}
