package Items;

public class ManaPotion extends Potion
{
	public ManaPotion (String name, double price, int restorepts)
	{
		super(name, price, restorepts);
	}

	public int use()
	{
		return super.getDefensePts();	//return restorepts
	}
}