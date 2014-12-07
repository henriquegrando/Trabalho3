/* Pair implemented using generics, attributes can be of any class type*/
public class Pair <F, S>
{
	private F first;
	private S second;
	
	public Pair (F first, S second)
	{
		this.first = first;
		this.second = second;
	}
	
	/* Generic getters */
	public F getFirst ()
	{
		return this.first;
	}
	
	public S getSecond ()
	{
		return this.second;
	}
	
	/* Generic setters */
	public void setFirst (F first)
	{
		this.first = first;
	}
	
	public void setSecond (S second)
	{
		this.second = second;
	}
}