package ronan_hanley.inside_av.weapons_systems;

import org.newdawn.slick.Image;

import ronan_hanley.inside_av.InsideAV;

public abstract class BulletWeaponSystem extends WeaponSystem {
	public static final double COST = 100;
	
	public BulletWeaponSystem(int x, int y, Image sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public double getCost() {
		return COST;
	}
	
	@Override
	public void fire() {
		// spawn a bullet
		addProjectile(new Bullet(getX() + (InsideAV.TILE_SIZE / 2) - 2, getY() + (InsideAV.TILE_SIZE / 2) - 2, getAngle(), getBulletSpeed()));
	}
	
	public abstract double getBulletSpeed();
	
}
