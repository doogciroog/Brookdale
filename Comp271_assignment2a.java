/*
Doug Ciraulo
COMP-271-801RL
Assignment 2A
 */
package comp271_assignment2a;

import java.util.Date;
    
    class Account {
        
        private int accountID;
        private double balance;
        private double annRate;
        private Date dateCreated;
        
        Account(){
            dateCreated = new Date();
        }
        
        Account(int ID, double balance, double annRate){
            this();
            this.accountID = ID;
            this.balance = balance;
            this.annRate = annRate;
        }
        
        public int getID(){
            return accountID;
        }
        
        public void setID(int accountNum){
            this.accountID = accountNum;
        }
        
        public double getBalance(){
            return balance;
        }
        
        public void setBalance(double balance){
            this.balance = balance;
        }
        
        public double getRate(){
            return annRate;
        }
        
        public void setRate(double annRate){
            this.annRate = annRate;
        }
        
        public Date getDate(){
            return dateCreated;
        }
        
        public void setDate(Date dateCreated){
            this.dateCreated = dateCreated;
        }
        
        public void deposit(double deposit){
            balance += deposit;
        }
        
        public void withdraw(double withdraw){
            balance -= withdraw;
        }
        
        @Override
        public String toString(){
            return "Account ID: " + this.getID() + "\n"
                    + "Balance: " + this.getBalance() + "\n"
                    + "Interest Rate: " + this.getRate() + "\n"
                    + "Date Created: " + this.getDate() + "\n";
        } 
        
    }
    
    class SavingsAccount extends Account {
        
        SavingsAccount(){
            super();
        }
        
        SavingsAccount(int accountID, double balance, double annRate){
            super(accountID, balance, annRate);
        }
        
        @Override
        public String toString(){
            return "Account ID: " + this.getID() + "\n"
                    + "Balance: " + this.getBalance() + "\n"
                    + "Interest Rate: " + this.getRate() + "\n"
                    + "Date Created: " + this.getDate() + "\n";
        }
        
    }
    
    class CheckingAccount extends Account {
        
        private double overdraft;
        
        CheckingAccount(){
            super();
        }
        
        CheckingAccount(int accountID, double balance, double annRate, double overdraft){
            super(accountID, balance, annRate);
            this.overdraft = overdraft;
        }
        
        public double getLimit(){
            return overdraft;
        }
        
        public void setLimit(double overdraft){
            this.overdraft = overdraft;
        }
        
        @Override
        public void withdraw(double withdraw){
            if(withdraw <= overdraft && withdraw <= this.getBalance()){
               double newBalance = this.getBalance() - withdraw;
               this.setBalance(newBalance);
            }
            else if(withdraw > overdraft){
                System.out.println("Overdraft limit exceeded");
            }
            else if(withdraw > this.getBalance()){
                System.out.println("Withdraw amount exceeds balance");
            }
        }
        
        @Override
        public String toString(){
            return "Account ID: " + this.getID() + "\n"
                    + "Balance: " + this.getBalance() + "\n"
                    + "Interest Rate: " + this.getRate() + "\n"
                    + "Withdraw Limit: " + this.getLimit() + "\n"
                    + "Date Created: " + this.getDate() + "\n";
        }
        
    }
        
class Comp271_assignment2a {
    
    public static void main(String[] args) {
        
        Account account = new Account(1, 1080.98, .06);
        SavingsAccount savings = new SavingsAccount(2, 2112.76, .09);
        CheckingAccount checking = new CheckingAccount(3, 1001.96, .06, 250.00);
        CheckingAccount checking2 = new CheckingAccount(4, 20.01, .06, 250.00);
        
        System.out.println(
                account.toString() + "\n"
                 + savings.toString() + "\n"
                 + checking.toString() + "\n"
                 + checking2.toString() + "\n"
        );
        
        checking.withdraw(250.01);
        checking2.withdraw(20.02);
        
    }

}