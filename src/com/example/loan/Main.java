package com.example.loan;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static ArrayList<Loans> loans = new ArrayList<Loans>();
    static ArrayList<Dues> dues = new ArrayList<Dues>();
    static int customerid;
    static String customername, dob;
    static int lcustid, lacid, lltype, fcust;
    static float lamount;
    static String ldate;
    static int dloanid;
    static String damount, ddate;

    public static void main(String[] args) {
        domain();
    }

    public static void pr(String val) {
        System.out.println(val);
    }

    public static void displaycustomer() {
        int len = customers.size();
        for (int i = 0; i < len; i++) {
            pr(String.valueOf(customers.get(i).getCustomerid()));
            pr(customers.get(i).getCustomername());
            pr(customers.get(i).getDob());
            pr("-----");
        }
    }

    public static void displayloans() {
        int len = loans.size();
        for (int i = 0; i < len; i++) {
            pr(String.valueOf(loans.get(i).getCustomerid()));
            for (int j = 0; j < customers.size(); j++) {
                if (customers.get(j).getCustomerid() == loans.get(i).getCustomerid()) {
                    pr(customers.get(j).getCustomername());
                }
            }

            pr(String.valueOf(loans.get(i).getAccountid()));
            pr(String.valueOf(loans.get(i).getLoantype()));
            if (loans.get(i).getLoantype() == 1) {
                pr("Home Loan");
            } else {
                pr("Personal Loan");
            }
            pr(String.valueOf(loans.get(i).getAmount()));
            pr(String.valueOf(loans.get(i).getDate()));

            pr("-----");
        }
    }

    public static void domain() {
        pr("Please Following Options");
        pr("1 Create Customer");
        pr("2 Create Loan");
        pr("3 View List of Loans");
        pr("4 View List of Customers");
        pr("5 Loan Repayments");
        pr("6 Exit");
        Scanner myObj = new Scanner(System.in);
        int options = myObj.nextInt();
        switch (options) {
            case 1:
                pr("Enter the customer id");
                Scanner ob = new Scanner(System.in);
                customerid = ob.nextInt();
                if (customerid != 0 && customerid > 0) {
                    pr("Enter Customername");
                    Scanner obj = new Scanner(System.in);
                    customername = obj.nextLine();
                    if (!customername.isEmpty()) {
                        pr("Enter Dob(dd-mm-yyyy)");
                        Scanner a = new Scanner(System.in);
                        dob = a.nextLine();
                        if (!dob.isEmpty()) {
                            Customer c = new Customer(customerid, customername, dob);
                            customers.add(c);
                        }
                    }
                }
                domain();
                break;
            case 2:
                pr("Select Customers");
                try {
                    for (int i = 0; i < customers.size(); i++) {
                        pr(1 + " " + customers.get(i).getCustomername());
                    }
                    Scanner cc = new Scanner(System.in);
                    int v = cc.nextInt();
                    lcustid = customers.get(v - 1).getCustomerid();
                    pr("Enter Accountid");
                    Scanner b = new Scanner(System.in);
                    lacid = b.nextInt();
                    if (lacid != 0 && lacid > 0) {
                        pr("Enter loantype");
                        pr("1 home loan");
                        pr("2 personalloan");
                        Scanner d = new Scanner(System.in);
                        int gc = d.nextInt();
                        switch (gc) {
                            case 1:
                                lltype = 1;
                                break;
                            case 2:
                                lltype = 2;
                                break;
                            default:
                                pr("try later");
                                break;
                        }
                        if (lltype != 0 && lltype > 0) {
                            pr("Enter Amount");
                            Scanner e = new Scanner(System.in);
                            lamount = e.nextFloat();
                            if (lamount != 0 && lamount > 0) {
                                pr("Enter date(dd-mm-yyyy)");
                                Scanner g = new Scanner(System.in);
                                ldate = g.nextLine();
                                if (!ldate.isEmpty()) {
                                    Loans l = new Loans(lcustid, lacid, lltype, lamount, ldate);
                                    loans.add(l);
                                    float damount = lamount / 12;
                                    Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(ldate);
                                    Calendar cal = Calendar.getInstance();
                                    cal.setTime(date1);
                                    for (int i = 1; i <= 12; i++) {
                                        cal.add(Calendar.DAY_OF_MONTH, i);
                                        date1.setTime(cal.getTime().getTime()); // or
                                        date1 = new Timestamp(cal.getTime().getTime());

                                        Dues ds = new Dues(lacid, damount, String.valueOf(date1));
                                        dues.add(ds);
                                    }

                                }
                            }
                        }
                    }
                } catch (Exception r) {
                    r.printStackTrace();
                }
                domain();
                break;
            case 3:
                displayloans();
                domain();
                break;
            case 4:
                displaycustomer();
                domain();
                break;
            case 5:
                pr("Select Customer");
                selloan();
                break;
            case 6:
                break;
            default:
                break;
        }
    }

    public static void selloan() {
        try {
            for (int i = 0; i < customers.size(); i++) {
                pr(1 + " " + customers.get(i).getCustomername());
            }
            Scanner cc = new Scanner(System.in);
            int v = cc.nextInt();
            fcust = customers.get(v - 1).getCustomerid();
            pr("select loans");
            for (int j = 0; j < loans.size(); j++) {
                if (loans.get(j).getCustomerid() == fcust) {
                    pr(j + String.valueOf(loans.get(j).getAccountid()));
                }
            }
            Scanner l = new Scanner(System.in);
            int vs = l.nextInt();
            int selloan = loans.get(vs).getAccountid();
            try {
                for (int i = 0; i < dues.size(); i++) {
                    if(dues.get(i).getLoanid()==selloan){
                        pr(String.valueOf(dues.get(i).getAmount()));
                        pr(String.valueOf(dues.get(i).getDate()));
                    }
                }
            } catch (Exception r) {
                r.printStackTrace();
            }
        } catch (Exception r) {
            r.printStackTrace();
        }
    }
}
