import java.util.*;

public class Team
{

	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private ArrayList<GameCharacter> characters;
	private ArrayList<Boolean> available;				//Determines if the respective character is available for a fight
	
	public Team(String name, Color color)
	{
		this.name = name;
		this.color = color;
		win = 0;
		lose = 0;
		draw = 0;
		characters = new ArrayList<GameCharacter>();
		available = new ArrayList<Boolean> ();
	}

	public void clearTeam ()
	{
		characters.clear();
	}

	public String getName()
	{
		return name;
	}
	
	/* Returns the available status of the character */
	public Boolean getAvailable (int index)
	{
		return available.get(index);
	}
	
	/* Set the available status of the character */
	public void setAvailable (int index, Boolean bool)
	{
		available.set(index, bool);
	}

	/*Return a string containing the number of wins, loses and draws*/
	public String getResults()
	{
		String results;

		results = "Wins: " + this.win + "\nLoses: " + this.lose
				+ "\nDraws: " + this.draw + "\n";

		return results;
	}

	public String toString()
	{
		String x;

		x = "Time " + color + ": " + name + "\n";

		return x;
	}

	/*Based on the points of each team, updates the score*/
	public void resolveBattle(Team enemy)
	{
		if (this.getPoints() > enemy.getPoints())
			this.win++;
		else if (this.getPoints() < enemy.getPoints())
			this.lose++;
		else
			this.draw++;
	}

	public void addChar (GameCharacter partner)
	{
		characters.add(partner);
		available.add(true);
	}

	public void removeChar (int index)
	{
		characters.remove (index);
		available.remove (index);
	}

	public void removeChar (GameCharacter partner)
	{
		characters.remove (partner);
	}

	public GameCharacter searchChar (String alias)
	{
		for (int i = 0; i < characters.size(); i++)
		{
			if (characters.get(i).getName() == alias)
				return characters.get(i);
		}

		return null;
	}

	public GameCharacter searchChar (int index)
	{
		return characters.get(index);
	}

	/*Returns the points based on the HP ammount*/
	public int getPoints ()
	{
		int sum = 0;

		for (int i = 0; i < characters.size(); i++)
		{
			sum = sum + characters.get(i).getHP();
		}

		return (sum/characters.size());
	}
}