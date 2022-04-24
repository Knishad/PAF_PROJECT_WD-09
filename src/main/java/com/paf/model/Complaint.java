package com.paf.model;

public class Complaint {

	private String ComplaintId;
	private String UserId;
	private String ComplaintDate;
	private String Complaint;

	public Complaint() {

	}

	public Complaint(String ComplaintId, String UserId, String ComplaintDate, String Complaint) {
		super();
		this.ComplaintId = ComplaintId;
		this.UserId = UserId;
		this.ComplaintDate = ComplaintDate;
		this.Complaint = Complaint;

	}

	public String getComplaintId() {
		return ComplaintId;
	}

	public void setComplaintId(String ComplaintId) {
		this.ComplaintId = ComplaintId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String UserId) {
		this.UserId = UserId;
	}

	public String getComplaintDate() {
		return ComplaintDate;
	}

	public void setComplaintDate(String ComplaintDate) {
		this.ComplaintDate = ComplaintDate;
	}

	public String getComplaint() {
		return Complaint;
	}

	public void setComplaint(String Complaint) {
		this.Complaint = Complaint;
	}

}
