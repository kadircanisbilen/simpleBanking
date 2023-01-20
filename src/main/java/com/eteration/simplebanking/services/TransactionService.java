package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void save(DepositTransaction trx){
        this.transactionRepository.save(trx);
    }

}
