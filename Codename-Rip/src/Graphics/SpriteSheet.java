package Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//PINK: ff009c
//PURPLE: ff54c5

public class SpriteSheet {
	public static BufferedImage[][] tiles = split(scale(load("/SpriteSheet.png"), 2), 64, 64);

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
				spriteList[x][y] = image.getSubimage(x, y, xSize, ySize);
			}
		}
		return spriteList;
	}
}