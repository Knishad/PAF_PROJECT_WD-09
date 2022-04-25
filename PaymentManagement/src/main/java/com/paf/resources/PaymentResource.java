package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Payments")
public class PaymentResource {

	Payment paymentObj = new Payment();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readpayments() {
		PaymentService paymentObj = new PaymentService();

		return paymentObj.readpayments();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertpayment(String paymentData) {
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();

		String AccNo = paymentObject.get("AccNo").getAsString();
		String PaymentDate = paymentObject.get("PaymentDate").getAsString();
		Float Amount = paymentObject.get("Amount").getAsFloat();
		String PaymentType = paymentObject.get("PaymentType").getAsString();

		PaymentService paymentObject2 = new PaymentService();

		paymentObj.setAccNo(AccNo);
		paymentObj.setPaymentDate(PaymentDate);
		paymentObj.setAmount(Amount);
		paymentObj.setPaymentType(PaymentType);

		String output = paymentObject2.insertpayment(paymentObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatepayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
		// Read the values from the JSON object
		String AccNo = paymentObject.get("AccNo").getAsString();
		String PaymentDate = paymentObject.get("PaymentDate").getAsString();
		Float Amount = paymentObject.get("Amount").getAsFloat();
		String PaymentType = paymentObject.get("PaymentType").getAsString();

		PaymentService paymentObject1 = new PaymentService();

		paymentObj.setAccNo(AccNo);
		paymentObj.setPaymentDate(PaymentDate);
		paymentObj.setAmount(Amount);
		paymentObj.setPaymentType(PaymentType);

		String output = paymentObject1.updatepayment(paymentObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletepayment(String paymentData) {

		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();

		String AccNo = paymentObject.get("AccNo").getAsString();

		PaymentService paymentObject2 = new PaymentService();
		paymentObj.setAccNo(AccNo);

		String output = paymentObject2.deletepayment(paymentObj);
		return output;
	}

}