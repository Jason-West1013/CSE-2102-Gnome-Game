package Graphics;

import Main.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**********************************************************
 * Draws a background image. Can be scrolled based on the
 * player's position or can scroll automatically. 
 **********************************************************/
public class Background {

	private BufferedImage _image;

	// Scrolling speed
	private double _x;
	private double _y;
	
	// Automatic scroll speed.
	private double _dx; 
	private double _dy;
	
	public Background(String file) {
		try {
			_image = ImageIO.read(Background.class.getResource(file)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public Background(String file, double moveScale, Player player) {
		try {
			_image = ImageIO.read(Background.class.getResource(file)); 
			_moveScale = moveScale;
			_player = player;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**********************************************************
	 * Sets the speed at which the background image will scroll 
	 * across the screen. 
	 **********************************************************/
	public void setAutoScroll(double dx, double dy) {
		_dx = dx;
		_dy = dy;
	}

	/**********************************************************
	 * Updates the image so it can be scrolled. 
	 **********************************************************/
	public void update() {
		_x += _dx;
		_y += _dy;

		//if ((InputHandler.keys[InputHandler.A] == true) && (_player.getX() <= Player.MAX_LEFT_TRAVEL)) _x += _moveScale;
		//if ((InputHandler.keys[InputHandler.D] == true) && (_player.getX() >= Player.MAX_RIGHT_TRAVEL)) _x -= _moveScale;
	}

	/**********************************************************
	 * Draws the image on the screen. If the screen is moved in 
	 * any direction in the x-axis it draws another image next 
	 * to the current. 
	 * 
	 *     !! Only draws one image on each side currently!!
	 **********************************************************/
	public void render(Graphics2D g) {
		g.drawImage(_image, (int) _x, (int) _y, null);
		
		if (_x < 0) g.drawImage(_image, (int) _x + Game.WIDTH, (int) _y, null);
		if (_x > 0) g.drawImage(_image, (int) _x - Game.WIDTH, (int) _y, null);
		
	}

	/**********************************************************
	 * Used to render an image and not duplicate it to the sides.
	 **********************************************************/
	public void renderAlone(Graphics2D g) {
		g.drawImage(_image, (int) _x, (int) _y, null);
	}
}