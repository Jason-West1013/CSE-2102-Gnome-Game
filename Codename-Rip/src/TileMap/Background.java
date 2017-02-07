package TileMap;

import Main.Game;
import Objects.Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Input.InputHandler;

public class Background {

	private BufferedImage image;
	private Player player;

	private double x;
	private double y;
	private double dx;
	private double dy;

	private double moveScale;

	public Background(String file, double moveScale, Player player) {
		this.player = player;

		try {
			image = ImageIO.read(Background.class.getResource(file));

			this.moveScale = moveScale;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void update() {
		x += dx;
		y += dy;

		if ((InputHandler.keys[InputHandler.A] == true) && (player.getX() == Player.MAX_LEFT_TRAVEL)) x += moveScale;
		if ((InputHandler.keys[InputHandler.D] == true) && (player.getX() == Player.MAX_RIGHT_TRAVEL)) x -= moveScale;
	}

	public void render(Graphics2D g) {
		g.drawImage(image, (int) x, (int) y, null);

		if (x < 0) g.drawImage(image, (int) x + Game.WIDTH, (int) y, null);
		if (x > 0) g.drawImage(image, (int) x - Game.WIDTH, (int) y, null);
	}

	public void renderAlone(Graphics2D g) {
		g.drawImage(image, (int) x, (int) y, null);
	}
}