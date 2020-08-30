package DliverrAssessment;

import java.util.*;

//This class handle's the processing by checking the warehouse and returning the proper result
public class InventoryAllocator {

	//Variables
    private Warehouse item = new Warehouse();
    private LinkedList<Warehouse> items = new LinkedList<>();
    //TreeMap so that it's pre-sorted.
    private TreeMap<String, Warehouse> output = new TreeMap<>(Collections.reverseOrder());
    private TreeMap<String, LinkedList<Warehouse>> theMap = new TreeMap<>(Collections.reverseOrder());

    //The function checkOnInventory will be our bread-and-butter
	/*
	It will take in a Warehouse product and check through the warehouse
	to return the cheapest output
	 */
    public TreeMap<String, Warehouse> checkOnInventory(Warehouse product) {
        System.out.println("Test: " + product);

        int anchor = 0;
        int total = 0;
        boolean stop = false;
        boolean stop2 = false;

        total = isLarger(product, total);

        /*

            	Checking to see if the item's cost is more than the total thats in the warehouse
            	 */
        if (total == 0) {
            System.out.println("Item not in the warehouse");
            return new TreeMap<String, Warehouse>();
        }

        if (product.getCost() > total && total != 0) {
            System.out.println("Insufficient");
            return new TreeMap<String, Warehouse>();
        }

        for (Map.Entry<String, LinkedList<Warehouse>> itr : theMap.entrySet()) {
            items = itr.getValue();

            for (int i = 0; i < items.size(); i++) {

            	/*
            	Checking to see if the item is in the warehouse. If so then set the anchor on that index then break out the loop
            	If not then keep iterating through the warehouses
            	 */
                if (items.get(i).getItemName().equals(product.getItemName())) {
                    anchor = i;
                    stop = true;
                    break;
                }
            }
            if (stop == false) {
                continue;
            }

			/*
			 *Checking edge cases
			 * 1.If the cost is the same
			 * 2.if the cost is less
			 * 3.If the cost is more
			 */
			if (product.getCost() == items.get(anchor).getCost()) {
                output.put(itr.getKey(), new Warehouse(items.get(anchor).getItemName(), items.get(anchor).getCost()));
                product.setCost(product.getCost() - items.get(anchor).getCost());
                stop2 = true;
                break;
            } else if (product.getCost() < items.get(anchor).getCost()) {
                output.put(itr.getKey(), new Warehouse(product.getItemName(), items.get(anchor).getCost()));
                stop2 = true;
                break;
            } else {

                if (product.getCost() == 0) {
                    break;
                }

                item.setItemName(items.get(anchor).getItemName());
                item.setCost(items.get(anchor).getCost());
                output.put(itr.getKey(), item);

                product.setCost(product.getCost() - items.get(anchor).getCost());
            }
            if (stop2) {
                stop2 = false;
                break;
            }
        }
        return output;
    }

    //The method will get the sum for each item, and store it in total
    public int isLarger(Warehouse product, int sum) {
        for (Map.Entry<String, LinkedList<Warehouse>> itr : theMap.entrySet()) {
            items = itr.getValue();

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItemName().equals(product.getItemName())) {
                    sum += items.get(i).getCost();
                }
            }
        }
        return sum;
    }

    //We'll put the warehouse hashmap with some default values so that we have something to work with.
	//User could provide names(ex: owd) for the warehouse, items, and the cost.
    public void putInMap() {

        LinkedList<Warehouse> cart = new LinkedList<>();
        cart.add(new Warehouse("apple", 1));
        cart.add(new Warehouse("orange", 5));
        theMap.put("owd", cart);
        items = new LinkedList<>();


        cart.add(new Warehouse("apple", 5));
        cart.add(new Warehouse("banana", 10));
        cart.add(new Warehouse("orange", 10));

        theMap.put("dm", cart);

        items = new LinkedList<>();
        cart.add(new Warehouse("grapes", 10));
        cart.add(new Warehouse("watermelon", 25));
        cart.add(new Warehouse("strawberry", 15));
        theMap.put("ny", cart);


    }
}
