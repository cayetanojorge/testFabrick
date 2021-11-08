package it.example.testFabrick.model.transactions;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ListItem{
	private String accountingDate;
	private BigDecimal amount;
	private String operationId;
	private String description;
	private String currency;
	private String valueDate;
	private Type type;
	private String transactionId;

	@Override
	public String toString() {
		return "{" +
				"accountingDate='" + accountingDate + '\'' +
				", amount=" + amount +
				", operationId='" + operationId + '\'' +
				", description='" + description + '\'' +
				", currency='" + currency + '\'' +
				", valueDate='" + valueDate + '\'' +
				", type=" + type +
				", transactionId='" + transactionId + '\'' +
				'}';
	}
}
