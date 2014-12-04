public class Wizard extends Character
{
    /*Atributtes*/

    protected int wisdom;

    /*Methods*/

    public Wizard (String alias, int wisdom)
    {
	super(alias);
	this.wisdom = wisdom;
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
}