package com.eteration.simplebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bill_payment_transaction")
@PrimaryKeyJoinColumn(name = "transaction_id")
public class BillPaymentTransaction extends WithdrawalTransaction {

    @Column(name = "payee")
    private String payee;

    public BillPaymentTransaction() {
        super();
    }

    public BillPaymentTransaction(double amount, String payee) {
        super(amount);
        this.payee = payee;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}


