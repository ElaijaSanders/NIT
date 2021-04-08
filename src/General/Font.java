package General;

import java.awt.GraphicsEnvironment;

import Technical.Wrapper;

public class Font extends Wrapper<java.awt.Font> {
	private java.awt.Font value;
	public static final int Normal = java.awt.Font.PLAIN;
	public static final int Italic = java.awt.Font.ITALIC;
	public static final int Bold = java.awt.Font.BOLD;
	public static Font of(String name, int size, int style) {
		Font f = new Font(); f.value = new java.awt.Font(name, style, size); return f;
	}
	public java.awt.Font getRawValue(){
		return this.value;
	} public Font(java.awt.Font f){
		this.value = f;
	} public Font(){}
	public static String[] getAvailableFonts(){
		java.awt.Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		String[] str = new String[fonts.length];
		for(int i = 0; i < fonts.length; i++) str[i] = fonts[i].getName();
		return str;
	}
	public void setName(String name){
		this.value = new java.awt.Font(name, this.value.getStyle(), this.value.getSize());
	} public String getName(){
		return this.value.getName();
	}
}
