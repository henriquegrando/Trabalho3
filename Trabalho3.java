import java.util.*;

public class Trabalho3
{
 public static void main (String args []) throws InterruptedException
 {
  /* Loading Characters*/

  Wizard ch1 = new Wizard ("Gandalf", 200);
  Knight ch2 = new Knight ("Aragorn", 80);
  Thief ch3 = new Thief ("Bilbo", 80);
  Knight ch4 = new Knight ("Boromir", 60);

  Wizard ch5 = new Wizard ("Saruman", 90);
  Knight ch6 = new Knight ("Orc Lord", 70);
  Knight ch7 = new Knight ("Orc Warrior", 60);
  Knight ch8 = new Knight ("Orc Soldier", 50);

  /* Making the Teams */

  Team t1 = new Team ("THE RING SOCIETY", Color.green);
  Team t2 = new Team ("SAURONS ARMY", Color.red);

  t1.addChar(ch1);
  t1.addChar(ch2);
  t1.addChar(ch3);
  t1.addChar(ch4);

  t2.addChar(ch5);
  t2.addChar(ch6);
  t2.addChar(ch7);
  t2.addChar(ch8);
  
  //Uncomment the part below to see
  //the Characters' attributes
  
   //System.out.println (t1.getName());
   //System.out.println (ch1.getStatus());
   //System.out.println (ch2.getStatus());
   //System.out.println (ch3.getStatus());
   //System.out.println (ch4.getStatus() + "\n");

   //System.out.println (t2.getName());
   //System.out.println (ch5.getStatus());
   //System.out.println (ch6.getStatus());
   //System.out.println (ch7.getStatus());
   //System.out.println (ch8.getStatus());
  
  /* Loading Battle Field */
  int scenario = GameCharacter.rnd(0,2);
  
  if (scenario == 0)
  {
  	ArrayList<City> city = new ArrayList<City> ();
  	
  	city.add(ch1);
  	city.add(ch3);
  	city.add(ch5);
  	
  	for (int i = 0; i < city.size(); i++)
  	{
  		city.get(i).activeCity();
  	}
  }
  
  if (scenario == 1)
  {
  	ArrayList<Forest> forest = new ArrayList<Forest> ();
  	
  	forest.add(ch2);
  	forest.add(ch3);
  	forest.add(ch4);
  	forest.add(ch6);
  	forest.add(ch7);
  	forest.add(ch8);
  	
  	for (int i = 0; i < forest.size(); i++)
  	{
  		forest.get(i).activeForest();
  	}
  }
  
  if (scenario == 2)
  {
  	ArrayList<Desert> desert = new ArrayList<Desert> ();
  	
  	desert.add(ch1);
  	desert.add(ch2);
  	desert.add(ch4);
  	desert.add(ch5);
  	desert.add(ch6);
  	desert.add(ch7);
  	desert.add(ch8);
  	
  	for (int i = 0; i < desert.size(); i++)
  	{
  		desert.get(i).activeDesert();
  	}
  }

  //Uncomment the part below to see
  //the Characters' attributes
  
   //System.out.println (t1.getName());
   //System.out.println (ch1.getStatus());
   //System.out.println (ch2.getStatus());
   //System.out.println (ch3.getStatus());
   //System.out.println (ch4.getStatus() + "\n");

   //System.out.println (t2.getName());
   //System.out.println (ch5.getStatus());
   //System.out.println (ch6.getStatus());
   //System.out.println (ch7.getStatus());
   //System.out.println (ch8.getStatus());

  /* Equiping Armors */

  Robe armor1 = new Robe ("Robe of the Light", 100.0, 7, 5.8);
  Mail armor2 = new Mail ("Set of the King", 300.0, 18, 15.0);
  Cape armor3 = new Cape ("Dragon Scale Mail", 500.0, 15, 4.0);
  Mail armor4 = new Mail ("Valkirias Armor", 150.0, 16, 15.0);
  Robe armor5 = new Robe ("Robe of the Dark", 200.0, 9, 6.3);
  Mail armor6 = new Mail ("Heavy Armor", 100.0, 10, 19.8);
  
  ch1.insertItem (armor1);
  ch2.insertItem (armor2);
  ch3.insertItem (armor3);
  ch4.insertItem (armor4);
  ch5.insertItem (armor5);
  ch6.insertItem (armor6);

  ch1.equipItem (armor1);
  ch2.equipItem (armor2);
  ch3.equipItem (armor3);
  ch4.equipItem (armor4);
  ch5.equipItem (armor5);
  ch6.equipItem (armor6);

  /* Equiping Weapons */

  Wand weapon1 = new Wand ("Staff of the Light", 400.0, 9, 0.0);
  Wand weapon2 = new Wand ("Wand of the Light", 400.0, 9, 0.0);
  Sword weapon3 = new Sword ("Ancient Kings Sword", 300.0, 8, 0.0);
  Dagger weapon4 = new Dagger ("Royal Dagger", 250.0, 6, 0.0);
  Sword weapon5 = new Sword ("Great Sword", 250.0, 7, 0.0);
  Wand weapon6 = new Wand ("Staff of the Dark", 350.0, 8, 0.0);
  Wand weapon7 = new Wand ("Wand of the Dark", 350.0, 7, 0.0);
  Sword weapon8 = new Sword ("Giant Sword", 250.0, 6, 0.0);
  Sword weapon9 = new Sword ("Curved Sword", 200.0, 5, 0.0);
  Sword weapon10 = new Sword ("Orc Sword", 150, 4, 0.0);

  ch1.insertItem (weapon1);
  ch1.insertItem (weapon2);
  ch2.insertItem (weapon3);
  ch3.insertItem (weapon4);
  ch4.insertItem (weapon5);
  ch5.insertItem (weapon6);
  ch5.insertItem (weapon7);
  ch6.insertItem (weapon8);
  ch7.insertItem (weapon9);
  ch8.insertItem (weapon10);

  ch1.equipItem (weapon1);
  ch1.equipItem (weapon2);
  ch2.equipItem (weapon3);
  ch3.equipItem (weapon4);
  ch4.equipItem (weapon5);
  ch5.equipItem (weapon6);
  ch5.equipItem (weapon7);
  ch6.equipItem (weapon8);
  ch7.equipItem (weapon9);
  ch8.equipItem (weapon10);

  /* Equiping Potions */

  HealthPotion hp1 = new HealthPotion ("Small Health Potion", 15.0, 10);
  HealthPotion hp2 = new HealthPotion ("Small Health Potion", 15.0, 10);
  HealthPotion hp3 = new HealthPotion ("Small Health Potion", 15.0, 10);
  HealthPotion hp4 = new HealthPotion ("Small Health Potion", 15.0, 10);
  HealthPotion hp5 = new HealthPotion ("Small Health Potion", 15.0, 10);

  ManaPotion mp1 = new ManaPotion ("Small Mana Potion", 20.0, 15);
  ManaPotion mp2 = new ManaPotion ("Small Mana Potion", 20.0, 15);
  ManaPotion mp3 = new ManaPotion ("Small Mana Potion", 20.0, 15);

  ch1.insertItem (hp1);
  ch2.insertItem (hp2);
  ch3.insertItem (hp3);
  ch4.insertItem (hp4);
  ch5.insertItem (hp5);

  ch1.insertItem (mp1);
  ch2.insertItem (mp2);
  ch3.insertItem (mp3);

  /* Preparing for Battle */

  ch1.addXP(10);
  ch2.addXP(9);
  ch3.addXP(7);
  ch4.addXP(8);

  ch5.addXP(10);
  ch6.addXP(7);
  ch7.addXP(6);
  ch8.addXP(5);

  //Uncomment the part below to see
  //the Characters' attributes
  
   //System.out.println (t1.getName());
   //System.out.println (ch1.getStatus());
   //System.out.println (ch2.getStatus());
   //System.out.println (ch3.getStatus());
   //System.out.println (ch4.getStatus() + "\n");

   //System.out.println (t2.getName());
   //System.out.println (ch5.getStatus());
   //System.out.println (ch6.getStatus());
   //System.out.println (ch7.getStatus());
   //System.out.println (ch8.getStatus());
  
  /* Setting fight 1 */
  
  int choose1 = GameCharacter.rnd(0,3);
  int choose2 = GameCharacter.rnd(0,3);

  Fight fight1 = new Fight (t1.searchChar(choose1), t2.searchChar(choose2));
  
  t1.setAvailable (choose1, false);
  t2.setAvailable (choose2, false);
  
  System.out.println ("Fight 1:\n" + t1.searchChar(choose1).getName() + " X " + t2.searchChar(choose2).getName() + "\n");
  
  /* Setting fight 2 */
  
  do
  {
  	choose1 = GameCharacter.rnd(0,3);
  }while (!t1.getAvailable(choose1));
  
  do
  {
  	choose2 = GameCharacter.rnd(0,3);
  }while (!t2.getAvailable(choose2));
  
  Fight fight2 = new Fight (t1.searchChar(choose1), t2.searchChar(choose2));
  
  t1.setAvailable (choose1, false);
  t2.setAvailable (choose2, false);
  
  System.out.println ("Fight 2:\n" + t1.searchChar(choose1).getName() + " X " + t2.searchChar(choose2).getName() + "\n");
  
  /* Setting fight 3 */
  
  do
  {
  	choose1 = GameCharacter.rnd(0,3);
  }while (!t1.getAvailable(choose1));
  
  do
  {
  	choose2 = GameCharacter.rnd(0,3);
  }while (!t2.getAvailable(choose2));
  
  Fight fight3 = new Fight (t1.searchChar(choose1), t2.searchChar(choose2));
  
  t1.setAvailable (choose1, false);
  t2.setAvailable (choose2, false);
  
  System.out.println ("Fight 3:\n" + t1.searchChar(choose1).getName() + " X " + t2.searchChar(choose2).getName() + "\n");
  
  /* Setting fight 4 */
  
  int i = 0;
  
  while (!t1.getAvailable(i))
  	i++;
  
  choose1 = i;
  
  i = 0;
  
  while (!t2.getAvailable(i))
  	i++;
  	
  choose2 = i;
  
  Fight fight4 = new Fight (t1.searchChar(choose1), t2.searchChar(choose2));
  
  t1.setAvailable (choose1, false);
  t2.setAvailable (choose2, false);
  
  System.out.println ("Fight 4:\n" + t1.searchChar(choose1).getName() + " X " + t2.searchChar(choose2).getName() + "\n");
  
  System.out.println ("The fight is about to begin!\n");
  
  /* Starting fights */
  
  fight1.start();
  fight2.start();
  fight3.start();
  fight4.start();
  
  fight1.join();
  fight2.join();
  fight3.join();
  fight4.join();
  

	  /* Resolve Battle */

	  t1.resolveBattle (t2);
	  t2.resolveBattle (t1);

	  System.out.println ("\n\n" + t1.getName() + "\n" + t1.getResults() + "\n");
	  System.out.println ("\n" + t2.getName() + "\n" + t2.getResults() + "\n");
	}
}