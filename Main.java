import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Scanner stan = new Scanner(System.in);
		
		String fileName = "warehouseDB";
		//TODO add read warehouseDB.txt loop
		boolean stopLoop = true;
		WareHouseDataBase whDB = new WareHouseDataBase();
		WareHouse mainwh = whDB.wareHouseMain();
		mainwh.wareHouseUpdate(mainwh.getWareHouseFileName());
		Commands cmds = new Commands(whDB);
		
		while (stopLoop)
		{
			stopLoop = cmds.userInput();
		}
		//mainwh.saveDB(mainwh.getWareHouseFileName());
		for (WareHouse wh : whDB.getAllWH())
		{
			wh.saveDB(wh.getWareHouseFileName());
		}
		whDB.saveWareHouseDB(fileName);
		System.out.println("File saved.");
	}

}
