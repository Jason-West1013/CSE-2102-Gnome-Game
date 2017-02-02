package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import Input.InputHandler;
import Objects.ObjectHandler;
import Objects.ObjectID;
import Objects.Player;
import TileMap.Background;

/**********************************************
 * Main game class, contains the main game loop.
 **********************************************/
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640, HEIGHT = 480, SCALE = 2;
	private Thread thread; // Single Thread.
	Player _player;

	private boolean running = false;

	private ObjectHandler objectHandler;
	Background _bg, _cloud, _moon;

	public Game() {
		_player = new Player(100, 300, ObjectID.PLAYER);
		objectHandler = new ObjectHandler();
		// Drawing all the backgrounds, should find a better way to do this. 
		_bg = new Background("art/sky.gif", 0.3, _player);
		_bg.setVector(-0.05,0);
		_moon = new Background("art/Moon.gif", 0.3, _player);
		_moon.setVector(-0.05,0);
		_cloud = new Background("art/Clouds.gif", 1, _player);
		_cloud.setVector(-0.1,0);
		new Window(WIDTH, HEIGHT, "Swordman", this);
		
		// Game Additions.
		objectHandler.addObject(_player);
		this.addKeyListener(new InputHandler());
		this.requestFocus();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join(); // Stops thread.
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace(); // Run an error to the console.
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();

		double amountOfTicks = 60.0;
		double nsPerTick = 1000000000 / amountOfTicks;
		double delta = 0.0;

		int updates = 0;
		int frames = 0;

		while (running) {
			long now = System.nanoTime();

			delta += (now - lastTime) / nsPerTick;
			lastTime = now;

			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			
			if(running)
				render();
			frames++;

			if ((System.currentTimeMillis() - timer) >= 1000) {
				timer += 1000;
				System.out.println("UPS: " + updates + ", FPS: " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	/**********************************************
	 * Updates the game. Calls object handler that renders and manipulates all
	 * sprites.
	 **********************************************/
	public void tick() {
		objectHandler.tick();
		_bg.update();
		_moon.update();
		_cloud.update();
	}

	/**********************************************
	 * Draws objects on the screen.
	 **********************************************/
	public void render() {
		BufferStrategy bs = this.getBufferStrategy(); // Starts off with null. 

		if (bs == null) {
			this.createBufferStrategy(3); // Creates 3 images on top of each other. Stay under 3. 
			return;
		}

		// Draws background on the window the screen.
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		// START DRAWING TO SCREEN
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		_bg.render(g);
		_moon.renderAlone(g);
		_cloud.render(g);
		objectHandler.render(g);

		// STOP DRAWING TO SCREEN
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}