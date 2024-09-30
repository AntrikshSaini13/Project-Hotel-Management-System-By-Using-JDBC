package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class UpdateCustomertable {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
//	Instance Variable
	private long roomNum = 0;
	private String idProof ;
	
	public UpdateCustomertable(String idProof) {
		super();
		this.idProof = idProof;
	}

	public void update() {
		try(OracleJDBCRowSet ojrs = new OracleJDBCRowSet()) {			
			ojrs.setUrl(URL);
			ojrs.setUsername(USER_NAME);
			ojrs.setPassword(PASSWARD);
			ojrs.setCommand("Update Coustomer_Hotel_Room_Reservation set ROOM_NUMBER = ? where idProof = ?");
			ojrs.setLong(1, roomNum);
			ojrs.setString(2, idProof);
			ojrs.execute();	
		} 
    	catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
