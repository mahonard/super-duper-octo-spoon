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
	
	public void createSalesAssoc(String fName, String lName, String uName, String pWord, String eMail, long pN)
	{
		this.email = eMail;
		this.firstName = fName;
		this.lastName = lName;
		this.userName = uName;
		this.passWord = pWord;
		this.email = eMail;
		this.phoneNum = pN;
		WareHouse wh = new WareHouse(userName);
		wh.addToDB();
		
		//add set and get cmds?
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
		
		//add get/set cmds?
	}
	
	public String resetPW(String uName, String eMail)
	{
		//not really how it works but I can't figure out how to make it work right now
		if (uName == userName && eMail == email)
		{
			System.out.println("Enter new passsword");
			String newPW = stan.nextLine();
			//constructor.passwordSet(newPW);
		}
		return null;
	}
}
