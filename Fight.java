public class Fight extends Thread 
{
	private int rounds = 0;
	private static int count = 0;
	private int id;
	private GameCharacter ch1;
	private GameCharacter ch2;
	private boolean end = false;
	private String description;
	
	public Fight (GameCharacter ch1, GameCharacter ch2)
	{
		rounds = 0;
		count ++;
		this.id = count;
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.description = "Fight " + this.id;
	}
	
	/* Two characters fight against each other, if one of them dies, the battle ends */
	@Override
	public void run ()
	{
		do
		{	
			rounds++;
				
			ch1.attack(ch2);
			
			if (ch2.getHP() <= 0)
			{
				end = true;
				System.out.println ("Fight " + this.id + " finished with " + rounds + " rounds!!\n" + ch1.getName() + " WINS!!\n");
				continue;			// ch2 can't attack ch1 anymore
			}
			
			ch2.attack(ch1);

			if (ch1.getHP() <= 0)
			{
				end = true;
				System.out.println ("Fight " + this.id + " finished with " + rounds + " rounds!!\n" + ch2.getName() + " WINS!!\n");
			}
			
			
			
									
		}while (!end);
	}
}