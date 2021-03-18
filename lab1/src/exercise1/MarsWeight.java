package exercise1;

public class MarsWeight {
	private double earthWeight, marsWeight;
	

	public double getEarthWeight() {
		return earthWeight;
	}

	public void setEarthWeight(double earthWeight) {
		this.earthWeight = earthWeight;
	}



	public double getMarsWeight() {
		return marsWeight;
	}



	public void setMarsWeight(double earthsWeight) {
		this.marsWeight = earthsWeight * 0.375;
	}

}
