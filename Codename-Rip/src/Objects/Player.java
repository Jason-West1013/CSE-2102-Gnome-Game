package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Graphics.SpriteSheet;
import Input.InputHandler;

public class Player extends GameObject {
	public static final int MAX_LEFT_TRAVEL = 0, MAX_RIGHT_TRAVEL = 601, WIDTH = 32, HEIGHT = 32;
	private int accelY = 1, frame = 0, dir = 0;
	private boolean onGround = true, move = false;
	private Player _player;
	private boolean _collPlayer = false;
private boolean shifted = false;
	

	private ObjectHandler objectHandler;
	private PastMap pastMap;
	private PresentMap presentMap;

	public Player(int x, int y, ObjectID id, ObjectHandler objectHandler, PastMap pastMap, PresentMap presentMap) {
		super(x, y, id);

		this.objectHandler = objectHandler;
		this.pastMap = pastMap;
		this.presentMap = presentMap;
	}

	public void update() {
		velX = 0;
		if (move) {
			frame++;
		} else {
			frame = 0;
		}

		if (velX == 0) {
		move = false;
		}
		if (!shifted && y >= presentMap.floor.getY() - HEIGHT) {
			onGround = true;
		} else if (shifted && y >= pastMap.floor.getY() - HEIGHT) {
			onGround = true;
		} else {
			onGround = false;
		}

		if (InputHandler.keys[InputHandler.A]) this.moveLeft();
		if (InputHandler.keys[InputHandler.D]) this.moveRight();
		if (InputHandler.keys[InputHandler.SPACE] && !InputHandler.oldKeys[InputHandler.SPACE]) this.jump();
		if (InputHandler.keys[InputHandler.SHIFT] && !InputHandler.oldKeys[InputHandler.SHIFT]) this.shift();

		if (!onGround) {
			y += velY;
			velY ++ ;
		}
		x += velX;
	}

	public void render(Graphics2D g) {
		if (!onGround) {
			if (dir == 0) {
				g.drawImage(SpriteSheet.playerOne[0][0], x, y-32, null);
			} else if (dir == 1) {
				g.drawImage(SpriteSheet.playerTwo[0][0], x-32, y-32, null);
			}
		} else {
			int stepFrame = (frame / 2) % 2;

			if (dir == 0) {
				g.drawImage(SpriteSheet.playerOne[stepFrame][0], x, y-32, null);				
			} else if (dir == 1) {
				g.drawImage(SpriteSheet.playerTwo[stepFrame][0], x-32, y-32, null);				
			}
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	private void moveLeft() {
		if (x <= MAX_LEFT_TRAVEL) {
			velX = 0;
			dir = 1;
			move = false;
		} else {
			move = true;
			velX = -4;
			dir = 1;
		}

		if (!shifted && x >= presentMap.pillar.getX() + presentMap.pillar.getWidth()
				&& x <= presentMap.pillar.getX() + presentMap.pillar.getWidth()) {
			velX = 0;
		}
	}

	private void moveRight() {
		if (x >= MAX_RIGHT_TRAVEL) {
			velX = 0;
			dir = 0;
			move = false;
		} else {
			move = true;
			velX = 4;
			dir = 0;
		}

		if (!shifted && x <= presentMap.pillar.getX() - WIDTH && x >= presentMap.pillar.getX() - WIDTH) {
			velX = 0;
		}
	}

	private void jump() {
		if (onGround) {
			velY = -10;
			onGround = false;
		}
	}

	private void shift() {
		if (!this.getBounds().intersects(presentMap.pillar.getBounds())) {
			if (!shifted) {
				for (int i = 0; i < objectHandler.objectList.size(); i++) {
					GameObject tempObject = objectHandler.objectList.get(i);

					if (tempObject.getID() == ObjectID.PRESENT_MAP) {
						objectHandler.removeObject(tempObject);
					}
				}
				objectHandler.addObject(pastMap);

				shifted = true;
			} else {
				for (int i = 0; i < objectHandler.objectList.size(); i++) {
					GameObject tempObject = objectHandler.objectList.get(i);

					if (tempObject.getID() == ObjectID.PAST_MAP) {
						objectHandler.removeObject(tempObject);
					}
				}
				objectHandler.addObject(presentMap);

				shifted = false;
			}
		}
	}
}