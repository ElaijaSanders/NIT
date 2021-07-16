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
		return new GradientPaint(0, 0, Color.decode("#F3F3F3"), 0, h, Color.decode("#BFBFBF"));
	} public static Color buttonHover(){ return Color.decode("#E6E6E6"); }
	public static Color buttonDisabled(){ return new Color(242, 242, 242, 204); }
	public static Color textFieldBase = Color.decode("#F3F3F3");
	public static Color textPlaceholder = new Color(128, 128, 128, 204);
	public static Color textSelection = Color.decode("#75C2EB");
	public static Color arrowColor = Color.DARK_GRAY;
	public static Color arrowPressed = Color.DARK_GRAY.brighter().brighter();
	public static Color arrowDisabled = Color.decode("#5C0600");
	public static Color checkboxBase = Color.LIGHT_GRAY.brighter();
	public static Color checkboxBasePressed = Color.decode("#B3B3B3");
	public static Color checkboxCheck = Color.decode("#00076B");
	public static Color radioButtonBase = Color.LIGHT_GRAY.brighter();
	public static Color radioButtonBasePressed = Color.decode("#B3B3B3");
	public static Color radioButtonSelection = Color.decode("#00076B");
	public static Color sliderThumbBase = Color.LIGHT_GRAY.brighter();
	public static Color sliderThumbBasePressed = Color.decode("#C7C7C7");
	public static Color sliderTrackBase = Color.decode("#F0F0F0");
	public static Color toggleButtonSelected = Color.decode("#9999A4");
	public static Color listBase = Color.decode("#F3F3F3");
	public static Color listBaseSelected = Color.decode("#00076B");
	public static Color tableGrid = new Color(153, 153, 153);
	public static Color tableBase = Color.decode("#F3F3F3");
	public static Color tableBaseSelected = Color.decode("#00076B");
	public static Color tableText = Color.BLACK;
	public static Color tableTextSelected = Color.WHITE;
	public static GradientPaint tableHeaderBase(int h){
		return new GradientPaint(0, 0, Color.decode("#CCCCCC"), 0, h, Color.decode("#A1A1A1"));
	}
}
