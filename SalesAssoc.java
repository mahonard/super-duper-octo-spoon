import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class SalesAssoc extends LoginAccount
{
	
	public SalesAssoc(String userName, String passWord, String firstName, String lastName, long phoneNum,
			String email) 
	{
		super(userName, passWord, firstName, lastName, phoneNum, email);
	}
	
	ArrayList<Invoice> ial = new ArrayList<Invoice>();
	//TODO fix below b/c this van should have been previously made by sysadmin
	WareHouse myVan = new WareHouse(getUserName());
	public void salesVanLoad(String fileName) throws FileNotFoundException
	{
		myVan.wareHouseUpdate(fileName);
		//TODO fix b/c this doesn't decrement mainwh yet
		return;
	}
	public ArrayList<Invoice> createInvoice(String buyerName, String pickupName, String partName, double partPrice, int qty, Date date)
	{
		ial.add(new Invoice(buyerName, pickupName, partName, partPrice, qty, date));
		return ial;
	}
	
}
