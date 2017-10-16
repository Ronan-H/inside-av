package ronan_hanley.inside_av;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Represents the route the enemies will take
 * in the level
 * @author Ronan
 */
public class LevelRoute {
	private BufferedImage image;
	private LevelRouteInstruction[] routeInstructions;
	
	public LevelRoute(int levelNumber) {
		String imgPath = String.format("res/images/level_routes/level_%d_route.png", levelNumber);
		createRouteInstructions();
	}
	
	public void createRouteInstructions() {
		ArrayList<LevelRouteInstruction> instructionsList = new ArrayList<LevelRouteInstruction>();
	}
	
	/**
	 * A direction and a target location. Enemies use
	 * a list of these to correctly make their way around
	 * the map.
	 * @author Ronan
	 */
	class LevelRouteInstruction {
		// clockwise from up (0=up, 1=right, 2=down, 3=left)
		private int direction;
		private int targetTileX;
		private int targetTileY;
		
		public LevelRouteInstruction(int direction, int targetTileX, int targetTileY) {
			this.direction = direction;
			this.targetTileX = targetTileX;
			this.targetTileY = targetTileY;
		}
		
		public int getDirection() {
			return direction;
		}
		
		public int getTargetTileX() {
			return targetTileX;
		}
		
		public int getTargetTileY() {
			return targetTileY;
		}
		
	}
	
}