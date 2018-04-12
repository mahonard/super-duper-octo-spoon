import java.util.ArrayList;
import java.util.Scanner;
public class SalesAssoc extends LoginAccount
{
	
	public SalesAssoc(String userName, String passWord, String firstName, String lastName, long phoneNum,
			String email) 
	{
		super(userName, passWord, firstName, lastName, phoneNum, email);
	}
	
	ArrayList<Invoice> ial = new ArrayList<Invoice>();
	public void salesVanLoad()
	{
		return;
	}
	public void createInvoice(String partName, double partPrice, int qty)
	{
		ial.add(new Invoice());
		//create and save an array of invoices to use this
	}
	
}
