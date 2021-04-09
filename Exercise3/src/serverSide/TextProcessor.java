package serverSide;


/**
 * This class returns length of text
 * 
 *
 */
public class TextProcessor {

	
	/**
	 * This method return lengths of text
	 * 
	 * @return current date
	 */
	public static int processText(String text) {
    
        int count = 0;    
            
        //Counts each character except space    
        for(int i = 0; i < text.length(); i++) {    
            if(text.charAt(i) != ' ')    
                count++;    
        }    
        return count;    
        //Displays the total number of characters present in the given string    
        //System.out.println("Total number of characters in a string: " + count); 
	}
	
}
