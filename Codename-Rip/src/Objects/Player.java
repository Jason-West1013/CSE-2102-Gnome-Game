package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Input.InputHandler;

public class Player extends GameObject {
	public static final int MAX_LEFT_TRAVEL = 40, MAX_RIGHT_TRAVEL = 340;

	private int accelY = 1;
	public boolean onGround = true;
	
	public Player(int x, int y, ObjectID id) {
		super(x, y, id);
		
		velX = 0;
		velY = 0;
	}

	public void update() {
		velX = 0;
		
		if( y >= 344) onGround = true;
		
		if (InputHandler.keys[InputHandler.A]) this.moveLeft();
		if (InputHandler.keys[InputHandler.D]) this.moveRight();
		if (InputHandler.keys[InputHandler.SPACE]) this.jump();

		if (!onGround) {
			y += velY;
			velY += accelY;
		}

		x += velX;
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	private void moveLeft() {
		if (x == MAX_LEFT_TRAVEL) {
			velX = 0;
		} else {
			velX = -4;
		}
	}

	private void moveRight() {
		if (x == MAX_RIGHT_TRAVEL) {
			velX = 0;
		} else {
			velX = 4;
		}
	}

	private void jump() {
		if (onGround) {
			velY = -15;

			onGround = false;
		}
	}
}