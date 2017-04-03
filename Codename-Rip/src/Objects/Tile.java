package Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tile extends GameObject {

	private Player player;

	public Tile(int x, int y, ObjectID id, Player player) {
		super(x, y, id);

		this.player = player;
	}

	public void update() {
		detectCollision(player, this);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64,64);
	}

	public void render(Graphics2D g) {
	}

	public void detectCollision(Player player, Tile tile) {
	}
}