public class Wand extends Weapon
{
	
	public Wand (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Vocation.Wizard);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}