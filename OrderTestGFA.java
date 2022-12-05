import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Interface for an Order
 * 
 * @author Farnaz Eivazi
 * @version 8/22/2022
 *
 */

public class OrderTestGFA {
	Order o1, o2, o3, o4;

	@Before
	public void setUp() throws Exception {
		o1 = new Order(10, Day.TUESDAY, new Customer("Table", 21));
		o2 = new Order(12, Day.SATURDAY, new Customer("Chair", 40));
		o3 = new Order(10, Day.MONDAY, new Customer("Holly", 50));
	}

	@After
	public void tearDown() throws Exception {
		o1 = o2 = o3 = null;
	}

	@Test
	public void testGetBeverage() {
		Coffee cf = new Coffee("Decaf", Size.LARGE, false, false);
		Alcohol al = new Alcohol("Tequila", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Tea", Size.MEDIUM, 1, false);
		Smoothie sm2 = new Smoothie("Tea", Size.LARGE, 1, false);

		o1.addNewBeverage("Decaf", Size.SMALL, false, false);
		o2.addNewBeverage("Tequila", Size.SMALL);
		o1.addNewBeverage("Tea", Size.MEDIUM, 1, false);
		assertTrue(o1.getBeverage(0).equals(cf));
		assertTrue(o1.getBeverage(1).equals(al));
		assertTrue(o1.getBeverage(2).equals(sm1));
		assertFalse(o1.getBeverage(2).equals(sm2));
	}
	
	@Test
	public void testCalcOrderTotal() {
		o1.addNewBeverage("Decaf", Size.LARGE, false, false);
		o1.addNewBeverage("Tequila", Size.SMALL);
		o1.addNewBeverage("Tea", Size.MEDIUM, 1, false);

		assertEquals(7.5, o1.calcOrderTotal(), .01);

		o2.addNewBeverage("Decaf", Size.LARGE, true, false);
		o2.addNewBeverage("Tequila", Size.SMALL);
		o2.addNewBeverage("Tea", Size.MEDIUM, 4, true);

		assertEquals(12.6, o2.calcOrderTotal(), .01);

	}

	@Test
	public void testAddNewBeverage() throws NullPointerException {

		assertTrue(o1.getTotalItems() == 0);
		o1.addNewBeverage("Decaf", Size.LARGE, false, false);
		assertTrue(o1.getBeverage(0).getType().equals(Type.COFFEE));
		o1.addNewBeverage("Tequila", Size.SMALL);
		assertTrue(o1.getBeverage(1).getType().equals(Type.ALCOHOL));
		o1.addNewBeverage("Tea", Size.MEDIUM, 1, false);
		assertTrue(o1.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(o1.getTotalItems() == 3);

		o2.addNewBeverage("Tea", Size.MEDIUM, 4, true);
		assertTrue(o2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		o2.addNewBeverage("Tequila", Size.SMALL);
		assertTrue(o2.getBeverage(1).getType().equals(Type.ALCOHOL));
		o2.addNewBeverage("Decaf", Size.LARGE, true, false);
		assertTrue(o2.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(o2.getTotalItems() == 3);

	}



}