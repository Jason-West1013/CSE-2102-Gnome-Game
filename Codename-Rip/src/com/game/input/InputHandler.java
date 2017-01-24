package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	public boolean keyList[] = new boolean[4];
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			keyList[0] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			keyList[1] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			keyList[2] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			keyList[3] = true;
		}	
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			keyList[0] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			keyList[1] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			keyList[2] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			keyList[3] = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
}