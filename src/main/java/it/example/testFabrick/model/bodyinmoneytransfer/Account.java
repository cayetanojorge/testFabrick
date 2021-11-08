package it.example.testFabrick.model.bodyinmoneytransfer;

import lombok.Data;

@Data
public class Account{
	private String accountCode;
	private String bicCode;

	@Override
	public String toString() {
		return "{" +
				"accountCode='" + accountCode + '\'' +
				", bicCode='" + bicCode + '\'' +
				'}';
	}
}
