package Rough;

public class TableDisplay {
	
	public static void main(String args[])
	{
		
		for(int i=2; i<=10; i++)
		{
			System.out.println("Starting the Table Count of " +i);
			for(int j=1; j<=10; j++)
			{
				int m = i*j;
				System.out.println(i+" * "+j+ " = "+m);
				
			}
			System.out.println("Finished the Table Count of "+i);
		}
		
		swap();
		getDataSimple();
	}

	
	public static void swap()
	{
		System.out.println("Before swapping");  
		  int x = 10;  
		  int y = 20;  
		  System.out.println("value of x:" + x);  
		  System.out.println("value of y:" + y);  
		  System.out.println("After swapping");  
		  x = x + y;  
		  y = x - y;  
		  x = x - y;  
		  System.out.println("value of x:" + x);  
		  System.out.println("value of y:" + y);  
		
		
	}
	
public static Object[][] getDataSimple() {
		

		//String sheetName = "TestData";
		
		int rowNum = 2;
		int colNum = 2;
	
		Object[][] data= new Object[rowNum-1][colNum];
		
	
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=1; cols<colNum; cols++) {


				System.out.println("Print");
			}
			
		}
		
		
		
		return data;
		
	}
			

}
