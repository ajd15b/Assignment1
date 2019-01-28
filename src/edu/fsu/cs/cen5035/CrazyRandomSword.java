package edu.fsu.cs.cen5035;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Alex
 *
**/

public class CrazyRandomSword extends BasicWeapon implements Weapon
{
	
	public CrazyRandomSword()
	{
		//set damage to a random number between 4 and 99
		super(ThreadLocalRandom.current().nextInt(4, 99));
	}
	
	@Override
	public int hit()
	{
		return DAMAGE;
	}
	
	@Override
	public int hit(int armor)
	{
		int damage;
		//armor ignore is a random number between 3 and 1/3 of armor
		int armor_ignore = ThreadLocalRandom.current().nextInt(3, ((1/3) * armor));
		//subtract the ignored armor from equation
		armor = armor - armor_ignore;
		
		if(armor < 0)
		{
			armor = 0;
		}
		
		damage = DAMAGE - armor;
		
		if(damage < 0)
		{
			damage = 0;
		}
		
		return damage;
	}
}