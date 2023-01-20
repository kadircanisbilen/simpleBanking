package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account/v1")
public class AccountController {

    private AccountService accountService;
    private TransactionService transactionService;

    @Autowired
    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public void healthCheck(){
        System.out.println("Server is running!");
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {

        try {
            Account foundAccount = this.accountService.findAccount(accountNumber);
            return new ResponseEntity<>(foundAccount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, DepositTransaction trx) {
        try {
            Account foundAccount = this.accountService.findAccount(accountNumber);
            String approvalCode = foundAccount.post(trx);
            this.accountService.save(foundAccount);
            return new ResponseEntity<>(new TransactionStatus(approvalCode ,"OK"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, WithdrawalTransaction trx) {
        return handleGenericPayment(accountNumber,trx);
    }

    @PostMapping("/bill-payment/{accountNumber}")
    public ResponseEntity<TransactionStatus> billPayment(@PathVariable String accountNumber, BillPaymentTransaction trx) {
        return handleGenericPayment(accountNumber,trx);
    }

    @PostMapping("/phone-bill-payment/{accountNumber}")
    public ResponseEntity<TransactionStatus> phoneBillPayment(@PathVariable String accountNumber, PhoneBillPaymentTransaction trx) {
        return handleGenericPayment(accountNumber,trx);
    }

    private ResponseEntity<TransactionStatus> handleGenericPayment(String accountNumber, WithdrawalTransaction trx){

        Account foundAccount;
        try {
            foundAccount = this.accountService.findAccount(accountNumber);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String approvalCode = foundAccount.post(trx);
        this.accountService.save(foundAccount);
        return new ResponseEntity<>(new TransactionStatus(approvalCode ,"OK"), HttpStatus.OK);
    }

}