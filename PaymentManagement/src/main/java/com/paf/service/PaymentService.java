package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class PaymentService {
	Connection con = null;

	public PaymentService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertpayment(Payment payment) {
		String query = " insert into payment(`AccNo`,`PaymentDate`,`Amount`,`PaymentType`)" + " values (?,?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, payment.getAccNo());
			preparedStatement.setString(2, payment.getPaymentDate());
			preparedStatement.setFloat(3, payment.getAmount());
			preparedStatement.setString(4, payment.getPaymentType());

			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the payment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readpayments() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Account No</th><th>Payment Date</th><th>Amount</th><th>Payment Type</th></tr>";
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AccNo = rs.getString("AccNo");
				String PaymentDate = rs.getString("PaymentDate");
				String Amount = rs.getString("Amount");
				String PaymentType = rs.getString("PaymentType");

				// Add into the html table
				output += "<tr><td>" + AccNo + "</td>";
				output += "<td>" + PaymentDate + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + PaymentType + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the payments.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatepayment(Payment payment) {

		String query = "UPDATE payment SET PaymentDate=?,Amount=?,PaymentType=? WHERE AccNo=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, payment.getPaymentDate());
			preparedStatement.setFloat(2, payment.getAmount());
			preparedStatement.setString(3, payment.getPaymentType());
			preparedStatement.setString(4, payment.getAccNo());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletepayment(Payment payment) {
		String query = "delete from payment where AccNo=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, payment.getAccNo());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";


		} catch (Exception e) {
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
