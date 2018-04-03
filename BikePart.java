public class BikePart 
{
	private String name;
	private int num;
	private double regPrice;
	private double salePrice;
	private boolean onSale;
	
	public BikePart (String name, int num, double regPrice, double salePrice, boolean onSale)
	{
		this.name = name;
		this.num = num;
		this.regPrice = regPrice;
		this.salePrice = salePrice;
		this.onSale = onSale;
	}
	
			//set value commands
	
		public void setName (String name)
		{
			this.name = name;
		}
		public void setNum (int num)
		{
			this.num = num;
		}
		public void setRegPrice (double regPrice)
		{
			this.regPrice = regPrice;
		}
		public void setSalePrice (double salePrice)
		{
			this.salePrice = salePrice;
		}
		public void setOnSale (boolean onSale)
		{
			this.onSale = onSale;
		}
		public double getPrice() 
		{
			return onSale ? salePrice : regPrice;
		}
		
		
		//get value commands
		public String getName()
		{
			return name;
		}
		public int getNum()
		{
			return num;
		}
		public double getRegPrice()
		{
			return regPrice;
		}
		public double getSalePrice()
		{
			return salePrice;
		}
		public boolean getOnSale()
		{
			return onSale;
		}
	
		
		/**
		 * Inspired by Gusty's solution.
		 * Tests if given object exists via checking the item name and item number
		 * 
		 */
		
		public boolean equals(Object x) 
		{
	        if (this == x) 
	        	return true;
	        if (x == null || getClass() != x.getClass())
	        	return false;
	        BikePart bikePart = (BikePart) x;
	        if (num != bikePart.num) 
	        	return false;
	        return name != null ? name.equals(bikePart.name) : bikePart.name == null;

	    }
		
		@Override
		public String toString()
		{
			return name + ", " + num + ", " + regPrice + ", " + salePrice + ", " + onSale + "; ";
		}
		
		
}
