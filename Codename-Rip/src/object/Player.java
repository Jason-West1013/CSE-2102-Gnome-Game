package object;

import java.awt.Color;
import java.awt.Graphics2D;

import input.InputHandler;
import main.Game;

public class Player extends GameObject {
	boolean spacePressed = false;

	public Player(int x, int y, ObjectID id) {
		super(x, y, id);
	}

	public void tick() {
		velX = 0;
		velY = 0;
		
		if(this.getY() <= Game.HEIGHT - 71) velY = 5;
		
		if (InputHandler.keys[InputHandler.A] == true && this.getX() >= 0) velX = -2;
		if (InputHandler.keys[InputHandler.D] == true && this.getX() <= Game.WIDTH - 38) velX = 2;
		if (InputHandler.keys[InputHandler.SPACE] == true && this.getY() >= 0 && this.getY() <= Game.HEIGHT - 71) {
			velY = -5;
		}

		x += velX;
		y += velY;
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
	}
}