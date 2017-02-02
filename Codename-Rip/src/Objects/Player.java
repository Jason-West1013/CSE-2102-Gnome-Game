package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

import Input.InputHandler;

/**********************************************
 * Main player object.  
 **********************************************/
public class Player extends GameObject {
	
	private int _playerXLoc;
	private int _playerYLoc;
	private final int MAX_RIGHT_TRAVEL = 340; // Once this is hit the background starts to move not the player. 
	private final int MAX_LEFT_TRAVEL = 4;
	
	public Player(int x, int y, ObjectID id) {
		super(x, y, id); 
		_playerXLoc = x;
		_playerYLoc = y;
	}
	
	public int getMaxRight() {return MAX_RIGHT_TRAVEL;}
	public int getMaxLeft() {return MAX_LEFT_TRAVEL;}

	/**********************************************
	 * Player updates.  
	 **********************************************/
	public void tick() {
		velX = 0;
		velY = 0;
		
		// if(InputHandler.keys[InputHandler.W] == true) {velY = -2;}
		// if(InputHandler.keys[InputHandler.S] == true) velY = 2; // Player can't go down, only duck. 
		if(InputHandler.keys[InputHandler.A] == true) 
			this.moveLeft();
		if(InputHandler.keys[InputHandler.D] == true) 
			this.moveRight();
		if(InputHandler.keys[InputHandler.SP] == true)
			this.jump();
		
		x += velX;
		y += velY;
		
		//Update player location. 
		_playerXLoc += velX;
		_playerYLoc += velY;
	}

	/**********************************************
	 * Drawing the player character.  
	 **********************************************/
	public void render(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}
	
	/**********************************************
	 * Methods for character movement.  
	 **********************************************/
	public void moveLeft() {
		if(_playerXLoc == MAX_LEFT_TRAVEL) 
			velX = 0;
		 else 
			velX = -2;
	}
	
	public void moveRight() {
		if(_playerXLoc == MAX_RIGHT_TRAVEL) 
			velX = 0;
		 else 
			velX = 2;
	}
	
	public void jump() {
		
	}
	
	
	public void stayStill() { // For collision detection, running into objects and such. 
		
	}
}