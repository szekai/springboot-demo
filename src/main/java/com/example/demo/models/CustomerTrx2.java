package com.example.demo.models;

public class CustomerTrx2 {

	private String accNumber;
	private String trxAmount;
	private String description;
	private String trxDate;
	private String trxTime;
	private Long custId;

	public CustomerTrx2() {
	}

	public CustomerTrx2(String accNumber, String trxAmount, String description, String trxDate, String trxTime, Long custId) {
		this.accNumber = accNumber;
		this.trxAmount = trxAmount;
		this.description = description;
		this.trxDate = trxDate;
		this.trxTime = trxTime;
		this.custId = custId;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getTrxAmount() {
		return trxAmount;
	}

	public void setTrxAmount(String trxAmount) {
		this.trxAmount = trxAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}

	public String getTrxTime() {
		return trxTime;
	}

	public void setTrxTime(String trxTime) {
		this.trxTime = trxTime;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

}
