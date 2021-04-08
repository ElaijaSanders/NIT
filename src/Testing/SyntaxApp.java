package Testing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class SyntaxApp {
	public static void main(String[] args) {
		JFrame w = new JFrame();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setLocationRelativeTo(null);
        w.setSize(640, 480);
        JTextPane l = new JTextPane();
        l.setText("import this; then = do(){ that(); }");
        List<SyntaxUnit> syntax = new ArrayList<>();
        syntax.add(SyntaxUnit.of("import", Color.ORANGE, 6));
        syntax.add(SyntaxUnit.of("do", Color.BLUE, 2));
        syntax.add(SyntaxUnit.of("[{}]", Color.orange.darker(), 1));
        l.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent arg0){ recalculate(l, syntax); }
			@Override
			public void insertUpdate(DocumentEvent arg0){ recalculate(l, syntax); }
			@Override
			public void changedUpdate(DocumentEvent arg0){}
		});
        w.add(l);
        w.setVisible(true);
        System.out.println(l.getText());
	}
	public static void recalculate(JTextPane l, List<SyntaxUnit> syntax){
    	SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SimpleAttributeSet attr = new SimpleAttributeSet();
				StyleConstants.setForeground(attr, Color.GRAY);
				l.getStyledDocument().setCharacterAttributes(0, l.getStyledDocument().getLength(), attr, true);
				for(SyntaxUnit search : syntax){
		        	StyleConstants.setForeground(attr, search.color);
		        	Matcher m = Pattern.compile(search.regex).matcher(l.getText());
		        	while(m.find()){
		        		l.getStyledDocument().setCharacterAttributes(m.start(), search.size, attr, true);
		        	}
		        }
			}
		});
    }
    static class SyntaxUnit {
    	int size;
    	String regex;
    	Color color;
    	public static SyntaxUnit of(String regex, Color color, int size){
    		SyntaxUnit res = new SyntaxUnit(); res.size = size; res.regex = regex; res.color = color; return res;
    	}
    }
}
