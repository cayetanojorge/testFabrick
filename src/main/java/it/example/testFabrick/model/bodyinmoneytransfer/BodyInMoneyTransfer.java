package it.example.testFabrick.model.bodyinmoneytransfer;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class BodyInMoneyTransfer{
	private boolean isUrgent;
	private BigDecimal amount;
	private TaxRelief taxRelief;
	private String feeAccountId;
	private String executionDate;
	private boolean isInstant;
	private String description;
	private Creditor creditor;
	private String currency;
	private String feeType;
	private String uri;

	@Override
	public String toString() {
		return "{" +
				"isUrgent=" + isUrgent +
				", amount=" + amount +
				", taxRelief=" + taxRelief +
				", feeAccountId='" + feeAccountId + '\'' +
				", executionDate='" + executionDate + '\'' +
				", isInstant=" + isInstant +
				", description='" + description + '\'' +
				", creditor=" + creditor +
				", currency='" + currency + '\'' +
				", feeType='" + feeType + '\'' +
				", uri='" + uri + '\'' +
				'}';
	}
}
