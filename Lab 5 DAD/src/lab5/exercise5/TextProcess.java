package lab5.exercise5;

import java.io.Serializable;

public class TextProcess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String processText;
	int length;
	public TextProcess(String text) {
		this.processText = text;
	}
	
	public int countText(String text) {
		return text.length();
	}
	
	public void setLength() {
		this.length = countText(processText);
	}
	
	
	public int getTextlength() {
		return length;
		
	}
}
