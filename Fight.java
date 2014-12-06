public class Fight extends Thread 
{
	private Thread T;
	private int rounds;
	private static int id = 0;
	private GameCharacter ch1;
	private GameCharacter ch2;
	private boolean end = false;
	private String description;
	
	public Fight (GameCharacter ch1, GameCharacter ch2)
	{
		rounds = 0;
		id += 1;
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.description = "Fight " + this.id;
		
	}
	
	public void run ()
	{
		do
		{			
			ch1.attack(ch2);
			ch2.attack(ch1);

			if (ch1.getHP() <= 0 || ch2.getHP() <= 0)
				end = true;
									
		}while (!end);
	}
	
	public void start ()
	{
		T = new Thread(this, description);
		T.start();
	}
}