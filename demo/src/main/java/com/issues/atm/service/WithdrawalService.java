package com.issues.atm.service;

import com.issues.atm.dto.WithdrawRequest;
import com.issues.atm.dto.WithdrawalAcknowledgement;
import com.issues.atm.exceptions.InsufficientAmountException;
import com.issues.atm.history.ClientTransactionHistory;
import com.issues.atm.history.ClientTransactionHistoryRepository;
import com.issues.atm.transaction.Transaction;
import com.issues.atm.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class WithdrawalService {
    private static Map<String, Double> paymentMap = new HashMap<>();
    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 5000.0);
        paymentMap.put("acc4", 8000.0);
    }

    @Autowired
    private ClientTransactionHistoryRepository historyRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public WithdrawalAcknowledgement withdrawMoney (WithdrawRequest request) {

        ClientTransactionHistory history = request.getTransactionHistory();
        history = historyRepository.save(history);

        Transaction transactionInfo = request.getTransaction();

        this.validateWithdrawal(transactionInfo.getAccountNo(), history.getCurrent_amount());
        transactionRepository.save(transactionInfo);
        return new WithdrawalAcknowledgement("SUCCESS");

    }
    public static boolean validateWithdrawal(String accNo, double withdrawalAmount) {
        if (withdrawalAmount > paymentMap.get(accNo)) {
            throw new InsufficientAmountException("insufficient fund..!");
        } else {
            return true;
        }
    }
}