public class Knight extends GameCharacter
{
    /*Atributtes*/

    protected int power;

    /*Methods*/

    public Knight (String alias, int power)
    {
		super(alias);
		this.power = power;
		vocation = Vocation.Knight;
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

	
