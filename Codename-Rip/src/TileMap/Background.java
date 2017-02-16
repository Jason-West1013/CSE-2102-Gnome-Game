package TileMap;

import Main.Game;
import Objects.Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Input.InputHandler;

public class Background {

	private BufferedImage _image;
	private Player _player;

	private double _x;
	private double _y;
	private double _dx;
	private double _dy;

	private double moveScale;

	public Background(String file, double moveScale, Player player) {
		_player = player;

		try {
			_image = ImageIO.read(Background.class.getResource(file));

			this.moveScale = moveScale;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setVector(double dx, double dy) {
		_dx = dx;
		_dy = dy;
	}

	public void update() {
		_x += _dx;
		_y += _dy;

		if ((InputHandler.keys[InputHandler.A] == true) && (_player.getX() == Player.MAX_LEFT_TRAVEL)) _x += moveScale;
		if ((InputHandler.keys[InputHandler.D] == true) && (_player.getX() == Player.MAX_RIGHT_TRAVEL)) _x -= moveScale;
	}

	public void render(Graphics2D g) {
		g.drawImage(_image, (int) _x, (int) _y, null);

		if (_x < 0) 
			g.drawImage(_image, (int) _x + Game.WIDTH, (int) _y, null);
		if (_x > 0) 
			g.drawImage(_image, (int) _x - Game.WIDTH, (int) _y, null);
	}

	public void renderAlone(Graphics2D g) {
		g.drawImage(_image, (int) _x, (int) _y, null);
	}
}