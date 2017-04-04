package Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import GameState.GameStateManager;
import Graphics.SpriteSheet;
import Input.InputHandler;

public class Player extends GameObject {
	public static final int MAX_LEFT_TRAVEL = -20, MAX_RIGHT_TRAVEL = 585, WIDTH = 32, HEIGHT = 32;

	private int accelY = 1, frame = 0, dir = 0, _health = 100, _lifes = 3; // Added health
	private boolean onGround = true, move = false;
	public static boolean collision = false;
	GameStateManager _gameState;

	public Player(int x, int y, ObjectID id, GameStateManager gameState) {
		super(x, y, id);
		velX = 0;
		velY = 0;
		_gameState = gameState;
	}
	
	public int getDir() {return dir;}

	public void update() {
		move = false;
		velX = 0;

		if (y >= 300) onGround = true;

		if (InputHandler.keys[InputHandler.A]) this.moveLeft();
		if (InputHandler.keys[InputHandler.D]) this.moveRight();
		if (InputHandler.keys[InputHandler.SPACE]) this.jump();

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
			if (dir == 0) g.drawImage(SpriteSheet.playerOne[1][0], x, y, null);
			else if (dir == 1) g.drawImage(SpriteSheet.playerTwo[1][0], x, y, null);
		} else {
			int stepFrame = (frame / 4) % 2;
			
			if (dir == 0) g.drawImage(SpriteSheet.playerOne[stepFrame][0], x, y, null);
			else if (dir == 1) g.drawImage(SpriteSheet.playerTwo[stepFrame][0], x, y, null);
		}
		
	}

	private void moveLeft() {
		move = true;
		dir = 1;

		if (x <= MAX_LEFT_TRAVEL) {
			velX = 0;
		} else {
			velX = -4;
		}
	}

	private void moveRight() {
		move = true;
		dir = 0;

		if (x >= MAX_RIGHT_TRAVEL) {
			velX = 0;
		} else {
			velX = 4;
		}
	}

	private void jump() {
		if (onGround) {
			velY = -10;
			onGround = false;
		}
	}
	
	// Damage animation???
	public void damage() {
		_health -= 10;
		
		if(_health <= 0) {
			_lifes -= 1;
		} else if(_health <=0 && _lifes == 0) {
			_gameState.gameOver(); // If character is fully dead calls game over from game state manager. 
		}
	}
	
	/*****************************************
	 * Returns a new rectangle that surrounds the
	 * player for collision purposes. 
	 *****************************************/
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
}