package com.paf.model;

public class Payment {

	private String AccNo;
	private String PaymentDate;
	private Float Amount;
	private String PaymentType;

	public Payment() {

	}

	public Payment(String AccNo, String PaymentDate, Float Amount, String PaymentType) {
		super();
		this.AccNo = AccNo;
		this.PaymentDate = PaymentDate;
		this.Amount = Amount;
		this.PaymentType = PaymentType;

	}

	public String getAccNo() {
		return AccNo;
	}

	public void setAccNo(String AccNo) {
		this.AccNo = AccNo;
	}

	public String getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(String PaymentDate) {
		this.PaymentDate = PaymentDate;
	}

	public Float getAmount() {
		return Amount;
	}

	public void setAmount(Float Amount) {
		this.Amount = Amount;
	}

	public String getPaymentType() {
		return PaymentType;
	}

	public void setPaymentType(String PaymentType) {
		this.PaymentType = PaymentType;
	}

}
