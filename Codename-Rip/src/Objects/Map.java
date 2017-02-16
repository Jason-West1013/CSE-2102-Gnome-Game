package Objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.SpriteSheet;

public class Map extends GameObject {
	int width = SpriteSheet.map.getWidth();
	int height = SpriteSheet.map.getHeight();
	
	byte[] walls = new byte[width * height];

	public Map(int x, int y, ObjectID id) {
		super(x, y, id);
		
		this.readTiles(SpriteSheet.map);
	}

	public void update() {
		
	}

	public void render(Graphics2D g) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				g.drawImage(SpriteSheet.tiles[walls[x + y * width]][0], x * 64, y * 64, null);
			}
		}
	}
	
	private void readTiles(BufferedImage image) {
		int[] pixels = new int[width * height];
		SpriteSheet.map.getRGB(0, 0, width, height, pixels, 0, 1);
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				int col = pixels[x + y * width] & 0xffffff;
				
				if(col == 0xbbbbbb) walls[x + y * width] = 1;
			}
		}
	}
}