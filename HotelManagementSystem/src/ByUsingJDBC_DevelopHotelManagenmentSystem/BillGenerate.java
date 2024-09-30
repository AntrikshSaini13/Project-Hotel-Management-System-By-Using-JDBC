package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.Timestamp;
import java.util.Date;

public class BillGenerate {
	// getting the system date 
	Date date = new Date();     
	// getting the time stamp object 
	private Timestamp checkOutDate ;
	private Timestamp checkInDate ;
	
	private String valueHours = "hours";
	private long stayHours;
	
	public BillGenerate(Timestamp checkOutDate, Timestamp checkInDate) {
		super();
		this.checkOutDate = checkOutDate;
		this.checkInDate = checkInDate;
	}
	public double calculateDifference() {
		  
        long milliseconds = checkOutDate.getTime() - checkInDate.getTime();
//        System.out.println(milliseconds);
//        if (valueHours.equals("second"))
//            return milliseconds / 1000;
//        if (valueHours.equals("minute"))
//            return milliseconds / 1000 / 60;
        if (valueHours.equals("hours")) {
            this.stayHours =  milliseconds / 1000 / 3600;            
         	return generateBill(stayHours);
        }
        else
            return new Double(999999999);
    }
	public double generateBill(long stayHours) {
		if(stayHours <=12) 
			return 1000;
		else
		return (stayHours*83.40);		
	}
}