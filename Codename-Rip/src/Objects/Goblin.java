package Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Graphics.SpriteSheet;

public class Goblin extends GameObject {
	public static final int MAX_LEFT_TRAVEL = 40, MAX_RIGHT_TRAVEL = 520, WIDTH = 5, HEIGHT = 32;

	private int accelY = 1, frame = 0, dir = 0;
	private boolean onGround = true, move = false;
	private Player _player;
	private boolean _collPlayer = false;

	public Goblin(int x, int y, ObjectID id, Player player) {
		super(x, y, id);

		_player = player;
	}

	public void update() {
		velX = 0;

		if (y >= 300) {
			onGround = true;
		}

		this.goblinAI();
		this.checkCollision();

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
			if (dir == 0) {
				g.drawImage(SpriteSheet.playerOne[3][0], x, y - 64, null);
				g.drawImage(SpriteSheet.playerOne[3][1], x, y, null);
			} else if (dir == 1) {
				g.drawImage(SpriteSheet.playerTwo[3][0], x, y - 64, null);
				g.drawImage(SpriteSheet.playerTwo[3][1], x, y, null);
			}
		} else {
			int stepFrame = 2 + (frame / 4) % 2;

			if (dir == 0) {
				g.drawImage(SpriteSheet.playerOne[stepFrame][0], x, y - 64, null);
				g.drawImage(SpriteSheet.playerOne[stepFrame][1], x, y, null);
			} else if (dir == 1) {
				g.drawImage(SpriteSheet.playerTwo[stepFrame][0], x, y - 64, null);
				g.drawImage(SpriteSheet.playerTwo[stepFrame][1], x, y, null);
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	private void moveLeft() {
		move = true;
		dir = 1;

		if (x == MAX_LEFT_TRAVEL) {
			velX = 0;
		} else {
			velX = -1;
		}

		if (_collPlayer) velX = 0;
	}

	private void moveRight() {
		move = true;
		dir = 0;

		if (x == MAX_RIGHT_TRAVEL) {
			velX = 0;
		} else {
			velX = 1;
		}

		if (_collPlayer) velX = 0;
	}

	private void standStill() {
		move = false;
		velX = 0;
	}

	public void goblinAI() {
		if (getX() == MAX_LEFT_TRAVEL && _player.getX() < x || x == MAX_RIGHT_TRAVEL && _player.getX() > x || _collPlayer == true) {
			standStill();
		} else if (_player.getX() < getX()) {
			moveLeft();
		} else if (_player.getX() > getX()) {
			moveRight();
		}
	}

	public void checkCollision() {
	}
}