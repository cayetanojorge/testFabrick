package it.example.testFabrick.model.bodyinmoneytransfer;

import lombok.Data;

@Data
public class Creditor{
	private Address address;
	private String name;
	private Account account;

	@Override
	public String toString() {
		return "{" +
				"address=" + address +
				", name='" + name + '\'' +
				", account=" + account +
				'}';
	}
}
