package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.*;

//5. View the details of All Costumer

public class AllCustomerDetails {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
	private String bookingConfromOrNot = "Conform";
	
//	public synchronized void printTable() 
//	{
//		System.out.print("processing");
//		for(int i=1; i<=10; i++)
//		{
//			System.out.print(".");
//			try 
//			{
//				Thread.sleep(1500);
//			} 
//			catch (InterruptedException e) 
//			{
//				e.printStackTrace();
//			}
//		}
//		System.out.println();
//	}
	
	public void getDataAll() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWARD);
			PreparedStatement pstmt = con.prepareStatement("Select * from  Coustomer_Hotel_Room_Reservation");
			ResultSet rs = pstmt.executeQuery();			
			ResultSetMetaData rm = rs.getMetaData();					
			
			System.out.println("+================================================================================================================================================================================================================+");
			System.out.println("||\t\t\t\t\t\t\t\t\t\t\t ***All Costumer Details Here*** \t\t\t\t\t\t\t\t\t\t\t||");
			System.out.println("+================================================================================================================================================================================================================+");
			
			System.out.print("||\t"+rm.getColumnName(1)+"\t\t\t");
			System.out.print(rm.getColumnName(2)+"\t\t\t");
			System.out.print(rm.getColumnName(3)+"\t\t\t");
			System.out.print(rm.getColumnName(4)+"\t\t\t");
			System.out.print(rm.getColumnName(5)+"\t\t");
			System.out.print(rm.getColumnName(6)+"\t\t");
			System.out.print(rm.getColumnName(7)+"\t");
			System.out.print(rm.getColumnName(8)+"\t");
			System.out.print(rm.getColumnName(9)+"\t\t||");
			
			System.out.println();
			System.out.println("+================================================================================================================================================================================================================+");

			while(rs.next()) {	
				
				System.out.print("||\t"+rs.getString("NAME")+"\t\t");
				System.out.print(rs.getString("PHONENUMBER")+"\t\t");
				System.out.print(rs.getString("GMAIL")+"\t\t");
				System.out.print(rs.getString("IDPROOF")+"\t\t");
				System.out.print(rs.getDate("CHECKINDATE")+"\t\t");
				System.out.print(rs.getDate("CHECKOUTDATE")+"\t\t");
				System.out.print(rs.getFloat("TOTAL_BILL")+"\t\t");
				System.out.print(rs.getInt("Room_Number")+"\t\t");
				System.out.print(rs.getString("BOOKING")+"\t||");
				System.out.println();
			}
//			System.out.println();
			System.out.println("+================================================================================================================================================================================================================+");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	public void getCurrentCustomerData() {
//		System.out.println("5");
		try {
//			System.out.println(roomNum);
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWARD);
			PreparedStatement pstmt = con.prepareStatement("Select * from  Coustomer_Hotel_Room_Reservation where BOOKING = ?");
			pstmt.setString(1, bookingConfromOrNot);
			ResultSet rs = pstmt.executeQuery();			
			ResultSetMetaData rm = rs.getMetaData();					
			
			System.out.println("+========================================================================================================================================================================+");
			System.out.println("||\t\t\t\t\t\t\t\t\t ***All Costumer Details Here*** \t\t\t\t\t\t\t\t||");
			System.out.println("+========================================================================================================================================================================+");
			
			System.out.print("||\t"+rm.getColumnName(1)+"\t\t\t");
			System.out.print(rm.getColumnName(2)+"\t\t\t");
			System.out.print(rm.getColumnName(3)+"\t\t\t");
			System.out.print(rm.getColumnName(4)+"\t\t\t");
			System.out.print(rm.getColumnName(5)+"\t\t");
//			System.out.print(rm.getColumnName(6)+"\t\t");
//			System.out.print(rm.getColumnName(7)+"\t");
			System.out.print(rm.getColumnName(8)+"\t");
			System.out.print(rm.getColumnName(9)+"\t\t||");
			
			System.out.println();
			System.out.println("+========================================================================================================================================================================+");

			while(rs.next()) {	
				
				System.out.print("||\t"+rs.getString("NAME")+"\t\t");
				System.out.print(rs.getString("PHONENUMBER")+"\t\t");
				System.out.print(rs.getString("GMAIL")+"\t\t");
				System.out.print(rs.getString("IDPROOF")+"\t\t");
				System.out.print(rs.getDate("CHECKINDATE")+"\t\t");
//				System.out.print(rs.getDate("CHECKOUTDATE")+"\t\t");
//				System.out.print(rs.getFloat("TOTAL_BILL")+"\t\t");
				System.out.print(rs.getInt("Room_Number")+"\t\t");
				System.out.print(rs.getString("BOOKING")+"\t\t||");
				System.out.println();
			}
//			System.out.println();
			System.out.println("+========================================================================================================================================================================+");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	
	public void getNameOfCustomer(String name) throws SQLException {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWARD);
			PreparedStatement pstmt = conn.prepareStatement("Select ROOM_NUMBER from Coustomer_Hotel_Room_Reservation where NAME = ? ");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			System.out.println("+========================================+");
			System.out.println("||\t     "+rm.getColumnName(1)+"\t\t||");
			System.out.println("+========================================+");
			while(rs.next()) {
				System.out.println("||\t\t"+rs.getLong("ROOM_NUMBER")+"\t\t\t||");
			}
			System.out.println("+========================================+");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	public void getCheckInDate(long roomNum) throws SQLException {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER_NAME, PASSWARD);
			PreparedStatement pstmt = conn.prepareStatement("select NAME , CHECKINDATE from Coustomer_Hotel_Room_Reservation where ROOM_NUMBER = ?");
			pstmt.setLong(1, roomNum);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			System.out.println("+=========================================================================+");
			System.out.print("||\t"+rm.getColumnName(1)+"\t\t\t||");
			System.out.print("\t\t"+rm.getColumnName(2)+"\t\t||\n");
			System.out.println("+=========================================================================+");
			while(rs.next()) {
				System.out.print("||\t"+rs.getString("NAME")+"\t\t");
				System.out.println("||\t\t"+rs.getDate("CheckInDate")+"\t\t||");
			}
			System.out.println("+==========================================================================+");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}