package it.example.testFabrick.model.bodyinmoneytransfer;

import lombok.Data;

@Data
public class Address{
	private Object address;
	private Object city;
	private Object countryCode;

	@Override
	public String toString() {
		return "{" +
				"address=" + address +
				", city=" + city +
				", countryCode=" + countryCode +
				'}';
	}
}
