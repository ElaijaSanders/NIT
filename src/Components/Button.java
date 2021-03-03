package Components;

import Technical.Component;

import javax.swing.JButton;
import javax.swing.JComponent;

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
}