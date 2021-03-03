package Testing;

import Components.Button;
import General.Window;

public class Main {
    public static void main(String[] args) throws Exception {
    	/*JFrame window = new JFrame("Basic...");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(640, 480);
        window.setVisible(true);*/
    	Window window = new Window(640, 480, "Yay, it works!");
        Button button = new Button("WOW!", 0, 0, 300, 176);
        button.setIcon("https://i.stack.imgur.com/93WB6.gif");
        window.add(button);
        window.show();
    }
}
