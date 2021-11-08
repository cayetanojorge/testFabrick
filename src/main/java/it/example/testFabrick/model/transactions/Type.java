package it.example.testFabrick.model.transactions;

import lombok.Data;

@Data
public class Type{
	private String enumeration;
	private String value;

	@Override
	public String toString() {
		return "{" +
				"enumeration='" + enumeration + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}
