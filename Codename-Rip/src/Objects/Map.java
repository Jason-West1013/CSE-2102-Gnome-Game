package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.SpriteSheet;
import Main.Game;

public class Map extends GameObject {
	private int width = SpriteSheet.map.getWidth();
	private int height = SpriteSheet.map.getHeight();

	public static int xScroll = 0, yScroll = 0;
	
	private byte[] walls = new byte[width * height];
	
	private Player player;

	public Map(int x, int y, ObjectID id, Player player) {
		super(x, y, id);

		this.player = player;
		
		this.readTiles(SpriteSheet.map);
	}

	public void update() {

	}

	public void render(Graphics2D g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if(walls[x + y * width] == 1) {
					g.setColor(Color.RED);
					g.fillRect(x * 64, y * 64, 64, 64);
				}
			}
		}
	}

	private void readTiles(BufferedImage image) {
		int[] pixels = SpriteSheet.map.getRGB(0, 0, width, height, null, 0, width);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int color = pixels[x + y * width] & 0xffffff;

				if (color == 0xffffff) {
					walls[x + y * width] = 1;
			
					Game.objectHandler.addObject(new Tile(x * 64,y * 64, ObjectID.TILE, player));
				}
			}
		}
	}
}