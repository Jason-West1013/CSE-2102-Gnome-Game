package com.game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	public static final int W = 0;
	public static final int S = 1;
	public static final int A = 2;
	public static final int D = 3;

	public static boolean[] keys = new boolean[4];

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) keys[W] = true;
		if (e.getKeyCode() == KeyEvent.VK_S) keys[S] = true;
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = true;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = true;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) keys[W] = false;
		if (e.getKeyCode() == KeyEvent.VK_S) keys[S] = false;
		if (e.getKeyCode() == KeyEvent.VK_A) keys[A] = false;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[D] = false;
	}
}