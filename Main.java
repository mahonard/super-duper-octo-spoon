import java.io.FileNotFoundException;
import java.util.Scanner;

import BikePartDatabase.WareHouse;
import BikePartDatabase.WareHouseDataBase;

import java.io.PrintStream;
import java.io.PrintWriter;

public class Main 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner stan = new Scanner(System.in);
		boolean stopLoop = true;
		WareHouseDataBase whDB = new WareHouseDataBase();
		LoginAccountDataBase laDB = new LoginAccountDataBase();
		whDB.readWareHouseDB("warehouseDB.txt");
		
		System.out.println("Enter username: ");
		String userName = stan.nextLine();
		System.out.println("Enter password: ");
		String passWord = stan.nextLine();
		String loginType = null;
		
		for (LoginAccount user : laDB.getAllLA()) 
		 {
		    if (userName.equals(user.getUserName()) && passWord.equals(user.getPassWord()))
		    {
		       loginType = user.getLoginType();
		    }
		    else 
		    {
		    	System.out.println("Invalid login. Please try again.");
		    }
		 }
		
		Commands cmds = new Commands(loginType, whDB);
		
		while (stopLoop)
		{
			stopLoop = cmds.userInput();
		}
		
		for (WareHouse wh : whDB.getAllWH())
		{
			wh.saveWarehouseFile(wh.getWareHouseFileName());
		}
		
		for (LoginAccount user : laDB.getAllLA())
		{
			user.saveUserFile(user.getUserName());
		}
		whDB.saveWareHouseDB();
		laDB.saveLoginAccountDB();
		System.out.println("File saved.");
	}

}
