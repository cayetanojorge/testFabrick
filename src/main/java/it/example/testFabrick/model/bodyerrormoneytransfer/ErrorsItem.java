package it.example.testFabrick.model.bodyerrormoneytransfer;

import lombok.Data;

@Data
public class ErrorsItem{
	private String code;
	private String description;
	private String params;

	@Override
	public String toString() {
		return "{" +
				"code='" + code + '\'' +
				", description='" + description + '\'' +
				", params='" + params + '\'' +
				'}';
	}
}
