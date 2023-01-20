package com.eteration.simplebanking.controller;


public class TransactionStatus {

    private String status;

    private String approvalCode;

    public TransactionStatus(String status) {
        this.status = status;
    }
    public TransactionStatus(String approvalCode, String status) {
        this.approvalCode = approvalCode;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }
}
