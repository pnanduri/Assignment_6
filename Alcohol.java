
public class Alcohol extends Beverage {
	private boolean bool = false; 
	
	public Alcohol(String bevName, Size size, boolean isWeekend) { 
		super(bevName,Type.ALCOHOL, size);
		this.bool = isWeekend;
	}
	
	public boolean equals(Alcohol anotherBev) { 
		return (super.equals(anotherBev) && anotherBev.bool == bool);
	}
	
	public double calcPrice() { 
		
		double totalPrice = getBasePrice() + addSizePrice();
		
		if(bool) {
			totalPrice += 0.60;
		}
		return totalPrice;
	}
	
	
	public String toString() { 
		return String.format("%s, %s, %s, $%.2f", getBevName(), getSize(), bool, calcPrice());
	}
}