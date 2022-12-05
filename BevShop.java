import java.util.ArrayList;
public class BevShop implements BevShopInterface {
	private int num = 0;
	
	ArrayList<Order> o = new ArrayList<Order>();
	
	public BevShop() {
	}
	
	public void sortOrders() {
		for(int count = 0; count < o.size() - 1; count++) { 
			int min_index = count;
			
			for(int i = count + 1; i < o.size(); i++) {
				if(o.get(count).calcOrderTotal() < o.get(min_index).calcOrderTotal())
					min_index = count;
				
				
				Order temp = new Order(o.get(min_index));
				o.set(min_index, new Order(o.get(count)));
				o.set(count, new Order(temp));
			}
		}
	}
	

	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
	
		getCurrentOrder().bev.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		System.out.println("Add drink\n");
	
	}

	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	public void processAlcoholOrder(String bevName, Size size) { 
		
		if(isEligibleForMore()) {
			getCurrentOrder().bev.add(new Alcohol(bevName, size, false)); 
			num++;
			System.out.println("Drink added.\n");
		}
		else {
			System.out.println("Max alcohol drink for this order");
		}
	}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		o.add(new Order(time, day, new Customer(customerName, customerAge)));
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits == MAX_FRUIT);
	}

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
	
		getCurrentOrder().bev.add(new Coffee(bevName, size, extraShot, extraSyrup));
		System.out.println("Drink added.\n");
	
	}
	

	public boolean isValidTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}


	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public Order getCurrentOrder() {
		return o.get(o.size() - 1);
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public boolean isEligibleForMore() {
		return (num < MAX_ORDER_FOR_ALCOHOL);
	}

	
	public int getNumOfAlcoholDrink() {
		return num;
	}

	public boolean isValidAge(int age) {
		return (age >= MIN_AGE_FOR_ALCOHOL);
	}

	
	public int findOrder(int orderNo) {
		int order1 = -1;
		
		for(int count = 0; count < o.size(); count++) {
			if(orderNo == o.get(count).getOrderNo())
				return count;
		}
		return order1;
	}

	public double totalOrderPrice(int orderNo) {
		return o.get(findOrder(orderNo)).calcOrderTotal();
	}

	public double totalMonthlySale() {
		double totalSales = 0;
		
		for(int count = 0; count < o.size(); count++) {
			totalSales += o.get(count).calcOrderTotal();
		}
		
		return totalSales;
	}

	public int totalNumOfMonthlyOrders() {
		return o.size();
	}

	public Order getOrderAtIndex(int index) {
		try{
			return o.get(index);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	



	

}