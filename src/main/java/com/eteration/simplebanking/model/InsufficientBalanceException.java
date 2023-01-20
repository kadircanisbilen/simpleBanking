package com.eteration.simplebanking.model;

public class InsufficientBalanceException extends RuntimeException {
    InsufficientBalanceException() {
        super("Insufficient Balance!");
    }
}
