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
	private String costAndQty;
	private double totalCost;

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
        return totalCost;
    }
    public void setCostAndQty(String finalNums) 
    {
        this.costAndQty = finalNums;
    }
    public String getCostAndQty() 
    {
        return costAndQty;
    }
    
}
