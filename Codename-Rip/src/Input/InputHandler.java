package Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	public static final int A = 0;
	public static final int D = 1;
	public static final int SPACE = 2;

	public static boolean[] keys = new boolean[3];

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = true;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[SPACE] = true;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = false;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = false;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[SPACE] = false;
	}
}