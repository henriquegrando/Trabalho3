package Items;

public class HealthPotion extends Potion
{
	public HealthPotion (String name, double price, int restorepts)
	{
		super (name, price, restorepts);
	}

	public int use()
	{
		return super.getDefensePts();		//return restorepts
	}
}