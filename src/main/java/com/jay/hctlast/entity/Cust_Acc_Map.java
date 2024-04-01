package com.jay.hctlast.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cust_Acc_Map {
    @Id
    long acc_id;

    long cust_id;

    public Cust_Acc_Map() {
    }

    public Cust_Acc_Map(long acc_id, long cust_id) {
        this.acc_id = acc_id;
        this.cust_id = cust_id;
    }


    public long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }




}
