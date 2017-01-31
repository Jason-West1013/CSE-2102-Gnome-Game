package object;

import java.awt.Color;
import java.awt.Graphics2D;

import input.InputHandler;
import main.Game;

public class Player extends GameObject {
	public Player(int x, int y, ObjectID id) {
		super(x, y, id);
	}

	public void tick() {
		velX = 0;
		velY = 0;
		
		if(InputHandler.keys[InputHandler.W] == true && this.getY() >= 0) velY = -2;
		if(InputHandler.keys[InputHandler.S] == true && this.getY() <= Game.HEIGHT - 72) velY = 2;
		if(InputHandler.keys[InputHandler.A] == true && this.getX() >= 0) velX = -2;
		if(InputHandler.keys[InputHandler.D] == true && this.getX() <= Game.WIDTH - 38) velX = 2;
		
		x += velX;
		y += velY;
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
	}
}