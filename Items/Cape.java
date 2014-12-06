package Items;

public class Cape extends Armor
{
	
	public Cape (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Thief);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}