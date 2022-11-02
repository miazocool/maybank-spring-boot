package com.issues.atm.history;

import javax.persistence.*;

@Entity
@Table(name = "history_transactions")
public class ClientTransactionHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int currentAmount;

    // standard constructors / setters / getters / toString
    public ClientTransactionHistory() {}
    public ClientTransactionHistory(String name, String type) {
        this.currentAmount = currentAmount;
    }

    @Override
    public String toString() {
        return String.format(
                "ClientTransactionHistory[id=%d, currentAmount='%s']",
                id, currentAmount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }
}
