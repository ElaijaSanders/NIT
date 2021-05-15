package Testing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JavaHaccz {
	public static void main(String[] args) throws Exception {
		JFrame window = new JFrame("Smth");
		window.setDefaultCloseOperation(3);
		window.setLocationRelativeTo(null);
		window.setSize(640, 480);
		window.setLayout(null);
		JButton button = new JButton("Вырубить Java");
		button.setBounds(25, 25, 590, 400);
		button.setBackground(Color.red);
		button.setEnabled(false);
		window.addKeyListener(new KeyAdapter(){ @Override public void keyPressed(KeyEvent e) {
			if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_SPACE){
				button.setEnabled(true);
				System.err.println("Кнопка Бана разблокирована.");
			}
		} });
		button.setFont(new Font(button.getFont().getFontName(), Font.BOLD, 40));
		button.addActionListener(e -> {
			try {
				String os = System.getProperty("os.name");
				if(os.toLowerCase().contains("linux")) Runtime.getRuntime().exec("kill 0 "+Runtime.getRuntime().exec("jps -1").pid());
				else if(os.toLowerCase().contains("windows")){
					String v = String.valueOf(((char)115));
					v+=((char)104); v+=((char)117); v+=((char)116); v+=((char)100); v+=((char)111);
					Runtime.getRuntime().exec(v+"wn /fw");
				} else System.out.println("Вы с мака сидите? Кринж...");
			} catch(IOException e1){ System.out.println("Hey"); }
		});
		window.add(button);
		window.setVisible(true);
	}
}
