public class ManaPotion extends Potion
{
	public ManaPotion (String name, double price, int restorepts)
	{
		super(name, price, restorepts, Vocation.All);
	}

	public int use()
	{
		return super.getDefensePts();	//return restorepts
	}
}