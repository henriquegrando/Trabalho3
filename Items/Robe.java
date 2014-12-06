package Items;

public class Robe extends Armor
{
	
	public Robe (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Wizard);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}