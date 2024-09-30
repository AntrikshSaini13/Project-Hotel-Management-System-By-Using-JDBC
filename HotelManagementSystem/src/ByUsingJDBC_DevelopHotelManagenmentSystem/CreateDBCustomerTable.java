package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//8. Create Database Of Customer :

public class CreateDBCustomerTable {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USER_NAME = "HOTEL_RESERVATION_SYSTEM";
	private static final String PASSWARD = "123";
	
	public void createCoustomerTable() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWARD);
			Statement stmt = con.createStatement();
			stmt.execute(" Create table Coustomer_Hotel_Room_Reservation(Name varchar2(50)  Not Null, PhoneNumber number(15) Unique,Gmail varchar2(50) "
					+ "Unique, IDProof varchar2(20) Unique, CheckInDate timestamp Default systimestamp, CheckOutDate timestamp Default systimestamp ,"
					+ "TOTAL_BILL number(38), Room_Number number(30) REFERENCES hOTEL_ROOMS(ROOM_NUMBER))");
			System.out.println("Create table of Customer Successfully");
		} catch (ClassNotFoundException | SQLException e) { 
			System.out.println("1");
			System.err.println(e.getMessage());
			
		} catch(Exception e) {
			System.out.println("2");
			System.err.println(e.getMessage());
			System.out.println("2");
		}
		finally {
			
		}
	}	
}

//SQL> alter table Coustomer_Hotel_Room_Reservation add constraint  Coustomer_Hotel_Room_Reservation_pk primary key(CUSTOMER_ROOM_NUMBER);

//SQL> alter table hotel_rooms add constraint hotel_room_pk primary key(HOTEL_ROOM_NUMBER);

//Name                                      Null?    Type
//----------------------------------------- -------- ----------------------------
//SNO                                                NUMBER(10)
//NAME                                      NOT NULL VARCHAR2(50)
//PHONENUMBER                                        NUMBER(15)
//GMAIL                                              VARCHAR2(50)
//IDPROOF                                            VARCHAR2(20)
//CHECKINDATE                                        TIMESTAMP(6)
//CHECKOUTDATE                                       TIMESTAMP(6)
//TOTAL_BILL                                         NUMBER(38)
//CUSTOMER_ROOM_NUMBER                      NOT NULL NUMBER(30)

//Name                                      Null?    Type
//----------------------------------------- -------- ----------------------------
//HOTEL_ROOM_NUMBER                         NOT NULL NUMBER(30)
//ROOM_AVAILABLITY                                   VARCHAR2(30)
//ROOM_AC_AND_NON_AC                                 VARCHAR2(30)


