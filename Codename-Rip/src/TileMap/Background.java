package TileMap;

import Main.Game;
import Objects.GameObject;
import Objects.Player;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Input.InputHandler;

import javax.imageio.ImageIO;

public class Background  {
	
	private BufferedImage _image;
	private Player _player;
	
	private double _x;
	private double _y;
	private double _dx;
	private double _dy;
	
	// Used to scale the screen as the character moves. 
	private double _moveScale;
	
	/*********************************************
	 * Constructor loads the file and receives the 
	 * scale of movement. 
	 *********************************************/
	public Background(String s, double ms, Player player) {
		_player = player;
		try {
			_image = ImageIO.read(new File(s)); // Gets object from resources. 
			_moveScale = ms; // Scrolling the background variable. 
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	/********************************************
	 * Used to create an automatic scrolling 
	 * background.
	 ********************************************/
	public void setVector(double dx, double dy) {
		_dx = dx;
		_dy = dy;
	}
	
	/********************************************
	 * Updates the movement of the background 
	 * scrolling based on either the vector or 
	 * the player's movement. 
	 ********************************************/
	public void update() {
		_x += _dx;
		_y += _dy;
		
		if((InputHandler.keys[InputHandler.A] == true) && (_player.getX() == _player.getMaxLeft())) 
			_x += _moveScale;
		if((InputHandler.keys[InputHandler.D] == true) && (_player.getX() == _player.getMaxRight())) 
			_x -= _moveScale;
	}
	
	/********************************************
	 * Draw the image on the screen, also draws an 
	 * extra image if the player gets to an area
	 * where the screen starts to move. 
	 ********************************************/
	public void render(Graphics2D g) {
		g.drawImage(_image, (int)_x, (int)_y, null);
		
		 //Wrap-around feature. 
		if(_x < 0)
			g.drawImage(_image, (int)_x + Game.WIDTH, (int)_y, null);
		if(_x > 0)
			g.drawImage(_image, (int)_x - Game.WIDTH, (int)_y, null);
	}
	
	public void renderAlone(Graphics2D g) {
		g.drawImage(_image, (int)_x, (int)_y, null);
	}

}
