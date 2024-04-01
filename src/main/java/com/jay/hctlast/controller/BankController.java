package com.jay.hctlast.controller;

import com.jay.hctlast.entity.*;
import com.jay.hctlast.exceptions.ExceptionResponse;
import com.jay.hctlast.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hct")
public class BankController {
    @Autowired
    BankService bankService;

    @PostMapping("customers")
    public Object addCustomer(@RequestBody Cust_FullAddress cfa) {


        return bankService.addCustomer(cfa);


    }

    @GetMapping("customers")

    public List<Cust_Details> getAllCustomers() {
        return bankService.getAllCustomers();
    }

    @GetMapping("customers/{id}")
    public Object getCustomer(@PathVariable long id) {

        return bankService.getCustomer(id);

    }


    @GetMapping("balances")
    public Object getBalance(@RequestParam long cust_id, @RequestParam long acc_id) {
//        if( cust_id == 0 && acc_id ==0){
//            return new ExceptionResponse("Required Query parameter's are not provided!.","HCTB400");
//        }
//        else if(cust_id !=0 && acc_id==0){
//            return bankService.getBalanceBycust_id(cust_id);
//        }
//        else if(cust_id==0 && acc_id!=0){
//            return bankService.getBalanceByacc_id(acc_id);
//        }
//        else{
//            return bankService.getBalanceByacc_id(acc_id);
//        }

        if(cust_id !=0 && acc_id!=0)
        {
            return bankService.getBalanceBycust_id(cust_id);
        }
        else if(cust_id!=0)
        {

          return bankService.getBalanceBycust_id(cust_id);
        }
        else if(acc_id != 0)
        {
            return bankService.getBalanceByacc_id(acc_id);
        }
        else
        {
            return new ExceptionResponse("Required Query parameter's are not provided!.","HCTB400");
        }


    }


    @PostMapping("transactions")
    public Object newTransaction(@RequestBody Acc_Transaction_Response accTran)
    {
        String type = accTran.getType().toLowerCase();

        if(type.equals("credit")) {

            return bankService.newTransaction(accTran);

        }

        else if(type.equals("debit"))
        {
            return bankService.newTransaction(accTran);

        }

        else
            return new ExceptionResponse("Provided Details are Invalid!..","HCTB400");
    }

    @GetMapping("transactions")
    public Object getTransactions(@RequestParam long acc_id,@RequestParam long ref_id) {

        if(acc_id == 0 && ref_id ==0)
        {
            return new ExceptionResponse("Required Query parameter's are not provided!.","Hct404");
        }
        else if(acc_id!=0 && ref_id==0) {

                return bankService.getTransactionsByAccId(acc_id);

        }

        else if(acc_id==0 && ref_id!=0) {

            return bankService.getTransactionsByRefId(ref_id);

        }

        else if(acc_id !=0 && ref_id!=0)
        {
            return bankService.getTransactionsByBoth(ref_id,acc_id);
        }

        else return null;


    }



}

