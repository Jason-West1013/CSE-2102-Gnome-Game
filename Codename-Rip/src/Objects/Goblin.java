package Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Graphics.SpriteSheet;
import Input.InputHandler;

public class Goblin extends GameObject {
	public static final int MAX_LEFT_TRAVEL = 40, MAX_RIGHT_TRAVEL = 200, WIDTH = 5, HEIGHT = 32;

	private int accelY = 1, frame = 0, dir = 0;
	private boolean onGround = true, move = false;
	private Player _player;
	private boolean _collPlayer = false;

	public Goblin(int x, int y, ObjectID id, Player player) {
		super(x, y, id);
		velX = 0;
		velY = 0;
		_player = player;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getWidth() {
		return WIDTH;
	}

	public void update() {
		//move = false;
		velX = 0;

		if (y >= 300) {
			onGround = true;
		}

		this.goblinAI();
		this.checkCollision();
		
		//if (InputHandler.keys[InputHandler.A]) this.moveRight();
		//if (InputHandler.keys[InputHandler.D]) this.moveLeft();
		//if (InputHandler.keys[InputHandler.SPACE]) this.jump();

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
			}
			else if (dir == 1) {
				g.drawImage(SpriteSheet.playerTwo[3][0], x, y  - 64, null);
				g.drawImage(SpriteSheet.playerTwo[3][1], x, y, null);
			}
		} else {
			int stepFrame = 2 + (frame / 4) % 2;
			
			if (dir == 0) {
				g.drawImage(SpriteSheet.playerOne[stepFrame][0], x, y - 64, null);
				g.drawImage(SpriteSheet.playerOne[stepFrame][1], x, y, null);
			}
			else if (dir == 1) {
				g.drawImage(SpriteSheet.playerTwo[stepFrame][0], x, y - 64, null);
				g.drawImage(SpriteSheet.playerTwo[stepFrame][1], x, y, null);
			}
		}
	}

	private void moveLeft() {
		move = true;
		dir = 1;

		if (x == MAX_LEFT_TRAVEL) {
			velX = 0;
		} else {
			velX = -1;
		}
		
		if(_collPlayer)
			velX = 0;
	}

	private void moveRight() {
		move = true;
		dir = 0;

		if (x == MAX_RIGHT_TRAVEL) {
			velX = 0;
		} else {
			velX = 1;
		}
		
		if(_collPlayer) 
			velX = 0;
	}
	
	private void standStill() {
		move = false;
		velX = 0;
	}

	private void jump() {
		if (onGround) {
			velY = -10;
			onGround = false;
		}
	}
	
	/*****************************************
	 * Returns a rectangle instance to surround
	 * the sprite.
	 *****************************************/
	private Rectangle getBounds() {
		return new Rectangle(x + 15, y, WIDTH, HEIGHT);
	}
	
	/*****************************************
	 * Rough AI method the goblin just always
	 * walks towards the player. Currently setup 
	 * to test health system.
	 *****************************************/
	public void goblinAI() {
		if(getX() == MAX_LEFT_TRAVEL && _player.getX() < getX() || getX() == MAX_RIGHT_TRAVEL && 
				_player.getX() > getX() || _collPlayer == true)
			standStill();
		else if(_player.getX() < getX())
			moveLeft();
		else if(_player.getX() > getX())
			moveRight();
	}
	
	/*****************************************
	 * Checks the collision between the player
	 * and the goblin. Moves player outside of 
	 * bounds if a collision is detected.
	 *****************************************/
	public void checkCollision() {
		if(this.getBounds().intersects(_player.getBounds())) {
			_collPlayer = true;
			_player.damage();
			if(_player.getDir() == 1) {// If player is on the right.
				_player.setX(_player.getX() + this.WIDTH);
			} else if(_player.getDir() == 0) {// If player is on the left.
				_player.setX(_player.getX() - this.WIDTH);
			}
		} else
			_collPlayer = false;
	}
}