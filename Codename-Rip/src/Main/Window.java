package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

import View.InGameOptionMenu;

public class Window extends Canvas implements WindowFocusListener {
	private static final long serialVersionUID = 1L;

	private InGameOptionMenu inGameOptionMenu;
	private JFrame frame;

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

		game.start();
	}

	public void windowGainedFocus(WindowEvent e) {
	}

	public void windowLostFocus(WindowEvent e) {
		if (inGameOptionMenu == null) {
			inGameOptionMenu = new InGameOptionMenu(this);
			inGameOptionMenu.setVisible(true);
			inGameOptionMenu.setLocationRelativeTo(this);
		} else if (inGameOptionMenu.isVisible() == false) {
			inGameOptionMenu.setVisible(true);
			inGameOptionMenu.setLocationRelativeTo(this);
		}
	}

	public void close() {
		frame.dispose();
	}
}
