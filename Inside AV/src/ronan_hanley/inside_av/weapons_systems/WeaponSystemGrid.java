package ronan_hanley.inside_av.weapons_systems;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import ronan_hanley.inside_av.enemy.Enemy;

public class WeaponSystemGrid {
	private WeaponSystem[][] grid;
	private ArrayList<WeaponSystem> weaponSystems;
	
	public WeaponSystemGrid(int width, int height) {
		grid = new WeaponSystem[height][width];
		weaponSystems = new ArrayList<WeaponSystem>();
	}
	
	public ArrayList<WeaponSystem> getWeapons() {
		return weaponSystems;
	}
	
	public void addWeaponSystem(WeaponSystem weapon, int x, int y) {
		grid[y][x] = weapon;
		weaponSystems.add(weapon);
	}
	
	public boolean tileHasWeapon(int x, int y) {
		return (grid[y][x] != null);
	}
	
	public void updateAll(ArrayList<Enemy> enemies) {
		for (WeaponSystem weapon : weaponSystems)
			weapon.update(enemies);
	}
	
	public void renderAll(Graphics g) {
		for (WeaponSystem weapon : weaponSystems)
			weapon.render(g);
	}
	
}
