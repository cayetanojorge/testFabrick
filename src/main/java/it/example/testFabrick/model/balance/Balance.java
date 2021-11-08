package it.example.testFabrick.model.balance;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Balance{
	private String date;
	private BigDecimal balance;
	private String currency;
	private BigDecimal availableBalance;

	@Override
	public String toString() {
		return "{" +
				"date='" + date + '\'' +
				", balance=" + balance +
				", currency='" + currency + '\'' +
				", availableBalance=" + availableBalance +
				'}';
	}
}
