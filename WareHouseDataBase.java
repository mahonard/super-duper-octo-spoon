import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WareHouseDataBase 
{
	private List<WareHouse> whDataBase = new ArrayList<WareHouse>();
	
	public WareHouse wareHouseMain()
	{
		WareHouse mainwh = new WareHouse("mainwh");
		whDataBase.add(mainwh);
		return mainwh;
	}
	
	public List<WareHouse> getWHDB()
	{
		return whDataBase;
	}
	
	public ArrayList<WareHouse> getAllWH()
	{
		ArrayList<WareHouse> whDB = new ArrayList<WareHouse>();
		for (WareHouse w : whDataBase)
		{
			whDB.add(w);
		}
		return whDB;
	}
	
	public String showAllWH()
	{
		String list = "";
		for (WareHouse wh : whDataBase)
		{
			list += wh.getWareHouseName() + "\n";
		}
		return list;
	}
	
	public WareHouse addToDB(String whName) throws FileNotFoundException
	{
		WareHouse newWH = new WareHouse(whName);
		newWH.createWareHouseFile(whName);
		whDataBase.add(newWH);
		return newWH;
	}
	
	public void vanInvUpdate(WareHouse wh) throws FileNotFoundException
	{
		wh.wareHouseUpdate(wh.getWareHouseName());
	}

	public WareHouse getWareHouse(String whName) 
	{
		WareHouse w = new WareHouse("");
		for (WareHouse wareHouse : whDataBase)
		{
			if (wareHouse.getWareHouseName().equals(whName))
			{
				w = wareHouse;
			}
		}
		return w;
	}
	
	public void readWareHouseDB(String fileName) throws FileNotFoundException 
	{
		Scanner readStuff = new Scanner(new File(fileName));
		String whName = "";
		
		if (readStuff.hasNextLine() == false)
		{
			return;
		}
		while (readStuff.hasNextLine())
		{
			whName = readStuff.nextLine();
			WareHouse wh = addToDB(whName);
			wh.wareHouseUpdate(whName + ".txt");
		}
	}
	
	public void saveWareHouseDB() 
	{		
		PrintWriter writer = null;
		try
	    {
			File saveFile = new File("warehouseDB.txt");
			writer = new PrintWriter(saveFile, "UTF-8");
			for (WareHouse w : whDataBase)
			{
				writer.println(w.getWareHouseName());
			}
	    }
		catch (IOException e) 
	    {
			System.out.println("file error!");
	        e.printStackTrace();
	    }
		finally
		{
			if (writer != null)
			{
				writer.close();
			}
		}
	}
}
