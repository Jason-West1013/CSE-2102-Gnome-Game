package Objects;

import java.awt.Graphics2D;

import Graphics.SpriteSheet;
import Input.InputHandler;

public class Player extends GameObject {
	public static final int MAX_LEFT_TRAVEL = 40, MAX_RIGHT_TRAVEL = 340;

	private int accelY = 1, frame = 0, dir = 0;;
	private boolean onGround = true, move = false;

	public Player(int x, int y, ObjectID id) {
		super(x, y, id);

		velY = 0;
	}

	public void update() {
		velX = 0;
		move = false;

		if (y >= 300) {
			onGround = true;
		}

		if (InputHandler.keys[InputHandler.A]) {
			this.moveLeft();
			dir = 1;
			move = true;
		}
		if (InputHandler.keys[InputHandler.D]) {
			this.moveRight();
			dir = 0;
			move = true;
		}
		if (InputHandler.keys[InputHandler.SPACE]) {
			this.jump();
		}

		if (move) {
			frame++;
		} else {
			frame = 0;
		}

		if (!onGround) {
			y += velY;
			velY += accelY;
		}

		x += velX;
	}

	public void render(Graphics2D g) {
		if (!onGround) {
			if(dir == 0) g.drawImage(SpriteSheet.playerOne[1][0], x, y, null);
			else if(dir == 1) g.drawImage(SpriteSheet.playerTwo[1][0], x, y, null);
		} else {
			int stepFrame = (frame / 4) % 2;
			if(dir == 0) g.drawImage(SpriteSheet.playerOne[stepFrame][0], x, y, null);
			else if(dir == 1) g.drawImage(SpriteSheet.playerTwo[stepFrame][0], x, y, null);
		}
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