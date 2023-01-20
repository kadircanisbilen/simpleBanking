package com.eteration.simplebanking.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@ToString
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private double balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void deposit(double amount){
        this.balance += amount;
    }


    public void withdraw(double amount) throws InsufficientBalanceException {
        if(this.balance >= amount)
            this.balance -= amount;
        else throw new InsufficientBalanceException();
    }


    public String post(DepositTransaction trx){
        this.deposit(trx.getAmount());
        UUID uuid = UUID.randomUUID();
        trx.setApprovalCode(uuid.toString());
        trx.setTransactionType(trx.getClass().getSimpleName());
        this.getTransactions().add(trx);

        return uuid.toString();
    }

    public String post(WithdrawalTransaction trx) throws InsufficientBalanceException {
        this.withdraw(trx.getAmount());
        UUID uuid = UUID.randomUUID();
        trx.setApprovalCode(uuid.toString());
        trx.setTransactionType(trx.getClass().getSimpleName());
        this.getTransactions().add(trx);

        return uuid.toString();
    }
}
