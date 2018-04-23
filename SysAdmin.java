import java.io.FileNotFoundException;
import java.util.Scanner;

import BikePartDatabase.WareHouseDataBase;
public class SysAdmin extends LoginAccount
{
	public SysAdmin(String userType, String userName, String passWord, String firstName, String lastName, long phoneNum, String email) 
	{
		super(userType, userName, passWord, firstName, lastName, phoneNum, email);
	}

	static Scanner stan = new Scanner(System.in);
	String loginType = "";
	String firstName = "";
	String lastName = "";
	String userName = "";
	String passWord = "";
	String email = "";
	Long phoneNum;
	WareHouseDataBase whDB = new WareHouseDataBase();
	static LoginAccountDataBase laDB = new LoginAccountDataBase();
	
	public void createOfficeMgr(String uType, String fName, String lName, String uName, String pWord, String eMail, long pN)
	{
		this.loginType = uType;
		this.email = eMail;
		this.firstName = fName;
		this.lastName = lName;
		this.userName = uName;
		this.passWord = pWord;
		this.email = eMail;
		this.phoneNum = pN;
	}
	
	public WareHouseDataBase createSalesAssoc(String uType, String fName, String lName, String uName, String pWord, String eMail, long pN) throws FileNotFoundException
	{
		this.loginType = uType;
		this.email = eMail;
		this.firstName = fName;
		this.lastName = lName;
		this.userName = uName;
		this.passWord = pWord;
		this.email = eMail;
		this.phoneNum = pN;
		whDB.addToDB(userName);
		return whDB;
	}
	
	public WareHouseDataBase getWHDB()
	{
		return whDB;
	}
	
	public void createWarehouseMgr(String uType, String fName, String lName, String uName, String pWord, String eMail, long pN)
	{
		this.loginType = uType;
		this.email = eMail;
		this.firstName = fName;
		this.lastName = lName;
		this.userName = uName;
		this.passWord = pWord;
		this.email = eMail;
		this.phoneNum = pN;
	}
	
	public String resetPW(String uName, String eMail)
	{
		if (uName == userName && eMail == email)
		{
			System.out.println("Enter new passsword");
			String newPW = stan.nextLine();
			setPassWord(newPW);
		}
		return null;
	}

	public static void createAccountCmd() throws FileNotFoundException 
	{
		System.out.println("Enter user type: ");
		String userType = stan.nextLine();
		System.out.println("Enter username: ");
		String userName = stan.nextLine();
		System.out.println("Enter default password: ");
		String passWord = stan.nextLine();
		System.out.println("Enter user's first name: ");
		String firstName = stan.nextLine();
		System.out.println("Enter use's last name: ");
		String lastName = stan.nextLine();
		System.out.println("Enter user's phone number: ");
		long phoneNum = stan.nextLong();
		System.out.println("Enter user's email: ");
		String email = stan.nextLine();
		laDB.addToLA(userType, userName, passWord, firstName, lastName, phoneNum, email);
	}

	public static void deleteAccountCmd()
	{
		System.out.println("Enter username of account to delete: ");
		String name = stan.nextLine();
		laDB.removeAccount(name);
	}
}
