package exercise1;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Demo {
	 private static DecimalFormat df2 = new DecimalFormat("#.##");
	 
	public static void main(String[] args) {
	double earthweight = 71.8;
	MarsWeight demo1 = new MarsWeight();
	
	demo1.setEarthWeight(earthweight);
	demo1.setMarsWeight(earthweight);
	
	  df2.setRoundingMode(RoundingMode.DOWN); // round down the value
	  
		System.out.println("Your weight on Earth : " + df2.format(demo1.getEarthWeight()) + "kg\n") ;
		System.out.println("Your weight on Mars : " + df2.format(demo1.getMarsWeight()) + "kg\n") ;
		// TODO Auto-generated method stub

	}
}
