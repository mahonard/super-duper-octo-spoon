import java.util.Scanner;
import java.lang.Iterable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Collections;


public class Commands 
{
	//TODO make cmds work with multiple WareHouses
	Scanner stan = new Scanner(System.in);
	WareHouseDataBase whDB;
	boolean timeToQuit = true;
	
	public Commands(WareHouseDataBase whDB)
	{
		this.whDB = whDB;
	}
	
	public boolean userInput() throws FileNotFoundException
	{
		System.out.println("AddVan, AddInv, Enter, Display, Sell\n"
						  + "SortName, SortNum, Move, Show\n"
						  + "Quit: save and exit\n"
						  + "Enter your choice: ");
		
		String userCmd = stan.nextLine();
		
		while (!(userCmd.equalsIgnoreCase("Quit")))
		{
			if (userCmd.equalsIgnoreCase("AddVan"))
			{
				addVanCmd();
				return timeToQuit;
			}
			else if (userCmd.equalsIgnoreCase("AddInv"))
			{
				addVanInvCmd();
				return timeToQuit;
			}
			else if (userCmd.equalsIgnoreCase("Enter"))
			{
				enterCmd();
				return timeToQuit;
			}
			else if (userCmd.equalsIgnoreCase("Display"))
			{
				displayCmd();
				return timeToQuit;
			}
			else if (userCmd.equalsIgnoreCase("Sell"))
			{
				sellCmd();
				return timeToQuit;
			} 
			else if (userCmd.equalsIgnoreCase("SortName"))
			{
				System.out.println("What file do you want to sort? Type \"all\" for all: ");
				String fileName = stan.nextLine();
				nameSortCmd(fileName);
				return timeToQuit;
			}
			else if (userCmd.equalsIgnoreCase("SortNum"))
			{
				System.out.println("What file do you want to sort? Type \"all\" for all: ");
				String fileName = stan.nextLine();
				numSortCmd(fileName);
				return timeToQuit;
			}
			else if (userCmd.equalsIgnoreCase("Move"))
			{
				takeCmd();
				return timeToQuit;
			}
			else if (userCmd.equalsIgnoreCase("Show"))
			{
				for (WareHouse w : whDB.getWHDB())
				{
					System.out.println(w.getWareHouseName());
				}
				return timeToQuit;
			}
			else
			{
				System.out.println("Invalid command. Please try again.");
				return timeToQuit;
			}
		} 
		
		if (userCmd.equalsIgnoreCase("Quit"))
		{
			quitCmd();
			timeToQuit = false;
			return timeToQuit;
		}
		return timeToQuit;
	}
	
	private WareHouse addVanCmd() throws FileNotFoundException
	{
		System.out.println("Enter name of the new sales van: ");
		String name = stan.nextLine();
		WareHouse wh = whDB.addToDB(name);
		return wh;
	}
	
	private void addVanInvCmd() 
	{
		System.out.println("Enter the name of the warehouse/van you wish to update: ");
		String vanName = stan.nextLine();
		try 
		{
			WareHouse vanWH = whDB.getWareHouse(vanName);
			System.out.println("Enter inventory update file name: ");
			String fileName = stan.nextLine() + ".txt";
			vanWH.wareHouseUpdate(fileName);
		} catch (FileNotFoundException e) 
		{
			System.out.println("addVanInvCmd() Sales van not found.");
			e.printStackTrace();
		}
	}
	
	private void enterCmd() 
	{
		System.out.println("What file do you want to add to?");
		String fileName = stan.nextLine();
		WareHouse wH = whDB.getWareHouse(fileName);
		System.out.println("Enter part info, separated by commas: ");
		String line = stan.nextLine();
		String[] parts = line.split(",");
		String name = parts[0];
		int num = Integer.parseInt(parts[1]);
		double regPrice = Double.parseDouble(parts[2]);
		double salePrice = Double.parseDouble(parts[3]);
		boolean onSale = Boolean.parseBoolean(parts[4]);
		int quantity = Integer.parseInt(parts[5]);
		wH.addInv(new BikePart(name, num, regPrice, salePrice, onSale), quantity);
		System.out.println("Item added to inventory.");
		return;
	}
	
	private void displayCmd() 
	{
		System.out.println("What file do you want to search?");
		String fileName = stan.nextLine();
		System.out.println("Enter part name: ");
		String pN = stan.nextLine();
		WareHouse displayWH = whDB.getWareHouse(fileName);
		Inventory inv = displayWH.findPart(pN);
		if (inv != null)
		{
			System.out.println(inv.toString());
		}
		else 
		{
			System.out.println("Part not found.");
		}
	}

	private void sellCmd() 
	{
		System.out.println("What file do you want to sell from?");
		String fileName = stan.nextLine();
		WareHouse wh = whDB.getWareHouse(fileName);
		System.out.println("Enter part number:");
		int pNum = Integer.parseInt(stan.nextLine());
		System.out.println("Enter number to sell");
		int qty = Integer.parseInt(stan.nextLine());
		Inventory inv = wh.sellPart(pNum, qty);
		System.out.println(inv + " " + (new Date()).toString());
	}
	
	private void nameSortCmd(String whName) 
	{
		WareHouse wh = whDB.getWareHouse(whName);
		if (!(whName.equalsIgnoreCase("all")))
		{
			Collections.sort(wh.getInv(), Inventory.sortName);
		}
		else if (whName.equalsIgnoreCase("all"))
		{
			for (WareHouse wareHouse : whDB.getWHDB())
			{
				Collections.sort(wareHouse.getInv(), Inventory.sortName);
				
				System.out.println(wareHouse.getWareHouseName());
				for (Inventory inv : wareHouse.getInv())
				{
					System.out.println(inv);
				}
				return;
			}
		}
		Collections.sort(wh.getInv(), Inventory.sortName);
		
			for (Inventory inv : wh.getInv())
			{
				System.out.println(inv);
			}
			return;
	}
	
	private void numSortCmd(String whName) 
	{
		
		WareHouse wh = whDB.getWareHouse(whName);
		Collections.sort(wh.getInv(), Inventory.sortNum);
		for (Inventory inv : wh.getInv()) 
		{
			System.out.println(inv);
		}
		return;
	}
	
	private void takeCmd() 
	{
		//add qty to whName2
		//remove qty from whName1
		System.out.println("Enter inventory file name: ");
		String fileName = stan.nextLine() + ".txt";
		//takes in file
		try 
		{
			File fileToRead = new File(fileName);
			Scanner readStuff = new Scanner(fileToRead);
			String line = readStuff.nextLine();
			String[] info = line.split(",");
			String whName1 = info[0];
			String whName2 = info[1];
			WareHouse wh1 = whDB.getWareHouse(whName1);
			System.out.println(wh1.getWareHouseName());
			WareHouse wh2 = whDB.getWareHouse(whName2);
			System.out.println(wh2.getWareHouseName());
			
			while (readStuff.hasNextLine() && !(whName2.equals("mainwh")))
			{
				line = readStuff.nextLine();
				String[] partInfo = line.split(",");
				String partName = partInfo[0];
				int qty = Integer.parseInt(partInfo[1]);
				wh1.movePartFrom(partName, qty);
				System.out.println(partName + " " + qty);
				Inventory i = wh1.findPart(partName);
				wh2.movePartTo(i, qty);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("There was a problem. Please try again.");
			e.printStackTrace();
			return;
		}
		
	}
	
	private void quitCmd() 
	{
		System.out.println("Exiting program, saving changes.");
		System.out.println("...");
	}	
	
	
	private void readCmd(String whName) 
	{
		try 
		{
			WareHouse w = whDB.getWareHouse("mainwh");
			w.wareHouseUpdate(w.getWareHouseFileName());
			return;
		} 
		catch (FileNotFoundException e) {
			System.out.println("There was a problem. Please try again.");
			e.printStackTrace();
			return;
		}
	}
	
}
