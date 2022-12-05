public class Coffee extends Beverage {
	private boolean Shot;
	private boolean Syrup;
	
	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup){ 
		super(bevName, Type.COFFEE, size);
		this.Shot = extraShot;
		this.Syrup = extraSyrup;
	}
	
	public boolean getExtraShot() { 
		return Shot;
	}
	
	public boolean equals(Coffee anotherBev) { 
		return (super.equals(anotherBev) && anotherBev.Shot == Shot && anotherBev.Syrup == Syrup);
	}
	
	public boolean getExtraSyrup() { 
		return Syrup;
	}
	
	public double calcPrice() {
		double totalPrice = getBasePrice() + addSizePrice();
		
		if(Shot) {
			totalPrice += 0.50;
		}
		if(Syrup) {
			totalPrice += 0.50;
		}
		return totalPrice;
	}
	
	public String toString() { 
		return String.format("%s, %s, %s, %s, $%.2f", getBevName(), getSize(), Shot, Syrup, calcPrice());
	}
	
	
	
}