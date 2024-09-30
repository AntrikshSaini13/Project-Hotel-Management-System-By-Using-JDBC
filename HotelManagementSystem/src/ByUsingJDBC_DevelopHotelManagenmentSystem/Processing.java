package ByUsingJDBC_DevelopHotelManagenmentSystem;

//Program on Method Level Synchronization :
//-----------------------------------------

class Table
{
	public synchronized void printTable(int num) 
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println(num+" X "+i+" = "+(num*i));
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println("..............");
	}
}


public class Processing {

	public static void main(String[] args) 
	{
		
		Table obj = new Table();  //lock is created here
		
		
		new Thread()
		{
		  @Override
		  public void run()
		  {
			obj.printTable(5);	
		  }		
			
		}.start();
		
		
		new Thread()
		{
		  @Override
		  public void run()
		  {
			obj.printTable(10);	
		  }		
			
		}.start();

	}

}

