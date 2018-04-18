import java.io.FileNotFoundException;
import java.util.Scanner;
public class SysAdmin extends LoginAccount
{
	public SysAdmin(String userName, String passWord, String firstName, String lastName, long phoneNum, String email) {
		super(userName, passWord, firstName, lastName, phoneNum, email);
	}

	Scanner stan = new Scanner(System.in);
	String firstName = "";
	String lastName = "";
	String userName = "";
	String passWord = "";
	String email = "";
	Long phoneNum;
	WareHouseDataBase whDB = new WareHouseDataBase();
	
	public void createOfficeMgr(String fName, String lName, String uName, String pWord, String eMail, long pN)
	{
		this.email = eMail;
		this.firstName = fName;
		this.lastName = lName;
		this.userName = uName;
		this.passWord = pWord;
		this.email = eMail;
		this.phoneNum = pN;
		
		//add set and get commands I guess?
	}
	
	public void createSalesAssoc(String fName, String lName, String uName, String pWord, String eMail, long pN) throws FileNotFoundException
	{
		this.email = eMail;
		this.firstName = fName;
		this.lastName = lName;
		this.userName = uName;
		this.passWord = pWord;
		this.email = eMail;
		this.phoneNum = pN;
		whDB.addToDB(userName);
	}
	
	public void createWarehouseMgr(String fName, String lName, String uName, String pWord, String eMail, long pN)
	{
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
}
