package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

import Input.InputHandler;

public class Player extends GameObject {
	public static final int MAX_LEFT_TRAVEL = 40, MAX_RIGHT_TRAVEL = 340;

	private int accelY = 1;
	private boolean onGround = true;

	public Player(int x, int y, ObjectID id) {
		super(x, y, id);

		velY = 0;
	}

	public void update() {
		velX = 0;
		
		if (y >= 300) {
			onGround = true;
		}

		if (InputHandler.keys[InputHandler.A] == true) this.moveLeft();
		if (InputHandler.keys[InputHandler.D] == true) this.moveRight();
		if (InputHandler.keys[InputHandler.SPACE] == true) this.jump();

		if (!onGround) {
			y += velY;
			velY += accelY;
		}

		x += velX;
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
	}

	public void moveLeft() {
		if (x == MAX_LEFT_TRAVEL)
			velX = 0;
		else
			velX = -4;
	}

	public void moveRight() {
		if (x == MAX_RIGHT_TRAVEL)
			velX = 0;
		else
			velX = 4;
	}

	public void jump() {
		if (onGround) {
			velY = -10;

			onGround = false;
		}
	}
}