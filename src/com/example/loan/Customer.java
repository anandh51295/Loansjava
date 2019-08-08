package com.example.loan;

public class Customer {

    private int customerid;
    private String customername;
    private String dob;

    Customer(int customerid,String customername,String dob){
        this.customerid=customerid;
        this.customername=customername;
        this.dob=dob;
    }
    public int getCustomerid(){
        return customerid;
    }

    public void setCustomerid(int newCustomerid){
        this.customerid=newCustomerid;
    }

    public String getCustomername(){
        return customername;
    }

    public void setCustomername(String newCustomername){
        this.customername=newCustomername;
    }

    public String getDob(){
        return dob;
    }

    public void setDob(String newDob){
        this.dob=newDob;
    }

}
