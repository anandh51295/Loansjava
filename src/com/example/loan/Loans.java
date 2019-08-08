package com.example.loan;

public class Loans {
    private int customerid;
    private int accountid;
    private int loantype;
    private float amount;
    private String date;

    Loans(int customerid,int accountid,int loantype,float amount,String date){
        this.customerid=customerid;
        this.accountid=accountid;
        this.loantype=loantype;
        this.amount=amount;
        this.date=date;

    }
    public int getCustomerid(){
        return customerid;
    }

    public void setCustomerid(int newCustomerid){
        this.customerid=newCustomerid;
    }

    public int getAccountid(){
        return accountid;
    }

    public void setAccountid(int newAccountid){
        this.accountid=newAccountid;
    }

    public int getLoantype(){
        return loantype;
    }

    public void setLoantype(int newLoantype){
        this.loantype=newLoantype;
    }

    public float getAmount(){
        return amount;
    }

    public void setAmount(float newAmount){
        this.amount=newAmount;
    }

    public String getDate(){
        return date;
    }

    public void setAmount(String newDate){
        this.date=newDate;
    }
}
