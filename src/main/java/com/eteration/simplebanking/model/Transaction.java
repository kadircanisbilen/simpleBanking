package com.eteration.simplebanking.model;
import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @Column(name = "amount")
    protected double amount;

    @Column(name = "date")
    protected Date date;

    @Column(name = "approval_code")
    protected String approvalCode;

    @Column(name = "transaction_type")
    protected String transactionType;

    public Transaction(double amount) {
        this.amount = amount;
        this.date = Date.from(Instant.now());
    }

    public Transaction() {
        this.date = Date.from(Instant.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
