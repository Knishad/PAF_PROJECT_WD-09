package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Suppliers")
public class SupplierResource {

	Supplier supplierObj = new Supplier();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readsuppliers() {
		SupplierService supplierObj = new SupplierService();

		return supplierObj.readsuppliers();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertsupplier(String supplierData) {
		JsonObject supplierObject = new JsonParser().parse(supplierData).getAsJsonObject();

		String AccNo = supplierObject.get("AccNo").getAsString();
		Float UnitPrice = supplierObject.get("UnitPrice").getAsFloat();
		String StartDate = supplierObject.get("StartDate").getAsString();
		String LastDate = supplierObject.get("LastDate").getAsString();
		Float NoOfUnits = supplierObject.get("NoOfUnits").getAsFloat();

		SupplierService supplierObject2 = new SupplierService();

		supplierObj.setAccNo(AccNo);
		supplierObj.setUnitPrice(UnitPrice);
		supplierObj.setStartDate(StartDate);
		supplierObj.setLastDate(LastDate);
		supplierObj.setNoOfUnits(NoOfUnits);

		String output = supplierObject2.insertsupplier(supplierObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatesupplier(String supplierData) {
		// Convert the input string to a JSON object
		JsonObject supplierObject = new JsonParser().parse(supplierData).getAsJsonObject();
		// Read the values from the JSON object
		String AccNo = supplierObject.get("AccNo").getAsString();
		Float UnitPrice = supplierObject.get("UnitPrice").getAsFloat();
		String StartDate = supplierObject.get("StartDate").getAsString();
		String LastDate = supplierObject.get("LastDate").getAsString();
		Float NoOfUnits = supplierObject.get("NoOfUnits").getAsFloat();

		SupplierService supplierObject1 = new SupplierService();

		supplierObj.setAccNo(AccNo);
		supplierObj.setUnitPrice(UnitPrice);
		supplierObj.setStartDate(StartDate);
		supplierObj.setLastDate(LastDate);
		supplierObj.setNoOfUnits(NoOfUnits);

		String output = supplierObject1.updatesupplier(supplierObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletesupplier(String supplierData) {

		JsonObject supplierObject = new JsonParser().parse(supplierData).getAsJsonObject();

		String AccNo = supplierObject.get("AccNo").getAsString();

		SupplierService supplierObject2 = new SupplierService();
		supplierObj.setAccNo(AccNo);

		String output = supplierObject2.deletesupplier(supplierObj);
		return output;
	}

}