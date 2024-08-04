package hotel_management_system;

import java.sql.*;

public class CreateDBCustomerTable {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:MYSYSTEM";
	private static final String USER_NAME = "MyDB11AM";
	private static final String PASSWARD = "123";
	
	public void createCoustomerTable() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWARD);
			Statement stmt = con.createStatement();
			stmt.execute("Create table CoustomerReservation(SNo number(10), Name varchar2(50), PhoneNumber number(15), "
					+ "Gmail varchar2(50), IDProof varchar2(20), CheckInDate varchar2(25), CheckOutDate varchar2(25))");
			stmt.execute("Create table reservation(id number(20), name varchar2(20))");
			System.out.println("Create table of Customer Successfully");
		} catch (ClassNotFoundException | SQLException e) { 
			System.err.println(e.getMessage());
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
