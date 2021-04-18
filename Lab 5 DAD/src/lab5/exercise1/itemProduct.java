package lab5.exercise1;

import java.io.Serializable;

public class itemProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int itemProductid;
	private String name;
	private float price;
	
	public int getItemProductid()  {
		return itemProductid;
	}
	public void setItemProductid(int itemProductid) {
		this.itemProductid = itemProductid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
