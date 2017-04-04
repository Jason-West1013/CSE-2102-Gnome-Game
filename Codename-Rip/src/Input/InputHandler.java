package Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	public static final int A = 0;
	public static final int D = 1;
	public static final int SPACE = 2;
	public static final int SHIFT = 3;

	public static boolean[] keys = new boolean[4];
	public static boolean[] oldKeys = new boolean[4];

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = true;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[SPACE] = true;
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) keys[SHIFT] = true;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = false;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = false;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[SPACE] = false;
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) keys[SHIFT] = false;
	}
	
	public void update() {
		for(int i = 0; i < keys.length; i++) {
			oldKeys[i] = keys[i];
		}
	}
}