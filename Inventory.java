import java.util.Comparator;

public class Inventory 
{
	private BikePart bikePart;
	private int total = 0;
	private String whichWareHouse = "";
	
	
	public static Comparator<Inventory> sortName = new Comparator<Inventory>()
			{
				@Override
				public int compare(Inventory inv1, Inventory inv2)
				{
					String inv1Name = inv1.getBikePart().getName() + inv1.getBikePart().getName();
			        String inv2Name = inv2.getBikePart().getName() + inv2.getBikePart().getName();
			        return inv1Name.compareTo(inv2Name);
				}
			};
		
	public static Comparator<Inventory> sortNum = new Comparator<Inventory>() 
			{
				@Override
				public int compare(Inventory inv1, Inventory inv2) 
				{
					int invNum1 = inv1.getBikePart().getNum();
					int invNum2 = inv2.getBikePart().getNum();
					return Integer.compare(invNum1, invNum2);
				}
			};
	
	/**
	 * Inspired by Gusty's solution.
	 * Takes two Inventory objects and compares them to sort alphabetically
	 * @param inv1
	 * @param inv2
	 * @return
	 */
		
		public Inventory(BikePart bikePart, int count) 
	    {
	        this.bikePart = bikePart;
	        total = count;
	    }
		
		public String setWareHouseName(String name)
		{
			this.whichWareHouse = name;
			return whichWareHouse;
		}
		
		public String getWareHouseName()
		{
			return whichWareHouse;
		}
		
		public BikePart getBikePart() 
	    {
	        return bikePart;
	    }

	    public void setBikePart(BikePart bikePart) 
	    {
	        this.bikePart = bikePart;
	    }
	    
	    public int getTotal() 
	    {
	        return total;
	    }

	    public void setTotal(int total) 
	    {
	        this.total = total;
	    }
		
	    @Override
	    public String toString()
	    {
			return "" + bikePart + total;
	    }
}
