package iss;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */

public class BankAccount
{
    private final String name;
    private final String accNum;
    private float balance;
    private ArrayList<String> history;
    private boolean isClosed;
    private String createDate;
    private String closeDate;

    public BankAccount (String name) {
        this.name = name;
        this.balance = 0;
        this.accNum = String.valueOf(new Random().nextInt(100 - 1 + 1) + 1);
        this.history = new ArrayList<String>();
        this.isClosed = false;
        this.createDate = LocalDate.now().toString();
    }

    public BankAccount (String name, float balance) {
        this.name = name;
        this.balance = balance;
        this.accNum = String.valueOf(new Random().nextInt(100 - 1 + 1) + 1);
        this.history = new ArrayList<String>();
        this.isClosed = false;
        this.createDate = LocalDate.now().toString();
    }



    public boolean getClosed() {
        return this.isClosed;
    }

    public void setClosed() {
        this.isClosed = true;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float money) {
        this.balance = money;
    }

    public String getcreateDate() {
        return this.createDate;
    }

    public ArrayList<String> getHistory() {
        return this.history;
    }

    public void deposit(float money) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();  
            if(money <= 0 || this.getClosed()) {
                throw new IllegalArgumentException("Deposit amount must be positive and account cannot be closed");
            }
            else {
                this.setBalance(this.getBalance() + money);
                String txn = String.format("deposit $%f at ", money) + formatter.format(date);
                this.history.add(txn);
                System.out.println(txn);           
            }
    }

    public void withdraw(float money) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        if(money <= 0 || this.getClosed() || (this.getBalance() - money < 0)) {
            throw new IllegalArgumentException("Withdraw amount must be positive, account cannot be closed and must also have sufficient balance to withdraw from");
        }
        else {
            this.setBalance(this.getBalance() - money);
            String txn = String.format("withdraw $%f at ", money) + formatter.format(date);
            this.history.add(txn);
            System.out.println(txn);       
        }
}
}
