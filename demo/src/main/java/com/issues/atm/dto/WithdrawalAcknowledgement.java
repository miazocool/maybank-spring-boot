package com.issues.atm.dto;

import com.issues.atm.history.ClientTransactionHistory;

public class WithdrawalAcknowledgement {
    private String status;
    private ClientTransactionHistory transactionHistory;
    public WithdrawalAcknowledgement(){};
    public WithdrawalAcknowledgement(String status, ClientTransactionHistory transactionHistory) {
        this.status = status;
        this.transactionHistory = transactionHistory;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClientTransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ClientTransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
