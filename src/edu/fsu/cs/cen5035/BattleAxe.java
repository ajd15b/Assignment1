package edu.fsu.cs.cen5035;
import java.util.concurrent.ThreadLocalRandom;

//battle axe has 30 hitpoints with a 35% chance of ignoring all armor
//i.e. battle axe finds a chink in the armor
public class BattleAxe extends BasicWeapon implements Weapon
{
	public BattleAxe()
	{
		super(30);
	}
	
	public int hit()
	{
		return DAMAGE;
	}
	
	public int hit(int armor)
	{
		int random_number = ThreadLocalRandom.current().nextInt(1, 100);
		int damage;
		
		//if the random number hits anywhere between 1-35 (35% of all number from 1-100)
		//armor is ignored
		if(random_number < 36)
		{
			damage = DAMAGE;
		}
		else
		{
			damage = DAMAGE - armor;
		}
		
		if(damage < 0)
		{
			return 0;
		}
		
		return damage;
		
	}
}