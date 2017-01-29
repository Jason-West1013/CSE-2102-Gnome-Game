package com.game.object;

import java.awt.Color;
import java.awt.Graphics2D;

import com.game.input.InputHandler;

/**********************************************
 * Main player object.  
 **********************************************/
public class Player extends GameObject {
	public Player(int x, int y, ObjectID id) {
		super(x, y, id);
	}

	/**********************************************
	 * Player updates.  
	 **********************************************/
	public void tick() {
		velX = 0;
		velY = 0;
		
		if(InputHandler.keys[InputHandler.W] == true) velY = -2;
		if(InputHandler.keys[InputHandler.S] == true) velY = 2;
		if(InputHandler.keys[InputHandler.A] == true) velX = -2;
		if(InputHandler.keys[InputHandler.D] == true) velX = 2;
		
		x += velX;
		y += velY;
	}

	/**********************************************
	 * Drawing the player character.  
	 **********************************************/
	public void render(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}
}