public class Sword extends Weapon
{
	
	public Sword (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Vocation.Knight);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}