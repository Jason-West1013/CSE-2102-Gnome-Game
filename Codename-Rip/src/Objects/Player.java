package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Input.InputHandler;

public class Player extends GameObject {
	public static final int MAX_LEFT_TRAVEL = 0, MAX_RIGHT_TRAVEL = 601, WIDTH = 32, HEIGHT = 32;

	private int accelY = 1;
	private boolean onGround = true, shifted = false;
	
	ObjectHandler objectHandler;
	PresentMap presentMap;
	PastMap pastMap;

	public Player(int x, int y, ObjectID id, ObjectHandler objectHandler, PresentMap presentMap, PastMap pastMap) {
		super(x, y, id);
		
		this.objectHandler = objectHandler;
		this.presentMap = presentMap;
		this.pastMap = pastMap;
	}

	public void update() {
		velX = 0;
		
		if( y >= 344) onGround = true;
		
		if (InputHandler.keys[InputHandler.A]) this.moveLeft();
		if (InputHandler.keys[InputHandler.D]) this.moveRight();
		if (InputHandler.keys[InputHandler.SPACE]) this.jump();
		if (InputHandler.keys[InputHandler.SHIFT]) this.shift();

		if (!onGround) {
			y += velY;
			velY += accelY;
		}

		x += velX;
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	private void moveLeft() {
		if (x <= MAX_LEFT_TRAVEL) {
			velX = 0;
		} else {
			velX = -4;
		}
	}

	private void moveRight() {
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
	
	private void shift() {
		if(!shifted) {
			shifted = true;
		} else {
			shifted = false;
		}
		
		if(!shifted) {
			for(int i = 0; i < objectHandler.objectList.size(); i++) {
				GameObject tempObject = objectHandler.objectList.get(i);
				
				if(tempObject.getID() == ObjectID.PRESENT_MAP) {
					objectHandler.removeObject(tempObject);
				}
			}
			
			objectHandler.addObject(pastMap);
		} else {
			for(int i = 0; i < objectHandler.objectList.size(); i++) {
				GameObject tempObject = objectHandler.objectList.get(i);
				
				if(tempObject.getID() == ObjectID.PAST_MAP) {
					objectHandler.removeObject(tempObject);
				}
			}
			
			objectHandler.addObject(presentMap);
		}
	}
}