import java.util.Scanner;
public class SalesAssoc extends LoginAccount
{
	private String userName = "";
	private String passWord = "";
	String firstName = "";
	String lastName = "";
	String email = "";
	long phoneNum;
	
	
	public String getUserName()
	{
		String uName = userName;
		return uName;
	}
	public String getEmail()
	{
		String eMail = email;
		return eMail;
	}
	public String setEmail(String eMail)
	{
		this.email = eMail;
		return email;
	}
	public String getFirstName()
	{
		String fName = firstName;
		return fName;
	}
	public String setFirstName(String fName)
	{
		this.firstName = fName;
		return firstName;
	}
	public String getLastName()
	{
		String lName = lastName;
		return lName;
	}
	public String setLastName(String lName)
	{
		this.lastName = lName;
		return lastName;
	}
	public long getPhoneNum()
	{
		long pNum = phoneNum;
		return pNum;
	}
	public long setPhoneNum(long pNum)
	{
		phoneNum = pNum;
		return phoneNum;
	}
	
	public void salesVanLoad()
	{
		//needs to call a special cmds file that can only access what the sales assoc can do
	}
	public void createInvoice(String partName, double partPrice, int qty)
	{
		//create and save an array of invoices to use this
	}
	
}
