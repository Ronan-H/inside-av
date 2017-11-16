package ronan_hanley.inside_av.enemy;

import org.newdawn.slick.Image;

import ronan_hanley.inside_av.DrawableEntity;
import ronan_hanley.inside_av.InsideAV;
import ronan_hanley.inside_av.LevelRoute;
import ronan_hanley.inside_av.LevelRouteInstruction;

public abstract class Enemy extends DrawableEntity {
	private int maxHealth;
	private int health;
	private double speed;
	private LevelRoute route;
	private int direction;
	private int instructionIndex;
	
	public Enemy(int x, int y, double speed, int maxHealth, Image sprite, LevelRoute route) {
		super(x, y, sprite);
		this.speed = speed;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.route = route;
		direction = 1;
		instructionIndex = 0;
	}
	
	/**
	 * 
	 * @return True if the enemy has reached the end point
	 */
	public boolean update() {
		// update position, based on direction and speed
		int[][] offsets = LevelRoute.OFFSETS;
		changeX(speed * offsets[direction][0]);
		changeY(speed * offsets[direction][1]);
		
		// change direction, if it's necessary
		// check if we've reached the target location
		LevelRouteInstruction[] instructions = route.getInstructions();
		LevelRouteInstruction currentInstruction = instructions[instructionIndex];
		
		if (currentInstruction.hasReachedTarget(this)) {
			if (instructionIndex == instructions.length - 1) {
				// instructions finished, this enemy has reached the end point
				return true;
			} else {
				// remove any overshoot
				if (direction == 1 || direction == 3)
					setTileX(currentInstruction.getTargetTileX());
				else
					setTileY(currentInstruction.getTargetTileY());
				
				// go to next instruction, and change direction
				++instructionIndex;
				currentInstruction = instructions[instructionIndex];
				direction = currentInstruction.getDirection();
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return How much damage this enemy will apply to the system if it reaches
	 * the end point
	 */
	public abstract double getSystemDamage();
	
	/**
	 * Reduces the health of this enemy by a specified amount
	 * @param damage Amount to reduce the health by
	 * @return True if this enemy died as a result of the damage applied
	 */
	public boolean applyDamage(int damage) {
		health -= damage;
		
		return (health < 0);
	}
	
}
