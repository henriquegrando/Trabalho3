public class Wizard extends GameCharacter implements Desert, City
{
    /*Atributtes*/

    protected int wisdom;

    /*Methods*/

    public Wizard (String alias, int wisdom)
    {
		super(alias);
		this.wisdom = wisdom;
		vocation = Vocation.Wizard;
    }

    @Override
    protected int getAttackPoints()
    {
		return super.getAttackPoints();
    }

    @Override
    protected int getDefensePoints()
    {
		return super.getDefensePoints() + (wisdom/2);
    }

    public void addWisdom (int value)
	{
		wisdom = wisdom + value;
	}
	
	/* Implementing interface methods */
	public void activeCity ()
	{
		setStrenght (this.strenght - 5);
		setSpeed (this.speed - 5);
		setConstitution (this.constitution - 5);
		setDexterity (this.dexterity - 5);
	}
	
	public void activeDesert ()
	{
		setStrenght (this.strenght + 5);
		setSpeed (this.speed + 5);
		setConstitution (this.constitution + 5);
		setDexterity (this.dexterity + 5);
	}
}