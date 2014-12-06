public abstract class Armor extends Item
{
	protected int defensepts;
	protected double weight;

	public Armor (String name, double price, int defensepts, double weight, Vocation vocation)
	{
		super(name, price, vocation);
		
	if (defensepts >= 1 && defensepts <= 20)
	{
		this.defensepts = defensepts;
	}
	else
		System.out.println ("Defense points must be between 1 and 20\n");
	
	if (weight >= 1 && weight <= 20)
	{
		this.weight = weight;	
	}
	else
		System.out.println ("Weight must be between 1 and 20\n");
	}

	public Armor (Armor armor)
	{
		super (armor);
		this.defensepts = armor.defensepts;
		this.weight = armor.weight;
	}

	@Override
	public int getDefensePts()
	{
		return defensepts;
	}

	@Override
	public int getAttackPts()
	{
		return 0;
	}

	public double getWeight()
	{
		return weight;
	}
}