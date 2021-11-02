package it.example.testFabrick.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;
    private String receiverName;
    private String description;
    private String currency;
    private String amount;
    private String executionDate;

    public User() {
    }

    public User(Long id, String receiverName, String description, String currency, String amount, String executionDate) {
        this.id = id;
        this.receiverName = receiverName;
        this.description = description;
        this.currency = currency;
        this.amount = amount;
        this.executionDate = executionDate;
    }

    public User(String receiverName, String description, String currency, String amount, String executionDate) {
        this.receiverName = receiverName;
        this.description = description;
        this.currency = currency;
        this.amount = amount;
        this.executionDate = executionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", receiverName='" + receiverName + '\'' +
                ", description='" + description + '\'' +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", executionDate='" + executionDate + '\'' +
                '}';
    }
}
