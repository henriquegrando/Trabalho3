import java.util.*;

public class Team
{

	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private ArrayList<Character> characters;

	public Team(String name, Color color)
	{
		this.name = name;
		this.color = color;
		win = 0;
		lose = 0;
		draw = 0;
		characters = new ArrayList<Character>();
	}

	public void clearTeam ()
	{
		characters.clear();
	}

	public String getName()
	{
		return name;
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

	public void addChar (Character partner)
	{
		characters.add(partner);
	}

	public void removeChar (int index)
	{
		characters.remove (index);
	}

	public void removeChar (Character partner)
	{
		characters.remove (partner);
	}

	public Character searchChar (String alias)
	{
		for (int i = 0; i < characters.size(); i++)
		{
			if (characters.get(i).getName() == alias)
				return characters.get(i);
		}

		return null;
	}

	public Character searchChar (int index)
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