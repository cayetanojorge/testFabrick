package it.example.testFabrick.model.bodyinmoneytransfer;

import lombok.Data;

@Data
public class LegalPersonBeneficiary{
	private Object fiscalCode;
	private Object legalRepresentativeFiscalCode;

	@Override
	public String toString() {
		return "{" +
				"fiscalCode=" + fiscalCode +
				", legalRepresentativeFiscalCode=" + legalRepresentativeFiscalCode +
				'}';
	}
}
