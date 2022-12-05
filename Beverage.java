public abstract class Beverage {
	private String bev;
	private Type t;
	private Size s;
	
	final double BASEPRICE = 2.00;
	
	
	public Beverage(String bevName, Type type, Size size) {
		this.bev = bevName;
		this.t = type;
		this.s = size;
	}
	
	abstract double calcPrice(); 
	
	public double addSizePrice() { 
		switch(s) {
		case SMALL:
			return 0;
		case MEDIUM:
			return 1.0;
		case LARGE:
			return 2.0;
		default:
			return 0;			
		}
	}

	public boolean equals(Beverage anotherBev) { 
		return(anotherBev.bev == bev && anotherBev.s == s && anotherBev.t == t);
	}
	
	public double getBasePrice() { 
		return BASEPRICE;
	}
	
	public String getBevName() { 
		return bev;
	}
	
	public Size getSize() { 
		return s;
	}
	
	public Type getType() { 
		return t;
	}
	
	public String toString() { 
		return String.format("%s, %s, %s", bev, s, t);
	}
	
}