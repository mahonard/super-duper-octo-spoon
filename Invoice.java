import java.util.Date;
import java.util.Scanner;

public class Invoice 
{
	private String buyerName;
	private Date dateSold;
	private String buyerEmployee;
	private String partNames;
	private double soldPrice;
	private int qtySold;
	private double totalCost;

	public Invoice(String buyerName, String pickupName, String partName, double partPrice, int qty, Date date)
	{
		this.buyerName = buyerName;
		buyerEmployee = pickupName;
		partNames = partName;
		soldPrice = partPrice;
		qtySold = qty;
		dateSold = date;
	}


	public void setBuyerName(String name)
	{
		this.buyerName = name;
	}
	public String getBuyerName()
	{
		return buyerName;
	}
	public void setDateSold(Date date) 
    {
        this.dateSold = date;
    }
    public Date getDateSold() 
    {
        return dateSold;
    }
    public void setBuyerEmployee(String person) 
    {
        this.buyerEmployee = person;
    }
    public String getBuyerEmployee() 
    {
        return buyerEmployee;
    }
    public void setPartNames(String partName) 
    {
        this.partNames = partName;
    }
    public String getPartNames() 
    {
        return partNames;
    }
    public void setSoldPrice(double price) 
    {
        this.soldPrice = price;
    }
    public double getSoldPrice() 
    {
        return soldPrice;
    }
    public void setQtySold(int qty) 
    {
        this.qtySold = qty;
    }
    public int getQtySold() 
    {
        return qtySold;
    }
    public void setTotalCost(double cost) 
    {
        this.totalCost = cost;
    }
    public double getTotalCost() 
    {
    	totalCost = qtySold * soldPrice;
        return totalCost;
    }
    private String priceToString()
    {
    	return "" + soldPrice;
    }
    private String qtyToString()
    {
    	return "" + qtySold;
    }
    private String costToString()
    {
    	return "" + totalCost;
    }
    public String getInvoicePrintOut()
    {
    	String intro = "Sales invoice for " + buyerName + ", " + dateSold + "\n";
    	String columns = "Part Name     Price     Qty     Total Cost\n";
    	String parts = partNames + "     \n";
    	String price = priceToString() + "     \n";
    	String quantity = qtyToString() + "     \n";
    	String finalCost = costToString() + "\n";
    	//String pickupPerson = buyerEmployee;
    	return intro + columns + parts + price + quantity + finalCost;
    }
}
