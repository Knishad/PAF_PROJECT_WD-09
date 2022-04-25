package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class SupplierService {
	Connection con = null;

	public SupplierService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertsupplier(Supplier supplier) {
		String query = " insert into supplier(`AccNo`,`UnitPrice`,`StartDate`,`LastDate`,`NoOfUnits`)"
				+ " values (?,?, ?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, supplier.getAccNo());
			preparedStatement.setFloat(2, supplier.getUnitPrice());
			preparedStatement.setString(3, supplier.getStartDate());
			preparedStatement.setString(4, supplier.getLastDate());
			preparedStatement.setFloat(5, supplier.getNoOfUnits());

			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the supplier.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readsuppliers() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Account No</th><th>Unit Price</th><th>Start Date</th><th>End Date</th><th>No Of Units</th></tr>";
			String query = "select * from supplier";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AccNo = rs.getString("AccNo");
				String UnitPrice = rs.getString("UnitPrice");
				String StartDate = rs.getString("StartDate");
				String LastDate = rs.getString("LastDate");
				String NoOfUnits = rs.getString("NoOfUnits");

				// Add into the html table
				output += "<tr><td>" + AccNo + "</td>";
				output += "<td>" + UnitPrice + "</td>";
				output += "<td>" + StartDate + "</td>";
				output += "<td>" + LastDate + "</td>";
				output += "<td>" + NoOfUnits + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the suppliers.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatesupplier(Supplier supplier) {

		String query = "UPDATE supplier SET UnitPrice=?,StartDate=?,LastDate=?,NoOfUnits=? WHERE AccNo=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setFloat(1, supplier.getUnitPrice());
			preparedStatement.setString(2, supplier.getStartDate());
			preparedStatement.setString(3, supplier.getLastDate());
			preparedStatement.setFloat(4, supplier.getNoOfUnits());
			preparedStatement.setString(5, supplier.getAccNo());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the supplier.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletesupplier(Supplier supplier) {
		String query = "delete from supplier where AccNo=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, supplier.getAccNo());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the supplier.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
