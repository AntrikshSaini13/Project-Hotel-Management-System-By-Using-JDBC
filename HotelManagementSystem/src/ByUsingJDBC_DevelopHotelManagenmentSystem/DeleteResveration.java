package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;

//4. Delete Reservation of Customer

public class DeleteResveration {
	
//	Final Constant Variable
//	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
	
//	Instance Variable
	private long roomNum ;

//	Constructor
	public DeleteResveration(long roomNum) {
		super();
		this.roomNum = roomNum;	
	}
	
	public void deleteReservation() {
//		OracleJDBCRowSet jrs = new OracleJDBCRowSet();
		try(OracleJDBCRowSet jrs = new OracleJDBCRowSet()) {
			jrs.setUrl(URL);
			jrs.setUsername(USER_NAME);
			jrs.setPassword(PASSWARD);
			jrs.setCommand("delete from Coustomer_Hotel_Room_Reservation where room_number = ?");
			jrs.setLong(1, roomNum);
			jrs.execute();			
			System.out.println("Record Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}		
	}
}
