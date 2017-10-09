package ronan_hanley.inside_av.menu_button;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * A set of MenuButtons, for use in a menu.
 * @author Ronan
 */
public class ButtonSet {
	private int startX;
	private int startY;
	private int buttonWidth;
	private int buttonHeight;
	private Color buttonColor;
	private Color buttonHoverColor;
	private int spacing;
	private MenuButton[] buttons;
	
	public ButtonSet(String[] buttonTexts, int startX, int startY, int buttonWidth, int buttonHeight, Color buttonColor, Color buttonHoverColor, int spacing) {
		this.startX = startX;
		this.startY = startY;
		this.buttonWidth = buttonWidth;
		this.buttonHeight = buttonHeight;
		this.buttonColor = buttonColor;
		this.buttonHoverColor = buttonHoverColor;
		this.spacing = spacing;
		
		buttons = new MenuButton[buttonTexts.length];
		for (int i = 0; i < buttonTexts.length; ++i) {
			buttons[i] = new MenuButton(startX, startY, buttonWidth, buttonHeight, buttonColor, buttonHoverColor, buttonTexts[i]);
			startY += buttonHeight + spacing;
		}
	}
	
	public void render(Graphics g) {
		// call each button's render method in turn
		for (MenuButton button : buttons) {
			button.render(g);
		}
	}
	
}