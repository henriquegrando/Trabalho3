public class Knight extends GameCharacter implements Desert, Forest
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
	
	/* Implementing interface methods */
	public void activeDesert ()
	{
		setStrenght (this.strenght - 5);
		setSpeed (this.speed - 5);
		setConstitution (this.constitution - 5);
		setDexterity (this.dexterity - 5);
	}

	public void activeForest ()
	{
		setStrenght (this.strenght + 5);
		setSpeed (this.speed + 5);
		setConstitution (this.constitution + 5);
		setDexterity (this.dexterity + 5);
	}
		
}

	
