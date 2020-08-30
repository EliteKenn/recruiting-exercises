package DliverrAssessment;

//OOP - This class contains the names of the items and their costs
public class Warehouse {


	private String itemName;
	private int cost;
	
	public Warehouse() {
		
	}
	
	public Warehouse(String itemName, int cost) {
		this.itemName = itemName;
		this.cost = cost;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return itemName + ": " + cost;
	}
	
	
	

}
