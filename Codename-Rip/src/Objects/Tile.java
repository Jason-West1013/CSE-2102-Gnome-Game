package Objects;

import java.awt.Graphics2D;

import Graphics.SpriteSheet;

public class Tile extends GameObject {

	private Player player;

	public Tile(int x, int y, ObjectID id, Player player) {
		super(x, y, id);

		this.player = player;
	}

	public void update() {
		detectCollision(player, this);
	}

	public void render(Graphics2D g) {
		g.drawImage(SpriteSheet.tiles[1][0], x, y, null);
	}

	public void detectCollision(Player player, Tile tile) {
		if (player.getX() < tile.getX() + 32 && player.getX() + 64 > tile.getX() && player.getY() < tile.getY() + 32
				&& player.getY() + 71 > tile.getY()) {
			Player.collision = true;
		} else {
			Player.collision = false;
		}
	}
}