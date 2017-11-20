package ronan_hanley.inside_av;

import ronan_hanley.inside_av.enemy.Enemy;

public class Explosion extends Entity{
	private double maxDamage;
	private double exponent;
	
	/**
	 * Creates an explosion using two values.
	 * @param maxDamage The damage taken at the exact center
	 * of the explosion.
	 * @param radius The redius of the explosion. Zero damage
	 * will be taken at a distance of radius from the explosion.
	 */
	public Explosion(int x, int y, int maxDamage, int radius) {
		super(x, y);
		this.maxDamage = maxDamage;
		/* Convert the given radius to something we can use in our
		 * formula (damage = -distance^exponent + maxDamage)
		 * 
		 * d = log(base = radius, m)
		 */
		exponent = logOfBase(radius, maxDamage);
	}
	
	/**
	 * Damages an enemy based off this explosion.
	 * @param enemy The enemy to damage.
	 */
	public void damageEnemy(Enemy enemy) {
		/* First find the distance from the center of the explosion
		 * to the enemy 
		 */
		double distance = Math.sqrt(Math.pow(getXExact() - enemy.getXExact(), 2)
								  + Math.pow(getYExact() - enemy.getYExact(), 2));
		
		// System.out.println("DAMAGE: " + getDamageForDistance(distance));
		enemy.applyDamage((int) getDamageForDistance(distance));
	}
	
	public double getDamageForDistance(double distance) {
		// apply formula (damage = -distance^exponent + maxDamage)
		double damage =  -(Math.pow(distance, exponent)) + maxDamage;
		
		return Math.max(damage, 0);
	}
	
	/**
	 * This method taken from:
	 * http://blog.dreasgrech.com/2010/02/finding-logarithm-of-any-base-in-java.html
	 */
	public static double logOfBase(int base, int num) {
	    return Math.log(num) / Math.log(base);
	}
	
}