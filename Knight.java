public class Knight extends Character
{
    /*Atributtes*/

    protected int power;

    /*Methods*/

    public Knight (String alias, int power)
    {
		super(alias);
		this.power = power;
    }

    @Override
    protected int getAttackPoints()
    {
		return super.getAttackPoints();
    }

    @Override
    protected int getDefensePoints()
    {
		return super.getDefensePoints() + power;
    }

	public void addPower (int value)
	{
		power = power + value;
	}
}

	
