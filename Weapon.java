public abstract class Weapon extends Item
{
	protected int attackpts;
	protected double range;

	public Weapon (String name, double price, int attackpts, double range, Vocation vocation)
	{
		super(name, price, vocation);

		if (attackpts >= 1 && attackpts <= 9)
			this.attackpts = attackpts;
		else
			System.out.println ("Invalid attackpts for weapon\n");

		this.range = range;
	}

	public Weapon (Weapon weapon)
	{
		super(weapon);
		this.attackpts = weapon.attackpts;
		this.range = weapon.range;
	}

	public int getDefensePts()
	{
		return 0;
	}

	public int getAttackPts()
	{
		return attackpts;
	}

	public double getRange()
	{
		return range;
	}

}