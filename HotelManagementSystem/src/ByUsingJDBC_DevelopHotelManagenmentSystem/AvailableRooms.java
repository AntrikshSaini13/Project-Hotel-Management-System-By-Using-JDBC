package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class AvailableRooms {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
	
//	Instance Variable
	private String roomAvailability = "Yes";
	
//	public AvailableRooms(long roomNum, String roomAvailability) {
//		super();
//		this.roomNum = roomNum;
//		this.roomAvailability = "Yes";
//	}

	public void CheckAvailableRooms() {
//		OracleJDBCRowSet jrs = new OracleJDBCRowSet();
		try(OracleJDBCRowSet jrs = new OracleJDBCRowSet()) {
			jrs.setUrl(URL);
			jrs.setUsername(USER_NAME);
			jrs.setPassword(PASSWARD);
			jrs.setCommand("Select ROOM_NUMBER from Hotel_rooms where ROOM_AVAILABILITY = ?"); 
			jrs.setString(1, roomAvailability);		
			jrs.execute();
			ResultSetMetaData rm = jrs.getMetaData();
			System.out.println("+========================================+");
			System.out.println("||\t"+"Available Rooms in Hotels"+"\t||");
			System.out.println("+========================================+");
			System.out.print("||\t     "+rm.getColumnName(1)+"\t\t||");
			System.out.println();
			System.out.println("+========================================+");
			while(jrs.next()) {
				System.out.print("||\t\t"+jrs.getString("ROOM_NUMBER")+"\t\t\t||");
				System.out.println();
			}
			System.out.println("+========================================+");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}		
	}
}
