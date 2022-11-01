package com.issues.atm.transaction;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String accountNo;
    private String amount;

    // standard constructors / setters / getters / toString
    public Transaction() {}
    public Transaction(String name, String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "Transaction[id=%d, name='%s', githubId='%s']",
                id, type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
