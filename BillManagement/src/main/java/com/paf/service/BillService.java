package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class BillService {
	Connection con = null;

	public BillService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertbilling(Bill billing) {
		String output = "";
		try {
			String queryInsert = "insert into billing(`AccNo`,`Date`,`Remark`)" + " values(?, ?, ?)";

			try {
				PreparedStatement preparedStatement = con.prepareStatement(queryInsert);
				preparedStatement.setString(1, billing.getAccNo());
				preparedStatement.setString(2, billing.getDate());
				preparedStatement.setString(3, billing.getRemark());
				preparedStatement.execute();
				con.close();
				output = "Inserted successfully";

			} catch (SQLException e) {
				output = "Error while inserting the billing.";
				System.err.println(e.getMessage());
			}
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		return output;
	}

	public String readbillings() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Account No</th><th>Date</th><th>Unit</th><th>UnitPrice</th><th>Amount</th><th>Remark</th></tr>";
			String query = "select * from billing";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AccNo = rs.getString("AccNo");
				String Unit = rs.getString("Units");
				String UnitPrice = rs.getString("UnitPrice");
				String Amount = rs.getString("Amount");
				String Remark = rs.getString("Remark");
				String Date = rs.getString("Date");

				// Add into the html table
				output += "<tr><td>" + AccNo + "</td>";
				output += "<td>" + Date + "</td>";
				output += "<td>" + Unit + "</td>";
				output += "<td>" + UnitPrice + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + Remark + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the billings.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatebilling(Bill billing) {

		String query = "UPDATE billing SET Date=?,Remark=? WHERE AccNo=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, billing.getDate());
			preparedStatement.setString(2, billing.getRemark());
			preparedStatement.setString(3, billing.getAccNo());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the billing.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletebilling(Bill billing) {
		String query = "delete from billing where AccNo=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, billing.getAccNo());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the billing.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readPaymentInfo() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			output = "<table border=\"1\"><tr><th>Account Number</th><th>Units</th><th>Unit Price</th></tr>";
			String query = "select * from supplier";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String AccNo = rs.getString("AccNo");
				String Unit = rs.getString("UnitPrice");
				String UnitPrice = rs.getString("UnitPrice");

				System.out.println(AccNo + AccNo);

				output += "<tr><td>" + AccNo + "</td>";
				output += "<td>" + Unit + "</td>";
				output += "<td>" + UnitPrice + "</td>";
			}
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		System.out.println(output);
		return output;
	}

	public String asAccountNo(String AccNo) {

		String output = "";

		try {

			if (con == null) {

				return "Error while connecting to the database for reading.";
			}
			output = "<table border=\"1\"><tr><th>Account Number</th><th>Units</th><th>Unit Price</th><th>Amount</th></tr>";
			String query = "select * from supplier where AccNo = " + AccNo;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			String stringUnit = "";
			String stringUnitPrice = "";
			String stringAmount = "";
			while (rs.next()) {

				float Unit = rs.getFloat("NoOfUnits");
				stringUnit = Float.toString(Unit);
				float UnitPrice = rs.getFloat("UnitPrice");
				// float intUnitPrice = Float.parseFloat(UnitPrice);
				stringUnitPrice = Float.toString(UnitPrice);
				float Amount = Unit * UnitPrice;
				stringAmount = Float.toString(Amount);
				System.out.println(AccNo + AccNo);

				output += "<tr><td>" + AccNo + "</td>";
				output += "<td>" + Unit + "</td>";
				output += "<td>" + UnitPrice + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "</tr>";
			}

			String queryUpdate = "UPDATE billing SET Units=?, UnitPrice=?, Amount=? WHERE AccNo= " + AccNo;

			try {
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				PreparedStatement preparedStatement = con.prepareStatement(queryUpdate);
				preparedStatement.setString(1, stringUnit);
				preparedStatement.setString(2, stringUnitPrice);
				preparedStatement.setString(3, stringAmount);
				if (preparedStatement.executeUpdate() == 1) {
					output += "</table>";
				} else {
					output = "Error while updating the Billing.";
				}
				con.close();
			} catch (SQLException e) {
				output = "Error while updating the Billing.";
				System.err.println(e.getMessage());
			}
		} catch (Exception e) {
			output = "Error while reading the Billing.";
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		return output;
	}

}
