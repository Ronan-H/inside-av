package ronan_hanley.inside_av.weapons_systems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import ronan_hanley.inside_av.Entity;
import ronan_hanley.inside_av.InsideAV;
import ronan_hanley.inside_av.enemy.Enemy;

/**
 * Represents something that is fired from a weapon.
 * Probably travels across the screen until it hits an
 * enemy.
 * @author Ronan
 *
 */
public abstract class Projectile extends Entity {
	private double angle;
	private double speed;
	private Image sprite;
	
	public Projectile(int x, int y, double angle, double speed, Image sprite) {
		super(x, y);
		setAngle(angle);
		setSpeed(speed);
		
		this.sprite = sprite;
	}
	
	public void update() {
		/* use some trigonometry to break an angle and a speed up
		 * into it's component parts
		 */
		changeX(Math.cos(getAngle()) * getSpeed());
		changeY(Math.sin(getAngle()) * getSpeed());
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, getX(), getY());
	}
	
	public boolean touchingEnemy(Enemy enemy) {
		/* Simplifying an enemy to be a circle. This is drastically faster
		 * than pixel perfect collision detection, as we simply check if the distance
		 * is less than the radius of the circle.
		 * 
		 * The circle's diameter is 1 game tile long.
		 */
		
		int halfWidth = sprite.getWidth() / 2;
		int halfHeight = sprite.getHeight() / 2;
		int halfTileSize = InsideAV.TILE_SIZE / 2;
		
		// pythagorean theorem for distance
		int distance = (int) Math.sqrt(
			Math.pow((getXExact() + halfWidth) - (enemy.getXExact() + halfTileSize), 2)
		  + Math.pow((getYExact() + halfHeight) - (enemy.getYExact() + halfTileSize), 2));
		
		boolean colliding = (distance < halfTileSize + halfHeight);
		
		return colliding;
	}
	
	public abstract int getDamage();
	
}
