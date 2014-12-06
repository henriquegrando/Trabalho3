public class HealthPotion extends Potion
{
	public HealthPotion (String name, double price, int restorepts)
	{
		super (name, price, restorepts, Vocation.All);
	}

	public int use()
	{
		return super.getDefensePts();		//return restorepts
	}
}