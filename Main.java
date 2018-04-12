import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		//TODO get main to load in
		Scanner stan = new Scanner(System.in);
		boolean stopLoop = true;
		WareHouseDataBase whDB = new WareHouseDataBase();
		whDB.readWareHouseDB("warehouseDB.txt");
		Commands cmds = new Commands(whDB);
		
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
