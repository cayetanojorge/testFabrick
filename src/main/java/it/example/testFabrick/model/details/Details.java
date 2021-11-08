package it.example.testFabrick.model.details;


import lombok.Data;

@Data
public class Details{
	private String holderName;
	private String cabCode;
	private String abiCode;
	private String internationalCin;
	private String productName;
	private String accountId;
	private String countryCode;
	private String iban;
	private String alias;
	private String currency;
	private String activatedDate;
	private String nationalCin;
	private String account;



	@Override
	public String toString() {
		return "{" +
				"holderName='" + holderName + '\'' +
				", cabCode='" + cabCode + '\'' +
				", abiCode='" + abiCode + '\'' +
				", internationalCin='" + internationalCin + '\'' +
				", productName='" + productName + '\'' +
				", accountId='" + accountId + '\'' +
				", countryCode='" + countryCode + '\'' +
				", iban='" + iban + '\'' +
				", alias='" + alias + '\'' +
				", currency='" + currency + '\'' +
				", activatedDate='" + activatedDate + '\'' +
				", nationalCin='" + nationalCin + '\'' +
				", account='" + account + '\'' +
				'}';
	}
}
