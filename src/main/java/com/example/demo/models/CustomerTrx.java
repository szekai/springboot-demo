package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "cust_trx")
public class CustomerTrx {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String accNumber;
	private String trxAmount;
	private String description;
	private String trxDate;
	private String trxTime;
	private String custId;

	public CustomerTrx() {
	}

	public CustomerTrx(String accNumber, String trxAmount, String description, String trxDate, String trxTime, String custId) {
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

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "CustomerTrx{" +
				"accNumber='" + accNumber + '\'' +
				", trxAmount='" + trxAmount + '\'' +
				", description='" + description + '\'' +
				", trxDate='" + trxDate + '\'' +
				", trxTime='" + trxTime + '\'' +
				", custId='" + custId + '\'' +
				'}';
	}
}
