public class Thief extends GameCharacter
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
}
	
