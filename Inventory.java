import java.util.*;

public class Inventory
{
    /*Attributes*/

    private int spaces;
    private double gold;
    private ArrayList<Pair<Item, Boolean> > items;
    private int equipedarmors;	//number of equiped armors
    private int equipedweapons;	//number of equiped weapons

    /*Methods*/

    public Inventory ()
    {
		items = new ArrayList<Pair<Item, Boolean> >();
		spaces = 10;
		gold = 0.0;
		equipedarmors = 0;
		equipedweapons = 0;
    }

    public void clearInventory()
    {
    	items.clear();
    }
    
    public double getTotalGold()
    {
		return gold;
    }
    
    public int getAvailableSpace()
    {
		return (spaces - items.size());
    }
    
    public void spendGold(double gold)
    {
		if (gold >= 0)
		    this.gold = this.gold - gold;
		else
		    System.out.println ("Value must be positive!");
    }

    public void earnGold(double gold)
    {
		if (gold >= 0)
		    this.gold = this.gold + gold;
		else
		    System.out.println ("Value must be positive!");
    }
    
    public void setSpaces(int spaces)
    {
		if (spaces < items.size())
		    System.out.println ("Space in use! Can't delete it!");
		else
		    this.spaces = spaces;
    }
    
    public Item searchItem(String name)
    {
		for (int i=0; i < items.size(); i++)
		{
			if(items.get(i).getFirst().getName().equals(name))
		    	return items.get(i).getFirst();
		}
	
		System.out.println ("Item not found!");
		return null;
    }
    
    public Item searchItem(int index)
    {
		if (index >= 0 && index < items.size())      /*Check if the index is not out of boundaries*/
	    	return items.get(index).getFirst();
		else
	    {
			System.out.println ("Out of bounds! Choose an element between 0 and " + (items.size()-1));
			return null;
	    }
    }
    
    public void insertItem(Item item)
    {
    	Pair<Item, Boolean> newpair = new Pair<Item, Boolean>(item, false);

		if (getAvailableSpace() > 0)
	    	items.add(newpair);
    }
    
    public void removeItem(String name)
    {
		int pos;
	
		for (pos=0; pos < items.size(); pos++)
	    {
			if(items.get(pos).getFirst().getName().equals(name))
			{
				items.remove(pos);
		    	break;
		    }
	    }
	
		
    }
    
    public void removeItem(int index)
    {
		if (index >= 0 && index < items.size())
	    	items.remove(index);
		else
	    	System.out.println ("Out of bounds! Choose an element between 0 and " + (items.size()-1));
    }
    
    /*Returns de defense points of the equiped items*/
    public int defPts()
    {
		int defense = 0;
	
		for (int i = 0; i < items.size(); i++)
			if (items.get(i).getSecond())
	    		defense = defense + items.get(i).getFirst().getDefensePts();
	
		return defense;
    }
    
    /*Returns de attack points of the equiped items*/
    public int attPts()
    {
		int attack = 0;
	
		for (int i = 0; i < items.size(); i++)
		{
			if (items.get(i).getSecond())
	    		attack = attack + items.get(i).getFirst().getAttackPts();
		}
		
		return attack;
    }

    public boolean equipItem(Item item, GameCharacter character)
    {

	  item = searchItem (item.getName());

	  //Verifying if the item exists in the inventory
	  if (item == null)
	  {
	    System.out.println ("Item doesn't exist!\n\n");
	    return false;
	   } 
	  if (!item.vocation.equals(character.getVocation()))
	  {
	  	System.out.println ("Item can only be properly wield by " + item.vocation + "!");
	  	return false;
	  }

	  if (item instanceof Armor)    //If the item to be equiped is an armor
	  {
	    if (equipedarmors < 1)  //There must be one or less armors equiped
	    {
	      for (int i=0; i < items.size(); i++)
	      {
	        if(items.get(i).getFirst().getName() == item.getName())
	        {
	          items.get(i).setSecond(true);
	          equipedarmors++;
	          return true;
	        }
	      }
	    }
	    else
	      System.out.println ("\nToo many armors equiped\n\n");
	  }

	  if (item instanceof Weapon)    //If the item to be equiped is a weapon
	  {
	    if (equipedweapons < 2)  //There must be two or less weapons equiped
	    {
	      for (int i=0; i < items.size(); i++)
	      {
	        if(items.get(i).getFirst().getName() == item.getName())
	        {
	          items.get(i).setSecond(true);
	          equipedweapons++;
	          return true;
	        }
	      }
	    }
	    else
	    	System.out.println ("\nToo many weapons equiped\n\n");
	  }

	  return false;
	}

	public void unequipItem (Item item)
	{
		for (int i = 0; i < items.size(); i++)
		{
			if (item.getName() == items.get(i).getFirst().getName() && items.get(i).getSecond() == true)				
			{
				items.get(i).setSecond(false);

				if (item instanceof Armor)
					equipedarmors--;

				if (item instanceof Weapon)
					equipedweapons--;
			}
		}
	}
}