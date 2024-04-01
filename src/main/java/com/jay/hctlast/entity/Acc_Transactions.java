package com.jay.hctlast.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table
public class Acc_Transactions {
@Id
    long transaction_id;
long transaction_ref_id;

long acc_id;

double credit;

double debit;

double avlBalance;

Timestamp lastUpdated;

    public Acc_Transactions() {
    }

    public Acc_Transactions(long transaction_id, long transaction_ref_id, long acc_id, double credit, double debit, double avlBalance, Timestamp lastUpdated) {
        this.transaction_id = transaction_id;
        this.transaction_ref_id = transaction_ref_id;
        this.acc_id = acc_id;
        this.credit = credit;
        this.debit = debit;
        this.avlBalance = avlBalance;
        this.lastUpdated = lastUpdated;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getTransaction_ref_id() {
        return transaction_ref_id;
    }

    public void setTransaction_ref_id(long transaction_ref_id) {
        this.transaction_ref_id = transaction_ref_id;
    }

    public long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getAvlBalance() {
        return avlBalance;
    }

    public void setAvlBalance(double avlBalance) {
        this.avlBalance = avlBalance;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
