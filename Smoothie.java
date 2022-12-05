
public class Smoothie extends Beverage {
	private int num;
	private boolean add;
	
	Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){
		super(bevName, Type.SMOOTHIE, size);
		this.num = numOfFruits;
		this.add = addProtein;
	}
	
	public int getNumOfFruits() { 
		return num;
	}
	
	public boolean equals(Smoothie anotherBev) { 
		return (super.equals(anotherBev) && anotherBev.add == add && anotherBev.num == num);
	}
	
	public boolean getAddProtein() { 
		return add;
	}
	
	public String toString() { 
		return String.format("%s, %s, %s, %s, $%.2f", getBevName(), getSize(), add, num, calcPrice());
	}
	
	
	public double calcPrice() {
		double totalPrice = getBasePrice() + addSizePrice();
		if(add) {
			totalPrice += 1.50;
		}
		if(num > 0) {
			totalPrice += num * 0.50;
		}
		return totalPrice;
	}
	
	
	
}