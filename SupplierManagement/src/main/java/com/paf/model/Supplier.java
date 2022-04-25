package com.paf.model;

public class Supplier {

	private String AccNo;
	private Float UnitPrice;
	private String StartDate;
	private String LastDate;
	private Float NoOfUnits;

	public Supplier() {

	}

	public Supplier(String AccNo, Float UnitPrice, String StartDate, String LastDate, Float NoOfUnits) {
		super();
		this.AccNo = AccNo;
		this.UnitPrice = UnitPrice;
		this.StartDate = StartDate;
		this.LastDate = LastDate;
		this.NoOfUnits = NoOfUnits;

	}

	public String getAccNo() {
		return AccNo;
	}

	public void setAccNo(String AccNo) {
		this.AccNo = AccNo;
	}

	public Float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Float UnitPrice) {
		this.UnitPrice = UnitPrice;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String StartDate) {
		this.StartDate = StartDate;
	}

	public String getLastDate() {
		return LastDate;
	}

	public void setLastDate(String LastDate) {
		this.LastDate = LastDate;
	}

	public Float getNoOfUnits() {
		return NoOfUnits;
	}

	public void setNoOfUnits(float NoOfUnits) {
		this.NoOfUnits = NoOfUnits;
	}

}
