package Objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.SpriteSheet;

public class Map extends GameObject {
	private int width = SpriteSheet.map.getWidth();
	private int height = SpriteSheet.map.getHeight();

	private byte[] walls = new byte[width * height];

	public Map(int x, int y, ObjectID id) {
		super(x, y, id);

		this.readTiles(SpriteSheet.map);
	}

	public void update() {

	}

	public void render(Graphics2D g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				g.drawImage(SpriteSheet.tiles[walls[x + y * width]][0], x * 64, y * 64, null);
			}
		}
	}

	private void readTiles(BufferedImage image) {
		int[] pixels = SpriteSheet.map.getRGB(0, 0, width, height, null, 0, width);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int color = pixels[x + y * width] & 0xffffff;

				if (color == 0xffffff) walls[x + y * width] = 1;
			}
		}
	}
}