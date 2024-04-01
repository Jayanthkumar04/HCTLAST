package com.jay.hctlast.service;

import com.jay.hctlast.entity.*;
import com.jay.hctlast.exceptions.ExceptionResponse;
import com.jay.hctlast.repo.*;
import com.jay.hctlast.entity.Acc_Transaction_Response;
import com.jay.hctlast.response.BalanceResponse;
import com.jay.hctlast.response.CustResponse;
import com.jay.hctlast.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class BankService {


@Autowired
   Cust_AddressRepo custAddressRepo;

@Autowired
   Cust_DetailsRepo custDetailsRepo;

@Autowired
Acc_BalanceRepo acc_balanceRepo;

@Autowired
    Cust_Acc_MapRepo cust_acc_mapRepo;
@Autowired
    Acc_TransactionRepo accTransactionRepo;


public Object addCustomer(Cust_FullAddress cfa)
    {
      Random rm = new Random();

      long cid = rm.nextInt(600000-500000+1)+500000;

      long aid =rm.nextInt(600000-500000+1)+500000;

      long acc_id = rm.nextInt(600000-500000+1)+500000;

      Timestamp currentTimestamp = new Timestamp(new Date().getTime());
      Cust_Address custaddress = new Cust_Address(aid,cfa.getCountry(),cfa.getCity(),cfa.getAddressLine(),cfa.getPin(),currentTimestamp);

      Cust_Details custDeatils = new Cust_Details(cid,cfa.getName(),aid,cfa.getPhone(),cfa.getEmail(),currentTimestamp,currentTimestamp);

       custAddressRepo.save(custaddress);

       custDetailsRepo.save(custDeatils);

       Acc_Balance accBalance = new Acc_Balance(acc_id,500);

       acc_balanceRepo.save(accBalance);

        Cust_Acc_Map custAccMap = new Cust_Acc_Map(acc_id,cid);

        cust_acc_mapRepo.save(custAccMap);

       return new CustResponse(custDeatils.getName(),cid,aid,accBalance.getBalance());

    }

    public List<Cust_Details> getAllCustomers()
    {
        return custDetailsRepo.findAll();
    }

    public Object getCustomer(long id)
    {
        Optional<Cust_Details> opt = custDetailsRepo.findById(id);
        if(opt.isPresent())
        return custDetailsRepo.findById(id).get();

        else
            return new ExceptionResponse("Provided input's {query params or path params} is/are Invalid!.","HCTB404");

    }


    public Object getBalanceBycust_id(long id)
    {
        try{
            Cust_Acc_Map cap=cust_acc_mapRepo.findByCustId(id);
            Optional<Acc_Balance> ab=acc_balanceRepo.findById(cap.getAcc_id());
            if(ab.isPresent())
                return new BalanceResponse(cap.getAcc_id(),ab.get().getBalance());
            else
                return new ExceptionResponse("account details not found","hct404");
        }
        catch (Exception e){
            return new ExceptionResponse("customer details not found","hct404");
        }


    }


    public Object getBalanceByacc_id(long acc_id) {
        try {
            Optional<Acc_Balance> ab=acc_balanceRepo.findById(acc_id);
            if(ab.isPresent())
                return new BalanceResponse(acc_id,ab.get().getBalance());
            else
                return new ExceptionResponse("customer details not found","hct404");
        }
        catch (Exception e){
            return new ExceptionResponse("customer details not found","hct404");
        }

    }

public Object newTransaction(Acc_Transaction_Response accTran)
{
    Timestamp currentTime = new Timestamp(new Date().getTime());
    long acc_id = accTran.getAcc_id();

    long to_acc_id= accTran.getTo_acc_id();

    double amount = accTran.getAmount();
    Random rm = new Random();

    long transac_id1=rm.nextInt(600000-500000+1)+500000;

    long transac_id2=rm.nextInt(600000-500000+1)+500000;

    long ref_id=rm.nextInt(600000-500000+1)+500000;


    Optional<Acc_Balance> sender = acc_balanceRepo.findById(acc_id);

    if(sender.isPresent())
    {
        Acc_Balance transactionAmount = sender.get();
        double accBalance = transactionAmount.getBalance();
        if(accBalance >= amount)
        {
            transactionAmount.setBalance(accBalance-amount);

            Acc_Transactions accTransactions = new Acc_Transactions(transac_id1,ref_id,acc_id,0,amount,transactionAmount.getBalance(),currentTime);

            accTransactionRepo.save(accTransactions);

            acc_balanceRepo.save(transactionAmount);
        }
        else {
            return new TransactionResponse("Insufficient balance in sender's account","hct400",ref_id);

        }

    }
    else {
        return new TransactionResponse("sender account not found","HCTB400");
    }

    Optional<Acc_Balance> receiver = acc_balanceRepo.findById(to_acc_id);

    if(receiver.isPresent())
    {
        Acc_Balance transactionAmount = receiver.get();
        double accBalance = transactionAmount.getBalance();

            transactionAmount.setBalance(accBalance+amount);

            Acc_Transactions accTransactions = new Acc_Transactions(transac_id2,ref_id,to_acc_id,amount,0,transactionAmount.getBalance(),currentTime);

            accTransactionRepo.save(accTransactions);

            acc_balanceRepo.save(transactionAmount);
        }
        else {
            return new TransactionResponse("Receiver account not found","hct400");

        }


    return new TransactionResponse("Transaction Sucessfull","HCT200",ref_id);
    }



    public List<Acc_Transactions>  getTransactionsByAccId(long acc_id)
    {

        return accTransactionRepo.findByAcc_id(acc_id);

    }

    public List<Acc_Transactions>  getTransactionsByRefId(long ref_id)
    {

        return accTransactionRepo.findByRef_id(ref_id);

    }

    public List<Acc_Transactions> getTransactionsByBoth(long ref_id,long acc_id)
    {
        return accTransactionRepo.findByBoth(ref_id,acc_id);
    }



}

