package com.eteration.simplebanking.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "deposit_transaction")
@PrimaryKeyJoinColumn(name = "transaction_id")
public class DepositTransaction extends Transaction{

    public DepositTransaction(double amount) {
        super(amount);
    }

    public DepositTransaction() {
        super();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
