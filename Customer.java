public class Customer {
	private String n;
	private int a;
	
	public Customer(String name, int age){ 
		this.n = name;
		this.a = age;
	}
	public Customer(Customer c) {
		n = c.n;
		a = c.a;
	}
	
	public int getAge() { 
		return a;
	}
	
	public String getName() { 
		return n;
	}
	
	public void setAge(int age) { 
		this.a = age;
	}
	
	public void setName(String name) { 
		this.n = name;
	}
	
	
	public String toString() { 
		return String.format("Name: %s\nAge:%d\n", n, a);
	}
	
}