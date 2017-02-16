package Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpriteSheet {
	public static BufferedImage[][] playerOne = split(scale(load("/SpriteSheet.png"), 2), 64, 64);
	public static BufferedImage[][] playerTwo = mirrorSplit(scale(load("/SpriteSheet.png"), 2), 64, 64);
	public static BufferedImage[][] tiles = split(load("/Tiles.png"), 32, 32);
	
	public static BufferedImage map = load("/Map.png");

	public static BufferedImage load(String file) {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(file));

			return image;
		} catch (IOException e) {
			e.printStackTrace();

			return null;
		}
	}

	public static BufferedImage scale(BufferedImage image, int scale) {
		int width = image.getWidth() * scale;
		int height = image.getHeight() * scale;

		BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = scaledImage.createGraphics();

		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();

		return scaledImage;
	}

	public static BufferedImage[][] split(BufferedImage image, int xSize, int ySize) {
		int xSlices = image.getWidth() / xSize;
		int ySlices = image.getHeight() / ySize;

		BufferedImage[][] spriteList = new BufferedImage[xSlices][ySlices];

		for (int x = 0; x < xSlices; x++) {
			for (int y = 0; y < ySlices; y++) {
				spriteList[x][y] = image.getSubimage(x * xSize, y * ySize, xSize, ySize);
			}
		}
		return spriteList;
	}
	
	public static BufferedImage[][] mirrorSplit(BufferedImage image, int xSize, int ySize) {
		int xSlices = image.getWidth() / xSize;
		int ySlices = image.getHeight() / ySize;
		
		BufferedImage[][] spriteList = new BufferedImage[xSlices][ySlices];
		
		for(int x = 0; x < xSlices; x++) {
			for(int y = 0; y < ySlices; y++) {
                spriteList[x][y] = new BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = spriteList[x][y].createGraphics();
                
                g.drawImage(image, xSize, 0, 0, ySize, x * xSize, y * ySize, (x + 1) * xSize, (y + 1) * ySize, null);
                g.dispose();
			}
		}
		return spriteList;
	}
}