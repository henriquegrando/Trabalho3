public class Thief extends GameCharacter implements City, Forest
{
    /*Atributtes*/

    protected int stealth;

    /*Methods*/

    public Thief (String alias, int stealth)
    {
		super(alias);
		this.stealth = stealth;
		vocation = Vocation.Thief;
    }

    @Override
    protected int getAttackPoints()
    {
		return super.getAttackPoints() + stealth;
    }

    @Override
    protected int getDefensePoints()
    {
		return super.getDefensePoints();
    }

    public void addStealth (int value)
	{
		stealth = stealth + value;
	}
	
	/* Implementing interface methods */
	public void activeForest ()
	{
		setStrenght (this.strenght - 5);
		setSpeed (this.speed - 5);
		setConstitution (this.constitution - 5);
		setDexterity (this.dexterity - 5);
	}
	
	public void activeCity ()
	{
		setStrenght (this.strenght + 5);
		setSpeed (this.speed + 5);
		setConstitution (this.constitution + 5);
		setDexterity (this.dexterity + 5);
	}
}
	
