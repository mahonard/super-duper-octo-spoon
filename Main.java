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
		whDB.readWareHouseDB("warehouseDB.txt");
		Commands cmds = new Commands(whDB);
		
		System.out.println("Enter username: ");
		String userName = stan.nextLine();
		System.out.println("Enter password: ");
		String passWord = stan.nextLine();
		String loginType = "";
		
		/**
		 * for (user : userDataBase) 
		 * {
		 *    if (userName.equals(user.getUserName()) && passWord.equals(user.getPassWord())
		 *    {
		 *       loginType = user.getLoginType();
		 *       return loginType;
		 *    }
		 * }
		 */
		
		while (stopLoop)
		{
			stopLoop = cmds.userInput();
		}
		
		for (WareHouse wh : whDB.getAllWH())
		{
			wh.saveWarehouseFile(wh.getWareHouseFileName());
		}
		whDB.saveWareHouseDB();
		System.out.println("File saved.");
	}

}
