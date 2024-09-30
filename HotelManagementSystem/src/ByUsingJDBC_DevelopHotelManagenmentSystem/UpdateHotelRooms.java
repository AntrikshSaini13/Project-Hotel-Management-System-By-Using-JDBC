package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class UpdateHotelRooms {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
	
	
//	Instance Variable
	private long roomNum;
	private String roomAvailability;
//	private 
	public UpdateHotelRooms(long roomNum, String roomAvailability) {
		super();
		this.roomNum = roomNum;
		this.roomAvailability = roomAvailability;
	}

	public void UpdateReservation() {
//		OracleJDBCRowSet jrs = new OracleJDBCRowSet();
		try(OracleJDBCRowSet jrs = new OracleJDBCRowSet()) {
			jrs.setUrl(URL);
			jrs.setUsername(USER_NAME);
			jrs.setPassword(PASSWARD);
			jrs.setCommand("update hotel_rooms set room_availability  = ? where room_number = ?"); //ROOM_AVAILABILITY
			jrs.setString(1, roomAvailability);
			jrs.setLong(2, roomNum);
			jrs.execute();	
//			System.out.println("Record Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}		
	}
}

