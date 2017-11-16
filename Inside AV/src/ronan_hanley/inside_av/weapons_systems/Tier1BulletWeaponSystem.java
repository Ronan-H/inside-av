package ronan_hanley.inside_av.weapons_systems;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public final class Tier1BulletWeaponSystem extends BulletWeaponSystem {
	public static final Image SPRITE;
	
	static {
		Image sprite = null;
		try {
			sprite = new Image("res/images/weapons/bullet/tier1.png", false, Image.FILTER_NEAREST);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		SPRITE = sprite;
	}
	
	public Tier1BulletWeaponSystem(int x, int y) {
		super(x, y, SPRITE);
	}
	
	public int getFireInterval() {
		return 10;
	}

	@Override
	public double getBulletSpeed() {
		return 3;
	}
	
}
