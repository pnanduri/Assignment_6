import java.util.ArrayList;
public class Order implements OrderInterface, Comparable<Order> {
	private int T;
	private Day D;
	private Customer c;
	
	ArrayList<Beverage> bev = new ArrayList<Beverage>();
	
	private int orderNo = 10000;
	
	public Order(int orderTime, Day orderDay, Customer cust){
		this.T = orderTime;
		this.D = orderDay;
		this.c = cust;
	}
	
	public Order(Order copy) {
		T = copy.T;
		D = copy.D;
		c = new Customer(copy.c);
		
		bev.addAll(copy.bev);
		
		orderNo = copy.orderNo;
	}
	
	public int getOrderNo() { 
		return orderNo;
	}
	
	public boolean isWeekend() {
		return (D == Day.SATURDAY || D == Day.SUNDAY);
	}
	
	public int findNumOfBeveType(Type type) {
		int num = 0;
		for(int count = 0; count < bev.size(); count++) {
			if(bev.get(count).getType() == type)
				num++;
		}
		return num;
	}
	
	public int generateOrder() { 
		return orderNo++;
	}
	
	public Day getOrderDay() { 
		return D;
	}
	
	
	public int getOrderTime() {
		return T;
	}
	
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		bev.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	public Customer getCustomer() {
		return c;
	}
	
	
	public int getTotalItems() { 
		return bev.size();
	}
	

	public void addNewBeverage(String bevName, Size size) {
		bev.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		bev.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	public int compareTo(Order anotherOrder) {
		if(anotherOrder.orderNo < orderNo) {
			return -1;
		}
		if(anotherOrder.orderNo > orderNo) {
			return 1;
		}
		return 0;
	}

	public Beverage getBeverage(int itemNo) {
		try {
			return bev.get(itemNo);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public double calcOrderTotal() {
		double totalPrice = 0;
		for(int count = 0; count < bev.size(); count++) {
			totalPrice += bev.get(count).calcPrice();
		}
		return totalPrice;
	}
	
	
	public String toString() { 
		String bevList = "";
		for(int count = 0; count < bev.size(); count++) {
			bevList += bev.get(count).toString() + "\n";
		}
		return String.format("Order#: %d\nTime: %d\nDay: %s\n%s\n%s",orderNo, T, D, c.toString() ,bevList);
	}

	
}