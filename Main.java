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
		boolean stopLoop = true;
		WareHouseDataBase whDB = new WareHouseDataBase();
		whDB.readWareHouseDB(fileName);
		Commands cmds = new Commands(whDB);
		
		while (stopLoop)
		{
			stopLoop = cmds.userInput();
		}
		//mainwh.saveDB(mainwh.getWareHouseFileName());
		for (WareHouse wh : whDB.getAllWH())
		{
			wh.saveWarehouseFile(wh.getWareHouseFileName());
		}
		whDB.saveWareHouseDB();
		System.out.println("File saved.");
	}

}
