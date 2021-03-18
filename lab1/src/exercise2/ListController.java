package exercise2;
import exercise1.MarsWeight;
import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class ListController {
	 private static DecimalFormat df2 = new DecimalFormat("#.##");
	 
	 
public static void main(String[] args) {
		
 MarsWeight human1 = new MarsWeight();
 MarsWeight human2 = new MarsWeight();
 MarsWeight human3 = new MarsWeight();
 
 human1.setEarthWeight(92.5);
 human2.setEarthWeight(92.5);
 human3.setEarthWeight(92.5);
 human1.setMarsWeight(human1.getEarthWeight());
 human2.setMarsWeight(human1.getEarthWeight());
 human3.setMarsWeight(human1.getEarthWeight());
 
 ArrayList<MarsWeight> List = new ArrayList<MarsWeight>();
 List.add(human1);
 List.add(human2);
 List.add(human3);
 
 System.out.println("Earth\tMars");
 df2.setRoundingMode(RoundingMode.DOWN); // round down the value
 for(MarsWeight i : List)
 {
	 System.out.println(df2.format(i.getEarthWeight()) + "\t" + df2.format(i.getMarsWeight()));
 }
}
}
