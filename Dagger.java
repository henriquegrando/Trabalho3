public class Dagger extends Weapon
{
	
	public Dagger (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Vocation.Thief);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}