package it.example.testFabrick.model.bodyinmoneytransfer;

import lombok.Data;

@Data
public class TaxRelief{
	private boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private LegalPersonBeneficiary legalPersonBeneficiary;
	private String taxReliefId;
	private String beneficiaryType;
	private NaturalPersonBeneficiary naturalPersonBeneficiary;

	@Override
	public String toString() {
		return "{" +
				"isCondoUpgrade=" + isCondoUpgrade +
				", creditorFiscalCode='" + creditorFiscalCode + '\'' +
				", legalPersonBeneficiary=" + legalPersonBeneficiary +
				", taxReliefId='" + taxReliefId + '\'' +
				", beneficiaryType='" + beneficiaryType + '\'' +
				", naturalPersonBeneficiary=" + naturalPersonBeneficiary +
				'}';
	}
}
