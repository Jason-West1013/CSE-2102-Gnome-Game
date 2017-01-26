package com.game.object;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends GameObject {
	public Player(int x, int y, ObjectID id) {
		super(x, y, id);
	}
	
	public void tick() {
		
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
	}
}