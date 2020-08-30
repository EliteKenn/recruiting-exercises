package DliverrAssessment;

//This will be our driver class due to the class having a man method.
public class Main {
	public static void main(String[] args) {
		
		InventoryAllocator tester = new InventoryAllocator();
	

		//Test cases that check the warehouse
		tester.putInMap();
		System.out.println(tester.checkOnInventory(new Warehouse("blueberry", 20)));
		System.out.println(tester.checkOnInventory(new Warehouse("apple", 1)));
		System.out.println(tester.checkOnInventory(new Warehouse("apple", 11)));
		System.out.println(tester.checkOnInventory(new Warehouse("apple", 10)));
		System.out.println(tester.checkOnInventory(new Warehouse("grapes", 10)));
		System.out.println(tester.checkOnInventory(new Warehouse("watermelon", 5)));
		
		System.out.println(tester.checkOnInventory(new Warehouse("apple", 1)));
		
		
	}

}
