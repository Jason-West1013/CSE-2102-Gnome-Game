package Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**********************************************
 * Handles key presses, contains which keys are 
 * used within the game. 
 **********************************************/
public class InputHandler extends KeyAdapter {
	public static final int W = 0;
	public static final int S = 1;
	public static final int A = 2;
	public static final int D = 3;
	public static final int SP = 4;

	public static boolean[] keys = new boolean[5];

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) keys[W] = true;
		if (e.getKeyCode() == KeyEvent.VK_S) keys[S] = true;
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = true;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[SP] = true;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) keys[W] = false;
		if (e.getKeyCode() == KeyEvent.VK_S) keys[S] = false;
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = false;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = false;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[SP] = false;
	}
}