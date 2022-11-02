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
        Transaction transactionInfo = request.getTransaction();

        history.setCurrentAmount(history.getCurrentAmount()- transactionInfo.getAmount());
        historyRepository.save(history);

        validateWithdrawal(transactionInfo.getAmount(), history.getCurrentAmount());

        transactionRepository.save(transactionInfo);
        return new WithdrawalAcknowledgement("SUCCESS", history);

    }
    public static boolean validateWithdrawal(int requestAmount, int currentAmount) {
        if (requestAmount > currentAmount) {
            throw new InsufficientAmountException("insufficient fund..!");
        } else {
            return true;
        }
    }
}