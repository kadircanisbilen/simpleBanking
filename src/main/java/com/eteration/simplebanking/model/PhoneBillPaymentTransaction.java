package com.eteration.simplebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "phone_bill_payment_transaction")
@PrimaryKeyJoinColumn(name = "transaction_id")
public class PhoneBillPaymentTransaction extends BillPaymentTransaction {

    @Column(name = "phone_number")
    public String phoneNumber;

    public PhoneBillPaymentTransaction() {
        super();
    }

    public PhoneBillPaymentTransaction(String payee, String phoneNumber, double amount) {
        super(amount, payee);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


