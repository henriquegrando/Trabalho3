public abstract class Potion extends Item
{
	private int restorepts;

	public Potion (String name, double price, int restorepts, Vocation vocation)
	{
		super(name, price, vocation);
		this.restorepts = restorepts;
	}

	public Potion (Potion potion)
	{
		super(potion);
		this.restorepts = potion.restorepts;
	}

	public int getDefensePts()
	{
		return restorepts;
	}

	public int getAttackPts()
	{
		return 0;
	}
}