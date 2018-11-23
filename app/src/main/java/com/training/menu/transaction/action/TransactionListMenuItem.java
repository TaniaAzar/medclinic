package com.training.menu.transaction.action;

import com.training.Transaction;
import com.training.menu.IMenuItem;
import com.training.menu.transaction.TransactionMenuItem;
import com.training.service.EntityListIdService;
import com.training.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@TransactionMenuItem
public class TransactionListMenuItem implements IMenuItem {

    private final EntityListIdService<Transaction> transactionService;

    @Autowired
    public TransactionListMenuItem(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public String getTitle() {
        return "Print all transaction";
    }

    @Override
    public int doAction() {
        transactionService.getAll().forEach(System.out::println);
        return 0;
    }
}
