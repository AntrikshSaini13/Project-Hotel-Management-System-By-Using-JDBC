package ByUsingJDBC_DevelopHotelManagenmentSystem;


import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import oracle.jdbc.rowset.OracleJDBCRowSet;

//3. CheckOut Day

public class CheckOutDate {
//	Final Constant Variable
//	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
	
	// getting the system date 
	Date date = new Date();     
	// getting the time stamp object 
	private Timestamp checkOutDate = new Timestamp(date.getTime());
	private Timestamp checkInDate = new Timestamp(date.getTime());
	
	private long roomNum;
	private double totalBill;
	private String roomAvailability = "Yes";
	private String bookingConfromOrNot = "Check Out";
	
	public CheckOutDate(long roomNum) {
		super();
		this.roomNum = roomNum;
	} 
//	insert date in table
    public void insertCheckOutDate() {
    	try(OracleJDBCRowSet ojrs = new OracleJDBCRowSet()) {			
			ojrs.setUrl(URL);
			ojrs.setUsername(USER_NAME);
			ojrs.setPassword(PASSWARD);
			ojrs.setCommand("Update Coustomer_Hotel_Room_Reservation set CheckOutDate = ? where room_number = ?");
			ojrs.setTimestamp(1, checkOutDate);
			ojrs.setLong(2, roomNum);
			ojrs.execute();			
			// method call
			getCheckInDateAndCheckOutDate();						
		} 
    	catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}    	
    }
    
//  get the checkIn and checkOut date form the table
    public void getCheckInDateAndCheckOutDate() {
    	try(OracleJDBCRowSet ojrs = new OracleJDBCRowSet()) {			
			ojrs.setUrl(URL);
			ojrs.setUsername(USER_NAME);
			ojrs.setPassword(PASSWARD);
			ojrs.setCommand("Select CHECKOUTDATE, CHECKINDATE from Coustomer_Hotel_Room_Reservation  where room_number = ?");
			ojrs.setLong(1, roomNum);
			ojrs.execute();
			while(ojrs.next()) {
				this.checkOutDate = ojrs.getTimestamp(1);
				this.checkInDate = ojrs.getTimestamp(2);
				
//				calculate the time difference checkIn and checkOut 
				this.totalBill = new BillGenerate(checkOutDate,checkInDate).calculateDifference();
//				method call generate the bill
				insertTotalBillInTable();
				getBill();
//				this for update Hotel Rooms table name roomAvailability
				new UpdateHotelRooms(roomNum, roomAvailability).UpdateReservation();
			}			
		} 
    	catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}     	
    }  
    public void insertTotalBillInTable() {
    	try(OracleJDBCRowSet ojrs = new OracleJDBCRowSet()) {			
			ojrs.setUrl(URL);
			ojrs.setUsername(USER_NAME);
			ojrs.setPassword(PASSWARD);
			ojrs.setCommand("Update Coustomer_Hotel_Room_Reservation set total_Bill = ?, Booking = ? where room_number = ?");
			ojrs.setDouble(1, totalBill);
			ojrs.setString(2, bookingConfromOrNot);
			ojrs.setLong(3, roomNum);
			ojrs.execute();	
		} 
    	catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}    	
    }
    public void getBill() {
    	try(OracleJDBCRowSet ojrs = new OracleJDBCRowSet()) {			
			ojrs.setUrl(URL);
			ojrs.setUsername(USER_NAME);
			ojrs.setPassword(PASSWARD);
			ojrs.setCommand("select * from Coustomer_Hotel_Room_Reservation where room_number = ?");
			ojrs.setLong(1, roomNum);
			ojrs.execute();	
			
			System.out.println("+========================================================================================================================================================================================+");
			System.out.println("||\t\t\t\t\t\t\t\t\t\t ***Costumer Details Here*** \t\t\t\t\t\t\t\t\t\t||");
			System.out.println("+========================================================================================================================================================================================+");
			ResultSetMetaData rm = ojrs.getMetaData();
			
			System.out.print("||\t"+rm.getColumnName(1)+"\t\t\t");
			System.out.print(rm.getColumnName(2)+"\t\t\t");
			System.out.print(rm.getColumnName(3)+"\t\t\t");
			System.out.print(rm.getColumnName(4)+"\t\t\t");
//			System.out.print(rm.getColumnName(5)+"\t\t");
			System.out.print(rm.getColumnName(6)+"\t\t");
			System.out.print(rm.getColumnName(7)+"\t");
			System.out.print(rm.getColumnName(8)+"\t");
			System.out.print(rm.getColumnName(9)+"\t\t||");
			
			System.out.println();
			System.out.println("+========================================================================================================================================================================================+");

			while(ojrs.next()) {
				System.out.print("||\t"+ojrs.getString("NAME")+"\t\t");
				System.out.print(ojrs.getString("PHONENUMBER")+"\t\t");
				System.out.print(ojrs.getString("GMAIL")+"\t\t");
				System.out.print(ojrs.getString("IDPROOF")+"\t\t");
//				System.out.print(ojrs.getDate("CHECKINDATE")+"\t\t");
				System.out.print(ojrs.getDate("CHECKOUTDATE")+"\t\t");
				System.out.print(ojrs.getFloat("TOTAL_BILL")+"\t\t");
				System.out.print(ojrs.getInt("ROOM_NUMBER")+"\t\t");
				System.out.print(ojrs.getString("BOOKING")+"\t||");
				System.out.println();
				System.out.println("+========================================================================================================================================================================================+");
			}
//			update the roomNum of Customer table
//			new UpdateCustomertable(idProof).update();
		} 
    	catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}    	
    }
}
