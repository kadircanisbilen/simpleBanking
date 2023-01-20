package com.eteration.simplebanking.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "withdrawal_transaction")
@PrimaryKeyJoinColumn(name = "transaction_id")
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction() {
        super();
    }
    public WithdrawalTransaction(double amount) {
        super(amount);
    }

}


