package Items;

public abstract class Item
{
    /*Attributes*/
    
    private String name;
    private double price;
    protected int attackpts;
    protected int defensepts;

    /*Methods*/

    /*Constructor*/
    
    public Item (String name, double price)
    {
	this.name = name;
	
	this.price = price;
    }

    public Item (Item item)
    {
        this.name = item.name;
        this.price = item.price;
    }
    
    /*Getters*/

    public String getName()
    {
	return name;
    }
    
    public double getPrice()
    {
	return price;
    }

    abstract public int getDefensePts ();
    
    abstract public int getAttackPts ();

}