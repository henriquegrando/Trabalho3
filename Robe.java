public class Robe extends Armor
{
	
	public Robe (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Vocation.Wizard);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}