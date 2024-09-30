package ByUsingJDBC_DevelopHotelManagenmentSystem;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HomePage {	
//	Static Variable	
	private static String name;
	private static String phoneNum;
	private static String gmail;
	private static String id;	
	private static long roomNum;
	private static String data;
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("+========================================================+");
		System.out.println("||\t\t   Welcome To MyHotel  \t\t\t||");
		System.out.println("+========================================================+");
		System.out.println("||\t1. Holet Reservation :\t\t\t\t||");
		System.out.println("||\t2. Check In Day : \t\t\t\t||");
		System.out.println("||\t3. Check Out Day : \t\t\t\t||");
		System.out.println("||\t4. Delete reservation of Customer :\t\t||");
		System.out.println("||\t5. View the details of available Customer :\t||");
		System.out.println("||\t6. Check available Rooms : \t\t\t||");
		System.out.println("||\t7. Find name of Customer : \t\t\t||");
		System.out.println("||\t8. Find room number of Customer : \t\t||");
		System.out.println("||\t9. View the details of all Costumer :\t\t||");
		System.out.println("||\t10. How many Costumer in hotel now :\t\t||");
//		System.out.println("||\t11. Create Database Of Customer : \t\t||");
//		System.out.println("||\t12. Create Database Of Hotel : \t\t\t||");
//		System.out.println("||\t13. Create Database Of Employee :\t\t||");
		System.out.println("||\t11. Exit : \t\t\t\t\t||");
		System.out.print("+========================================================+");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:// 1. Hotel Reservation :
			
				  	try {	System.out.println("+========================================================+");
							System.out.println("||\tEnter yours the Details of Costumer\t\t||");
							System.out.println("+========================================================+");							
							
							System.out.print("Enter Costumer name : ");
							name = sc.nextLine();
							name = sc.nextLine();
							
							System.out.print("Enter Costumer phone number : ");
							phoneNum = sc.nextLine();
							
							System.out.print("Enter Costumer gamil : ");
							gmail = sc.nextLine();
							
							System.out.print("Enter Costumer ID proof1 : ");				
							id = sc.nextLine();
							
							System.out.print("Enter the avialable room number in hotel : ");
							roomNum = sc.nextLong();
							System.out.println("==========================================================");
							
	//						object of CustumerReservation
							new CustumerReservation(name,phoneNum,gmail,id,roomNum).InsertData();;		
							
							System.out.println("Go back main menu enter yes/no");
							 data = sc.nextLine();
							 data = sc.nextLine();
							 if(data.equalsIgnoreCase("yes")) {
								 main(null);
							 }
							 else if(data.equalsIgnoreCase("no")) {
								 System.out.println("Thanku for Vesiting");
							 }
							 else {
								 System.out.println("Wrong Input Please enter right input");
							 }
							 break;
							
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
						System.out.println("Again Try");
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Again Try");
					}
					break;
				
		case 2 : 	 // 2. CheckIn Day
				System.out.println("+========================================================+");
				 System.out.println("||\tEnter the Customer Room Number\t\t\t||");
				 System.out.println("+========================================================+");
				 roomNum = sc.nextInt();
				 System.out.println("==========================================================");
					 new AllCustomerDetails().getCheckInDate(roomNum);
					 System.out.println("Go back main menu enter yes/no");
					 data = sc.nextLine();
					 data = sc.nextLine();
					 if(data.equalsIgnoreCase("yes")) {
						 main(null);
					 }
					 else if(data.equalsIgnoreCase("no")) {
						 System.out.println("Thanku for Vesiting");
					 }
					 else {
						 System.out.println("Wrong Input Please enter right input");
					 }
					 break;
		case 3 :     //3. CheckOut Day :				 
					 System.out.println("+========================================================+");
					 System.out.println("||\tEnter the Customer Room Number\t\t\t||");
					 System.out.println("+========================================================+");
					 roomNum = sc.nextInt();
					 System.out.println("==========================================================");
			   		 new CheckOutDate(roomNum).insertCheckOutDate();
					 System.out.println("Go back main menu enter yes/no");
					 data = sc.nextLine();
					 data = sc.nextLine();
					 if(data.equalsIgnoreCase("yes")) {
						 main(null);
					 }
					 else if(data.equalsIgnoreCase("no")) {
						 System.out.println("Thanku for Vesiting");
					 }
					 else {
						 System.out.println("Wrong Input Please enter right input");
					 }
				     break;
			
		case 4 :    //4. Delete Reservation
			
					 System.out.println("+========================================================+");
					 System.out.println("||\tEnter the Customer Room Number\t\t\t||");
					 System.out.println("+========================================================+");
					 roomNum = sc.nextInt();
					 System.out.println("==========================================================");
			//		 Object of Delete Class
					 new DeleteResveration(roomNum).deleteReservation();
					 
					 System.out.println("Go back main menu enter yes/no");
					 data = sc.nextLine();
					 data = sc.nextLine();
					 if(data.equalsIgnoreCase("yes")) {
						 main(null);
					 }
					 else if(data.equalsIgnoreCase("no")) {
						 System.out.println("Thanku for Vesiting");
					 }
					 else {
						 System.out.println("Wrong Input Please enter right input");
					 }
				     break;
		
		case 5 :     // 5. View the details of available Customer
//					System.out.println("+========================================================+");
//				    System.out.println("||\tEnter the Customer Room Number\t\t\t||");
//					System.out.println("+========================================================+");
//					roomNum = sc.nextInt();
//					System.out.println("==========================================================");
					new AllCustomerDetails().getCurrentCustomerData();
					  System.out.println("Go back main menu enter yes/no");
					  data = sc.nextLine();
					  data = sc.nextLine();		
					 
					  if(data.equalsIgnoreCase("yes")) {
						  main(null);
					  }					  
					  else {
						  System.out.println("Thanku for Vesiting");
					  }
					  break;
		
		case 6 :// 6. Check available Rooms :
				 new AvailableRooms().CheckAvailableRooms();
				 System.out.println("Go back main menu enter yes/no");
				 data = sc.nextLine();
				 data = sc.nextLine();
				 if(data.equalsIgnoreCase("yes"))
					 main(null);
				 else
					 System.out.println("Thanku for Vesiting");
				 break;
		
		case 7 : //7. Name Customer;
				 System.out.println("+========================================================+");
				 System.out.println("||\tEnter the Customer Room Number\t\t\t||");
				 System.out.println("+========================================================+");
				 roomNum = sc.nextInt();
				 System.out.println("==========================================================");
				 new GetCustomerName(roomNum).getName();
				 System.out.println("Go back main menu enter yes/no");
				 data = sc.nextLine();
				 data = sc.nextLine();
				 if(data.equalsIgnoreCase("yes"))
					 main(null);
				 else
					 System.out.println("Thanku for Vesiting");
		  		 break;
		
		case 8 : //8. Find room Number of Customer
				 System.out.println("+========================================================+");
				 System.out.println("||\tEnter the Customer Name : \t\t\t||");
				 System.out.println("+========================================================+");
				 name = sc.nextLine();
				 name = sc.nextLine();
				 System.out.println("==========================================================");
			     new AllCustomerDetails().getNameOfCustomer(name);
				 
				 System.out.println("Go back main menu enter yes/no");
				 data = sc.nextLine();
				 data = sc.nextLine();
				 if(data.equalsIgnoreCase("yes"))
					 main(null);
				 else
					 System.out.println("Thanku for Vesiting");
				 break;
				
		case 9 ://  5. View the details of all Costumer
				new AllCustomerDetails().getDataAll();
	//			For threading
	//			new Thread(){
	//				  @Override
	//				  public void run()		  {
	//					  allDetails.printTable();	
	//				  }					
	//				}.start();
				
				 
				 System.out.println("Go back main menu enter yes/no");
				 data = sc.nextLine();
				 data = sc.nextLine();
				 if(data.equalsIgnoreCase("yes"))
					 main(null);
				 else
					 System.out.println("Thanku for Vesiting");
				 break;	
				 
		case 10 : System.out.println("");	
				 System.out.println("Go back main menu enter yes/no");
				 data = sc.nextLine();
				 data = sc.nextLine();
				 if(data.equalsIgnoreCase("yes"))
					 main(null);
				 else
					 System.out.println("Thanku for Vesiting");
				 break;		 
		
		case 11 : System.out.println("Thanku for Commig");	
   				  break;		
		}
		sc.close();
	}
}
