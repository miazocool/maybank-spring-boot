package com.issues.atm.dto;

import com.issues.atm.history.ClientTransactionHistory;
import com.issues.atm.transaction.Transaction;

public class WithdrawRequest {
    private ClientTransactionHistory transactionHistory;

    private Transaction transaction;

    public ClientTransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ClientTransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
