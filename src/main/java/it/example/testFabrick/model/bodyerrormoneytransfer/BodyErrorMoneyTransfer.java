package it.example.testFabrick.model.bodyerrormoneytransfer;

import lombok.Data;

import java.util.List;

@Data
public class BodyErrorMoneyTransfer{
	private Payload payload;
	private List<ErrorsItem> errors;
	private String status;

	@Override
	public String toString() {
		return "{" +
				"payload=" + payload +
				", errors=" + errors +
				", status='" + status + '\'' +
				'}';
	}
}