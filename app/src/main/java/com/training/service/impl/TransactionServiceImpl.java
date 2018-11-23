package com.training.service.impl;

import com.training.dto.TransactionDao;
import com.training.Patient;
import com.training.Product;
import com.training.Transaction;
import com.training.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends AbstractServiceIml<Transaction> implements TransactionService{

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public void transaction(Product product, Patient patient) {
        transactionDao.transaction(product,patient);
    }
}
