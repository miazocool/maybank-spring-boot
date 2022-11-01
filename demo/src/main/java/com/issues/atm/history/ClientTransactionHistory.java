package com.issues.atm.history;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ClientTransactionHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int current_amount;

    // standard constructors / setters / getters / toString
    public ClientTransactionHistory() {}
    public ClientTransactionHistory(String name, String type) {
        this.current_amount = current_amount;
    }

    @Override
    public String toString() {
        return String.format(
                "ClientTransactionHistory[id=%d, current_amount='%s']",
                id, current_amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCurrent_amount() {
        return current_amount;
    }

    public void setCurrent_amount(int current_amount) {
        this.current_amount = current_amount;
    }
}
