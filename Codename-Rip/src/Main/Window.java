package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import View.InGameOptionMenu;

public class Window extends Canvas implements WindowFocusListener, KeyListener{
	private static final long serialVersionUID = 1L;

	private InGameOptionMenu inGameOptionMenu;	
	
	JFrame frame;
	
	public Window(int width, int height, String title, Game game) {
		frame = new JFrame(title);

		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setPreferredSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		frame.add(game);
		frame.setVisible(true);
		
		frame.addWindowFocusListener(this);
		
		addKeyListener(this);
		
		game.start();
	}
	@Override
	public void windowGainedFocus(WindowEvent e) {
	
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		if(inGameOptionMenu == null){
			inGameOptionMenu = new InGameOptionMenu(this);
			inGameOptionMenu.setVisible(true);
			inGameOptionMenu.setLocationRelativeTo(this);
		}
		else if(inGameOptionMenu.isVisible() == false){
			inGameOptionMenu.setVisible(true);
			inGameOptionMenu.setLocationRelativeTo(this);
		}
	}
		
	
	
	public void close(){
		frame.dispose();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode() + "key pressed");
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode() + "key released");
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode() + "key typed");
		
	}
}
