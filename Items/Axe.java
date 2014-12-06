package Items;

public class Axe extends Weapon
{
	
	public Axe (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Knight);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}