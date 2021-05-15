package Testing;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Misc {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, InterruptedException, AWTException, URISyntaxException {
		PrintStream old = System.out;
		InputStream oldIn = System.in;
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(3);
		window.setLocationRelativeTo(null);
		window.setSize(640, 480);
		JTextArea text = new JTextArea();
		Console console = new Console(text);
		window.add(text);
		window.setVisible(true);
		// § AWT
		//Cursor, MouseInfo, PointerInfo, Process (Runtime), Robot, SystemTray, Taskbar, Toolkit, Desktop
		Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		//System.out.println(MouseInfo.getNumberOfButtons());
		PointerInfo pointerInfo = MouseInfo.getPointerInfo();
		//System.out.println(pointerInfo.getDevice());
		Process process = Runtime.getRuntime().exec("java -jar \"/home/michael/eclipse-workspace/Sch3SAP/sch3sap-2.0-linux.jar\"");
		Thread.sleep(3000);
		//System.out.println(process.info());
		process.destroy();
		Process loggingProcess = Runtime.getRuntime().exec("echo Hi!");
		//System.out.println( new BufferedReader(new InputStreamReader(loggingProcess.getInputStream())).readLine() );
		Robot robot = new Robot();
		//robot.mouseMove(10, 10);
		SystemTray.isSupported(); //@See https://docs.oracle.com/javase/tutorial/uiswing/misc/systemtray.html
		Taskbar.isTaskbarSupported(); //@See https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Taskbar.html
		Toolkit.getDefaultToolkit().beep();
		//Desktop.getDesktop().browse(new URI("https://google.com/"));
		Scanner sc = new Scanner(System.in);
		System.out.println("Line: "+sc.nextLine());
		sc.close();
		System.setOut(old);
		System.setIn(oldIn);
		console.close();
	}
	static class Console extends InputStream implements KeyListener {
		JTextArea text;
		String input = "";
		int pos = 0;
		public Console(JTextArea editor){
			this.text = editor;
			System.setOut(new PrintStream(new OutputStream(){ @Override public void write(int arg0) throws IOException {
				text.append(String.valueOf((char)arg0));
				text.setCaretPosition(text.getText().length());
				text.update(text.getGraphics());
			} }, true));
			this.text.addKeyListener(this);
			System.setIn(this);
		}
		@Override
		public int read() throws IOException {
			if(!input.isEmpty() && pos==input.length()){
				input = ""; return -1;
			} while(pos >= input.length()){
				try{ synchronized(this){this.wait();} }catch(InterruptedException e){}
			} return input.charAt(pos++);
		}
		@Override
		public void keyTyped(KeyEvent arg0){
			input += arg0.getKeyChar();
			if(arg0.getKeyChar()=='\n'){
				pos = 0;
				synchronized(this){ this.notifyAll(); }
			}
		}
		@Override public void keyPressed(KeyEvent arg0){}
		@Override public void keyReleased(KeyEvent arg0){}
	}
}
