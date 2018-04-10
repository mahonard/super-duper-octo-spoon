import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class WareHouse 
{
	private List<Inventory> wareHouse;
	private String whName;
	private String fileName;
	
	public WareHouse(String name) 
	{
		wareHouse = new ArrayList<Inventory>();
		whName = name;
		fileName = name + ".txt";
	}
	
	String setWareHouseName(String whName)
	{
		this.whName = whName;
		return whName;
	}
	
	String getWareHouseName() 
	{
		return whName;
	}

	private Inventory findInv(BikePart bikePart) 
	{
		for (Inventory inv : wareHouse)
		{
			if (inv.getBikePart().equals(bikePart)) 
			{
				return inv;
			}
		}
		return null;
	}
	
	List<Inventory> getInv() 
	{
		return wareHouse;
	}
	
	private void updateInv(Inventory inv, BikePart bikePart, int quantity)
	{
		inv.getBikePart().setRegPrice(bikePart.getRegPrice()); //get the BikePart info for inv, and set its price equal to the one from bikePart
		inv.getBikePart().setSalePrice(bikePart.getSalePrice()); //same deal for this one
		inv.getBikePart().setOnSale(bikePart.getOnSale()); //same here except for sale status
		inv.setTotal(inv.getTotal() + quantity); //adds new quantity to the previous quantity, allows for subtraction if a negative quantity is entered
	}
	
	private void subtractInv(Inventory inv, BikePart bikePart, int quantity)
	{
		inv.setTotal(quantity - (quantity - inv.getTotal())); 
	}

	public void whDBUpdate(String fileName) throws FileNotFoundException
	{
		Scanner readNames = new Scanner(new File(fileName) + ".txt");
		while (readNames.hasNextLine())
		{
			String whName = readNames.nextLine();
			String[] names = whName.split("\n");
			String wareHouseName = names[0];
			WareHouse wH = new WareHouse(wareHouseName);
		}
	}
	
	public void createWareHouseFile(String fileName)
	{
		new File(fileName + ".txt");
		return;
	}
	
	public void wareHouseUpdate(String fileName) throws FileNotFoundException 
	{
		Scanner readStuff = new Scanner(new File(fileName));
		
		while (readStuff.hasNextLine())
		{
			String line = readStuff.nextLine();
			String[] parts = line.split(",");
			String name = parts[0];
			int num = Integer.parseInt(parts[1]);
			double regPrice = Double.parseDouble(parts[2]);
			double salePrice = Double.parseDouble(parts[3]);
			boolean onSale = Boolean.parseBoolean(parts[4]);
			int quantity = Integer.parseInt(parts[5]);
			BikePart bikePart = new BikePart(name, num, regPrice, salePrice, onSale);
			addInv(bikePart, quantity);
		}
	}

	public Inventory addInv(BikePart bikePart, int quantity) 
	{
		Inventory inv = findInv(bikePart);
		if (inv != null)
		{
			updateInv(inv, bikePart, quantity);
		}
		else
		{
			wareHouse.add(new Inventory(bikePart, quantity));
		}
		return inv;
	}

	
	 public Inventory findPart(String name)
	{
		for (Inventory inv : wareHouse)
		{
			if (name.equals(inv.getBikePart().getName()))
			{
				return inv;
			}
		}
		return null;
	}
	 
	 public boolean confirmPart(String name)
	{
		for (Inventory inv : wareHouse)
		{
			if (name.equals(inv.getBikePart().getName()))
			{
				System.out.println(inv.getBikePart().getName() + ", " + inv.getTotal());
				return true;
			}
		}
		return false;
	}
	 
	public Inventory sellPart(int pNum, int qty) 
	 {
        Inventory f = null;
        for (Inventory i : wareHouse) 
        {
            if (i.getBikePart().getNum() == pNum) 
            {
                f = i;
                break;
            }
        }
        if (f != null)
            updateInv(f,f.getBikePart(),-qty);
        return f;
    }
	//TODO use saveDB to make warehouseDB writer
	public void saveWarehouseFile(String fileName) 
	{
		try
	        {
				PrintWriter writer = new PrintWriter(fileName, "UTF-8");
	            for (Inventory inv : wareHouse)
	                writer.println(inv.getBikePart().getName() + "," +
	                			   inv.getBikePart().getNum() + "," +
	                			   inv.getBikePart().getRegPrice() + "," +
	                			   inv.getBikePart().getSalePrice() + "," +
	                               inv.getBikePart().getOnSale() + "," +
	                               inv.getTotal());
	            writer.close();
	        } catch (IOException e) 
	        {
	            System.out.println("file error!");
	            e.printStackTrace();
	        }
	}

	public void movePartTo(Inventory i, int qty) 
	{ 
		for (Inventory f : wareHouse)
		{
			System.out.println("Moving " + f.getBikePart().getName() + " from wh1 and moving " + i.getBikePart().getName() + " to wh2"); 
			if (f.getBikePart().getName().equals(i.getBikePart().getName()))
			{
				updateInv(f, i.getBikePart(), qty);
				System.out.println("Num of " + i.getBikePart().getName() + " moved: " + qty);
				return;
			}
		}
		addInv(i.getBikePart(), i.getTotal());
		System.out.println("Made new part: " + i.getBikePart().getName() + " w/ " + qty);
		return;
	}
	
	public Inventory movePartFrom(String pName, int qty) 
	{
		for (Inventory i : wareHouse)
		{
			if (i.getBikePart().getName().equals(pName))
			{
				BikePart foundPart = i.getBikePart();
				if (i.getTotal() < qty)
				{
					qty = qty - Math.abs(i.getTotal() - qty);
				}
				subtractInv(i, foundPart, qty);
				return i;
			}
		}
		return null;
	}

	public String getWareHouseFileName() 
	{
		return fileName;
	}

}
