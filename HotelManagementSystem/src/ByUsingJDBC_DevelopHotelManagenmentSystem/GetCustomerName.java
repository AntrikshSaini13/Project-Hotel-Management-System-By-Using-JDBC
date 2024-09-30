package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class GetCustomerName {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
	
	private Long roomNum;

	public GetCustomerName(Long roomNum) {
		super();
		this.roomNum = roomNum;
	}
	
	public void getName() {
		try(OracleJDBCRowSet jrs = new OracleJDBCRowSet()) {
			jrs.setUrl(URL);
			jrs.setUsername(USER_NAME);
			jrs.setPassword(PASSWARD);
			jrs.setCommand("Select NAME  from Coustomer_Hotel_Room_Reservation where ROOM_NUMBER = ?");
			jrs.setLong(1, roomNum);
			jrs.execute();
			ResultSetMetaData rm = jrs.getMetaData();
			System.out.println("+========================================+");
			System.out.println("||\t"+"Available Customer in Hotel"+"\t||");
			System.out.println("+========================================+");
			System.out.print("||\t\t"+rm.getColumnName(1)+"\t\t\t||");
			System.out.println();
			System.out.println("+========================================+");
			while(jrs.next()) {
				System.out.print("||\t\t"+jrs.getString("name")+"\t\t||");
				System.out.println();
			}
			System.out.println("+========================================+");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
