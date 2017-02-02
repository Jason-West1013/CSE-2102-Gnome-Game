package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**********************************************
 * Draws the window on the screen. Dimensions are 
 * passed from the Game class. 
 **********************************************/
public class Window extends Canvas {
	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setPreferredSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes when 'X'is pressed. 
		frame.setLocationRelativeTo(null); // Puts on the center of the screen. 
		frame.setResizable(false); // Window resizing. 

		frame.add(game);
		frame.setVisible(true);

		game.start();
	}
}
