package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Complaints")
public class ComplaintResource {

	Complaint complaintObj = new Complaint();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readcomplaints() {
		ComplaintService complaintObj = new ComplaintService();

		return complaintObj.readcomplaints();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertcomplaint(String complaintData) {
		JsonObject complaintObject = new JsonParser().parse(complaintData).getAsJsonObject();

		String ComplaintId = complaintObject.get("ComplaintId").getAsString();
		String UserId = complaintObject.get("UserId").getAsString();
		String ComplaintDate = complaintObject.get("ComplaintDate").getAsString();
		String Complaint = complaintObject.get("Complaint").getAsString();

		ComplaintService complaintObject2 = new ComplaintService();

		complaintObj.setComplaintId(ComplaintId);
		complaintObj.setUserId(UserId);
		complaintObj.setComplaintDate(ComplaintDate);
		complaintObj.setComplaint(Complaint);

		String output = complaintObject2.insertcomplaint(complaintObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatecomplaint(String complaintData) {
		// Convert the input string to a JSON object
		JsonObject complaintObject = new JsonParser().parse(complaintData).getAsJsonObject();
		// Read the values from the JSON object
		String ComplaintId = complaintObject.get("ComplaintId").getAsString();
		String UserId = complaintObject.get("UserId").getAsString();
		String ComplaintDate = complaintObject.get("ComplaintDate").getAsString();
		String Complaint = complaintObject.get("Complaint").getAsString();

		ComplaintService complaintObject1 = new ComplaintService();

		complaintObj.setComplaintId(ComplaintId);
		complaintObj.setUserId(UserId);
		complaintObj.setComplaintDate(ComplaintDate);
		complaintObj.setComplaint(Complaint);

		String output = complaintObject1.updatecomplaint(complaintObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletecomplaint(String complaintData) {

		JsonObject complaintObject = new JsonParser().parse(complaintData).getAsJsonObject();

		String ComplaintId = complaintObject.get("ComplaintId").getAsString();

		ComplaintService complaintObject2 = new ComplaintService();
		complaintObj.setComplaintId(ComplaintId);

		String output = complaintObject2.deletecomplaint(complaintObj);
		return output;
	}

}