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
	
	public void run ()
	{
		do
		{			
			ch1.attack(ch2);
			ch2.attack(ch1);
			
			rounds++;

			if (ch1.getHP() <= 0)
			{
				end = true;
				System.out.println ("Fight " + this.id + " finished with " + rounds + " rounds!!\n" + ch2.getName() + " WINS!!\n");
			}
			
			if (ch2.getHP() <= 0)
			{
				end = true;
				System.out.println ("Fight " + this.id + " finished with " + rounds + " rounds!!\n" + ch1.getName() + " WINS!!\n");
			}
			
									
		}while (!end);
	}
}