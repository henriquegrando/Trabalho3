public class Power extends Thread
{
	private GameCharacter ch1;
	private GameCharacter ch2;
	private Team t1;
	private Team t2;
	private boolean end = true;
	
	public Power (GameCharacter ch1, GameCharacter ch2, Team t1, Team t2) throws InterruptedException
	{
		super ();
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.t1 = t1;
		this.t2 = t2;
	}
	
	/* Sums 50 points to the MP of each wizard at every loop, if the MP turns to 100
	execute the power, dealing -25 points to each enemy's HP */
	@Override
	public void run ()
	{
		while (end)
		{						
		 	synchronized(this)					// After the check of the character's HP above 0
		 	{									// He can't suffer any other attack
				if (ch1.getHP() >= 0)			// So this procedure is synchronized
				{
					ch1.addMP(50);
			
					if (ch1.getMP() >= 100)
					{
						ch1.addMP (-100);
				
						for (int i = 0; i < 4; i++)
						{
							t2.searchChar(i).addHP(-25);
						}
					
						System.out.println (ch1.getName() + " STRIKES !!\n");
					}
				}
			}
		
			synchronized(this)			// After the check of the character's HP above 0
			{							// He can't suffer any other attack
				if (ch2.getHP() >= 0)	// So this procedure is synchronized
				{
					ch2.addMP(50);
				
					if (ch2.getMP() >= 100)
					{
						ch2.addMP (-100);
				
						for (int i = 0; i < 4; i++)
						{
							t1.searchChar(i).addHP(-25);
						}
					
						System.out.println (ch2.getName() + " STRIKES !!\n");
					}
				}
			}
			
			try 
			{
				this.sleep (1);			// Cooldown time
			}
			catch(InterruptedException x){}
		}
	}
	
	@Override
	public void interrupt ()
	{
		end = false;
	}
		
}
				
		