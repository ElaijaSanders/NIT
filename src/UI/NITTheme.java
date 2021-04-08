package UI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Insets;

public class NITTheme {
	public static Insets basicInsets = new Insets(0, 0, 0, 0);
	public static Color borderColor = new Color(153, 153, 153);
	public static Color selectedBorderColor = new Color(112, 200, 255);
	public static GradientPaint buttonPressed(int h){
		return new GradientPaint(0, 0, Color.decode("#CCCCCC"), 0, h, Color.decode("#A1A1A1"));
	} public static Color buttonPressedNotOver(int h){ return Color.decode("#999999"); }
	public static GradientPaint button(int h){
		return new GradientPaint(0, 0, Color.decode("#F3F3F3"), 0, h, Color.decode("#D5D5D5"));
	} public static Color buttonHover(){ return Color.decode("#E6E6E6"); }
	public static Color buttonDisabled(){ return new Color(242, 242, 242, 204); }
}
