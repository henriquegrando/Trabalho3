
import Items.*;
import java.util.*;

public abstract class Character
{
    /*Attributes*/

    private String alias;
    private Inventory myitems;
    private int HP;
    private int MP;
    protected int XP;
    protected int strenght;
    protected int speed;
    protected int dexterity;
    protected int constitution;
    protected int speedarmor; //speed penality given by the armor

    /*Methods*/
   	
    /*Constructor*/
    public Character (String alias)
    {
	this.alias = alias;
	myitems = new Inventory();
	HP = 100;
	XP = 1;
	strenght = 25;
	speed = 25;
	dexterity = 25;
	constitution = 25;
	speedarmor = 0;
    }
    
    public String getName()
    {
	return alias;
    }

    protected int getDefensePoints()
    {
	return (int) ((constitution*0.5 + dexterity*0.3 + speed*0.2) + (myitems.defPts()))*(XP/2);
    }
    
    protected int getAttackPoints()
	{
	return (int) ((strenght*0.5 + dexterity*0.3 + speed*0.2) +(myitems.attPts()))*(XP/3);
    }

    public int getSpeed ()
    {
    	return speed - speedarmor;
    }
    
    public void addXP (int XP)
    {
	int sum = this.XP + XP;
	
	if (sum >= 0 && sum <= 100)
	    this.XP = sum;
	else if (sum > 100)
	    System.out.println ("Max XP reached!");
	else if (sum < 0)
	    System.out.println ("XP can't be below 0!");
    }
    
    public void setStrenght (int value)
    {
	if (value + speed + dexterity + constitution > 100)
	    System.out.println("Attribute points can't be above 100!");
	else
	    strenght = value;
    }
    
    public void setSpeed (int value)
    {
	if (strenght + value + dexterity + constitution > 100)
	    System.out.println("Attribute points can't be above 100!");
	else
	    speed = value;
    }

    public void setDexterity (int value)
    {
	if (strenght + speed + value + constitution > 100)
	    System.out.println("Attribute points can't be above 100!");
	else
	    dexterity = value;
    }
    
    public void setConstitution (int value)
    {
	if (strenght + speed + dexterity + value > 100)
	    System.out.println("Attribute points can't be above 100!");
	else
	    constitution = value;
    }

    public void setSpeedArmor (int value)
    {
    	this.speedarmor = value;
    }

    public void setSpaces (int value)
    {
    	myitems.setSpaces(value);
    }

    public void attack (Character target)
    {

    	int event = specialEvents();
	
		if (event == -1)          //Chances of missing
	    	{
				System.out.print ("MISS!\n");
				return;
	    	}
	
		int damage;
	
		damage = (int) ((getAttackPoints()) - (target.getDefensePoints())) + (rnd (-5,5));
		
		if (event == 1)           //Chances of critical hit
		    {
			System.out.println ("CRITICAL!");
			damage = damage * 2;
		    }
		
		if (damage < 0)
		    damage = 1;
		
		System.out.println (this.getName() + " attacks "
         + target.getName() + "\n" + "HIT: " + damage + "\n");
		
		damage = damage * -1;
		
		target.addHP(damage);                     /*The enemy takes the damage*/
	}

    public void addHP (int value)
    {
        if (HP + value <= 100)
	       HP = HP + value;
        else
            HP = 100;
    }

    public void addMP (int value)
    {
	MP = MP + value;
    }

    public int getHP()
    {
    	return this.HP;
    }

    public int getMP()
    {
    	return this.MP;
    }
    
    /*Calculate the chances of miss and critical*/
    protected int specialEvents ()
    {	
		int x = (int) (Math.random() * 1000) + 1;          /*Generates a random number between 1 and 1000*/
	
		if ( x >= 1 && x <= (100/XP))                      /*Represents a 0.1% to 10% chance*/
	    	return  -1;
	
		x = (int) (Math.random() * 100) + 1;               /*Generates a new random number between 1 and 100*/
	
		if ( x >= 1 && x <= XP)                            /*Represents a 1% to 100% chance*/
	    	return 1;

		return 0;
    }
    
    /*Returns an int in the given interval*/
    public static int rnd (int min, int max)
    {
		int random;
       	
		int x = max - min;            /*Taking the size of the interval*/
	
		if (x == 0)
	    	return max;
	
		random = (int) (Math.random() * x);          /*Generating a random number from 0 to the size of interval*/

		random = random + min;        /*Returning the interval to its previous range*/
	
		return random;
    }
    
    public void insertItem (Item item)
    {
		myitems.insertItem(item);
    }

    public void equipItem (Item item)
    {
    	boolean check = myitems.equipItem(item);

    	if ((item instanceof Armor) && (check)) //if equiping an armor
    	{
    		speedPenality(item);	//calculate the speed penality
    	}
    }

    /*Calculate the speed penality based on the armor weight*/
    public void speedPenality (Item item)
    {
   		Armor a = (Armor) item;

        double w = a.getWeight();

   		speedarmor = getSpeed() - (int) (getSpeed() * Math.exp((-1)*(Math.pow((w/20), 2))));
    }

    public void unequipItem (Item item)
    {
    	myitems.unequipItem(item);

    	if (item instanceof Armor) //if unequiping the armor
    	{
    		speedarmor = 0;       //penality = 0
    	}
    }

    //Return the characters attributes
	public String getStatus ()
	{
	  String status;

	  status = "\n" + this.getName() + "\n"
	         + "\n\tHealth Points: " + this.getHP()
	         + "\n\tMana Points: " + this.getMP()
	         + "\n\tAttack: " + this.getAttackPoints()
	         + "\n\tDefense: " + this.getDefensePoints()
	         + "\n\tSpeed: " + this.getSpeed() + "\n";

	  return status;
	}   
}
