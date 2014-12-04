
import Items.*;
import java.util.*;

public class Trabalho2
{
 public static void main (String args [])
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

  /* Equiping Armors */

  Armor armor1 = new Armor ("Robe of the Light", 100.0, 7, 5.8);
  Armor armor2 = new Armor ("Set of the King", 300.0, 18, 15.0);
  Armor armor3 = new Armor ("Dragon Scale Mail", 500.0, 15, 4.0);
  Armor armor4 = new Armor ("Valkirias Armor", 150.0, 16, 15.0);
  Armor armor5 = new Armor ("Robe of the Dark", 200.0, 9, 6.3);
  Armor armor6 = new Armor ("Heavy Armor", 100.0, 10, 19.8);
  
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

  Weapon weapon1 = new Weapon ("Staff of the Light", 400.0, 9, 0.0);
  Weapon weapon2 = new Weapon ("Wand of the Light", 400.0, 9, 0.0);
  Weapon weapon3 = new Weapon ("Ancient Kings Sword", 300.0, 8, 0.0);
  Weapon weapon4 = new Weapon ("Royal Dagger", 250.0, 6, 0.0);
  Weapon weapon5 = new Weapon ("Great Sword", 250.0, 7, 0.0);
  Weapon weapon6 = new Weapon ("Staff of the Dark", 350.0, 8, 0.0);
  Weapon weapon7 = new Weapon ("Wand of the Dark", 350.0, 7, 0.0);
  Weapon weapon8 = new Weapon ("Giant Sword", 250.0, 6, 0.0);
  Weapon weapon9 = new Weapon ("Curved Sword", 200.0, 5, 0.0);
  Weapon weapon10 = new Weapon ("Orc Sword", 150, 4, 0.0);

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
  
  /* Fight */

  ArrayList<Boolean> chteam1 = new ArrayList<Boolean>();   //controls the characters that
  ArrayList<Boolean> chteam2 = new ArrayList<Boolean>();   //have already attacked on this turn

  chteam1.add (false); //ch1
  chteam1.add (false); //ch2
  chteam1.add (false); //ch3
  chteam1.add (false); //ch4
  
  chteam2.add (false); //ch5
  chteam2.add (false); //ch6
  chteam2.add (false); //ch7
  chteam2.add (false); //ch8

  Character attacker;
  Character defender;

  for (int i = 0; i < 4; i++)   // 1 round == 8 attacks
  {
    /* Team 1 attacks */

    int choose = Character.rnd (0,3);

    int topbottom = 0; //flag that tell to increase or decrease the position

    while (chteam1.get(choose))
    {
      if (choose+1 >= (int) chteam1.size())
      {
        topbottom = 1;      //top reached
        choose--;
        continue;
      }
      else if (choose-1 < 0)
      {
        topbottom = 0;      //bottom reached
        choose++;
        continue;
      }
      else if (topbottom == 0)  //bottom reached, so
        choose++;               //increase
      else                      //top reached, so
        choose--;               //decrease
        
    }

    attacker = t1.searchChar (choose);

    chteam1.set(choose, true);     //Character already attacked

    choose = Character.rnd (0,3);

    defender = t2.searchChar (choose);

    attacker.attack(defender);


    /* Team 2 attacks */

    choose = Character.rnd (0,3);

    topbottom = 0;

    while (chteam2.get(choose))
    {
      if (choose+1 >= (int) chteam2.size())
      {
        topbottom = 1;      //top reached
        choose--;
        continue;
      }
      else if (choose-1 < 0)
      {
        topbottom = 0;      //bottom reached
        choose++;
        continue;
      }
      else if (topbottom == 0)  //bottom reached, so
        choose++;               //increase
      else                      //top reached, so
        choose--;               //decrease 
    }

    attacker = t2.searchChar (choose);

    chteam2.set(choose, true);     //Character already attacked

    choose = Character.rnd (0,3);

    defender = t1.searchChar (choose);

    attacker.attack(defender); 
}

	  /* Resolve Battle */

	  t1.resolveBattle (t2);
	  t2.resolveBattle (t1);

	  System.out.println ("\n\n" + t1.getName() + "\n" + t1.getResults() + "\n");
	  System.out.println ("\n" + t2.getName() + "\n" + t2.getResults() + "\n");
    }
}