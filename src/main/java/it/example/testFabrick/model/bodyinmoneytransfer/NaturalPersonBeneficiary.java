package it.example.testFabrick.model.bodyinmoneytransfer;


import lombok.Data;

@Data
public class NaturalPersonBeneficiary{
	private Object fiscalCode3;
	private Object fiscalCode4;
	private Object fiscalCode5;
	private String fiscalCode1;
	private Object fiscalCode2;

	@Override
	public String toString() {
		return "{" +
				"fiscalCode3=" + fiscalCode3 +
				", fiscalCode4=" + fiscalCode4 +
				", fiscalCode5=" + fiscalCode5 +
				", fiscalCode1='" + fiscalCode1 + '\'' +
				", fiscalCode2=" + fiscalCode2 +
				'}';
	}
}
