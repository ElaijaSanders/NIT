package Components;

import Technical.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Button extends Component {
	private JButton value;
	public Button(String text, int x, int y, int w, int h){
		this.value = new JButton(text);
		this.value.setSize(w, h);
		this.value.setLocation(x, y);
	}
	public Button(String text){ this(text, 0, 0, 100, 50); }
	public Button(){ this("", 0, 0, 100, 50); }
	@Override
	public JComponent getRawValue(){
		return this.value;
	}
	public void setIcon(String url, int w, int h) throws IOException {
		this.value.setIcon(new ImageIcon(ImageIO.read(new URL(url)).getScaledInstance(w, h, Image.SCALE_FAST)));
	} public void setIcon(String url) throws IOException {
		this.setIcon(url, 100,  60);
	}
}