package com.jay.hctlast.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Acc_Balance {
@Id
    long acc_id;

    double balance;

    public Acc_Balance() {
    }

    public Acc_Balance(long acc_id, double balance) {
        this.acc_id = acc_id;
        this.balance = balance;
    }

    public long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }


    public double getBalance() {
        return balance;
    }



    public void setBalance(double balance) {
        this.balance = balance;
    }




}
