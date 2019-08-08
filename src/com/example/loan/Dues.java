package com.example.loan;

public class Dues {
    private int loanid;
    private float amount;
    private String date;

    Dues(int loanid,float amount,String date){
        this.loanid=loanid;
        this.amount=amount;
        this.date=date;
    }
    public int getLoanid() {
        return loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
