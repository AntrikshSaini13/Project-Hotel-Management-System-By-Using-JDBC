package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.*;
import java.sql.Timestamp; 
import java.util.Date; 

//1. Holet Reservation :

public class CustumerReservation {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";	
	private String name;
	private String phoneNum ;
	private String gamil ;
	private String id ;
	// getting the system date 
    Date date = new Date();     
    // getting the time stamp object 
    private Timestamp checkInDate = new Timestamp(date.getTime()); 
    private Timestamp checkOutDate = null;    
    private float totalBill = 0; 
    private long roomNum ;
    private String roomAvailability = "No";
    private String bookingConfromOrNot = "Conform";
    
    public CustumerReservation() {
    	super();
    }
	
	public CustumerReservation(String name, String phoneNum, String gamil, String id, long roomNum) {
		super();
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.gamil = gamil;
		this.id = id;
		this.roomNum = roomNum;
	}
	
	public void InsertData() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWARD);
			PreparedStatement pstmt = con.prepareStatement("insert into Coustomer_Hotel_Room_Reservation values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, gamil);
			pstmt.setString(4, id);
			pstmt.setTimestamp(5, checkInDate);
			pstmt.setTimestamp(6, checkOutDate);
			pstmt.setFloat(7, totalBill);
			pstmt.setLong(8, roomNum);
			pstmt.setString(9, bookingConfromOrNot);
			pstmt.executeUpdate();
			
//			call update method for reserve room
			new UpdateHotelRooms(roomNum, roomAvailability).UpdateReservation();	
			System.out.println("Reservation Successfully Thank You");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());;
			System.out.println("Try Again");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println("Try Again");
		}
	}	
}
