package com.game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	public static boolean keys[] = new boolean[4];
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_W) {
			keys[0] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			keys[1] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			keys[2] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			keys[3] = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			keys[0] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			keys[1] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			keys[2] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			keys[3] = false;
		}
	}
}