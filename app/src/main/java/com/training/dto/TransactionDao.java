package com.training.dto;

import com.training.Patient;
import com.training.Product;
import com.training.Transaction;

public interface TransactionDao extends EntityCrudDao<Transaction> {
    void transaction(Product product, Patient patient);
}
