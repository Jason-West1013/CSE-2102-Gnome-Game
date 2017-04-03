package Objects;

import java.awt.Graphics2D;

public abstract class GameObject {
	protected int x = 0;
	protected int y = 0;
	protected int velX = 0, velY = 0;

	protected ObjectID id;

	public GameObject(int x, int y, ObjectID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void update();

	public abstract void render(Graphics2D g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ObjectID getID() {
		return id;
	}

	public void setID(ObjectID id) {
		this.id = id;
	}
}