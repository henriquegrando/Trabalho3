public class Mail extends Armor
{
	
	public Mail (String name, double price, int attackpts, double range)
	{
		super(name, price, attackpts, range, Vocation.Knight);
	}
	
	public Vocation getVocation ()
	{
		return vocation;
	}	
	
}