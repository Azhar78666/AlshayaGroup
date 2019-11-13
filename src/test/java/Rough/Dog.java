package Rough;

public class Dog implements pet {
	
	   public void test()
	   {
		     System.out.println("Interface Method Implemented");
		}
	   
		   public static void main(String args[])
		   {
		     pet p = new Dog();
		     p.test();
		  }
		

}
