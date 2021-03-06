import java.util.*;

public abstract class GameCharacter
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
    protected int speedarmor; 		//speed penality given by the armor
    protected Vocation vocation;	//vocation of the respective character

    /*Methods*/
   	
    /*Constructor*/
    public GameCharacter (String alias)
    {
		this.alias = alias;
		myitems = new Inventory();
		HP = 100;
		MP = 0;
		XP = 1;
		strenght = 15;
		speed = 15;
		dexterity = 15;
		constitution = 15;
		speedarmor = 0;
    }
    
    public Vocation getVocation ()
    {
    	return vocation;
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
    	if (value > 97)
    	{
    		System.out.println ("Can't set an attribute above this point");
    		return;
    	}
    		
		if (value + speed + dexterity + constitution > 100)
		{
			int above = (value+speed+dexterity+constitution) - 100;		// Calculate the points above 100
			int penality = above / 3;									// Penality to each of the other attributes
			int leftPenality = above%3;
			
			/* Applying penalities */
			if (speed - (penality+leftPenality) > 0)
    		{
    			setSpeed (speed-(penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
    		{
    			setSpeed (1);
	    		leftPenality = 1 - (speed-(penality+leftPenality));
    		}
    	
    		if (dexterity - (penality+leftPenality) > 0)
    		{
    			setDexterity (dexterity - (penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
	    	{
    			setDexterity (1);
    			leftPenality = 1 - (dexterity - (penality+leftPenality));
	    	}	
    	
    		setConstitution (constitution - (penality+leftPenality));
			
			strenght = value;
		}
		
		else
		    strenght = value;
    }
    
    public void setSpeed (int value)
    {
		if (value > 97)
    	{
    		System.out.println ("Can't set an attribute above this point");
    		return;
    	}
    		
		if (strenght + value + dexterity + constitution > 100)
		{
			int above = (strenght+value+dexterity+constitution) - 100;		// Calculate the points above 100
			int penality = above / 3;										// Penality to each of the other attributes
		    int leftPenality = above%3;
			
			/* Applying penalities */
			if (strenght - (penality+leftPenality) > 0)
    		{
    			setStrenght (strenght-(penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
    		{
    			setStrenght (1);
	    		leftPenality = 1 - (strenght-(penality+leftPenality));
    		}
    	
    		if (dexterity - (penality+leftPenality) > 0)
    		{
    			setDexterity (dexterity - (penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
	    	{
    			setDexterity (1);
    			leftPenality = 1 - (dexterity - (penality+leftPenality));
	    	}	
    	
    		setConstitution (constitution - (penality+leftPenality));
			
			speed = value;
		}
		
		else
		    speed = value;
    }

    public void setDexterity (int value)
    {
		if (value > 97)
    	{
    		System.out.println ("Can't set an attribute above this point");
    		return;
    	}
    		
		if (strenght + speed + value + constitution > 100)
		{
			int above = (strenght+speed+value+constitution) - 100;		// Calculate the points above 100
			int penality = above / 3;									// Penality to each of the other attributes
			int leftPenality = above%3;
			
			/* Applying penalities */
			if (strenght - (penality+leftPenality) > 0)
    		{
    			setStrenght (strenght-(penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
    		{
    			setStrenght (1);
	    		leftPenality = 1 - (strenght-(penality+leftPenality));
    		}
    	
    		if (speed - (penality+leftPenality) > 0)
    		{
    			setSpeed (speed - (penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
	    	{
    			setSpeed (1);
    			leftPenality = 1 - (speed - (penality+leftPenality));
	    	}	
    	
    		setConstitution (constitution - (penality+leftPenality));
			
			dexterity = value;
		}
		
		else
		    dexterity = value;
	}
    
    public void setConstitution (int value)
    {
		if (value > 97)
    	{
    		System.out.println ("Can't set an attribute above this point");
    		return;
    	}
    		
		if (strenght + speed + dexterity + value > 100)
		{
			int above = (strenght+speed+dexterity+value) - 100;		// Calculate the points above 100
			int penality = above / 3;									// Penality to each of the other attributes
		    int leftPenality = above%3;
			
			/* Applying penalities */
			if (strenght - (penality+leftPenality) > 0)
    		{
    			setStrenght (strenght-(penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
    		{
    			setStrenght (1);
	    		leftPenality = 1 - (strenght-(penality+leftPenality));
    		}
    	
    		if (speed - (penality+leftPenality) > 0)
    		{
    			setSpeed (speed - (penality+leftPenality));
	    		leftPenality = 0;
    		}
    		else
	    	{
    			setSpeed (1);
    			leftPenality = 1 - (speed - (penality+leftPenality));
	    	}	
    	
    		setDexterity (dexterity - (penality+leftPenality));
			
			constitution = value;
		}
		
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

    public void attack (GameCharacter target)
    {

    	int event = specialEvents();
	
		if (event == -1)          //Chances of missing
	    	{
				System.out.print ("MISS!\n");
				return;
	    	}
	
		int damage;
	
		damage = (int) ((getAttackPoints()) - (target.getDefensePoints()/3)) + (rnd (-5,5));
		
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
		if (MP+ value <= 100)
	       MP = MP + value;
        else
        	MP = 100;
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
    	boolean check = myitems.equipItem(item, this);

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
