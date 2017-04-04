package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import Graphics.Background;
import Input.InputHandler;
import Objects.ObjectHandler;
import Objects.ObjectID;
import Objects.Player;
import Objects.PresentMap;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640, HEIGHT = 480;

	private Thread thread;
	private Player player;

	private boolean running = false;

	public static ObjectHandler objectHandler;
	private Background bg, cloud, moon;

	public Game() {
		player = new Player(100, 344, ObjectID.PLAYER);

		objectHandler = new ObjectHandler();

		bg = new Background("/Sky.gif", 0.3, player);
		bg.setAutoScroll(-0.05, 0);
		moon = new Background("/Moon.gif", 0.3, player);
		moon.setAutoScroll(-0.05, 0);
		cloud = new Background("/Clouds.gif", 1, player);
		cloud.setAutoScroll(-0.1, 0);

		new Window(WIDTH, HEIGHT, "Swordman", this);

		objectHandler.addObject(new PresentMap(0, 0, ObjectID.MAP));
		objectHandler.addObject(player);

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
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
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
				update();
				updates++;

				delta--;
			}

			render();
			frames++;

			if ((System.currentTimeMillis() - timer) >= 1000) {
				timer += 1000;

				System.out.println("UPS: " + updates + ", FPS: " + frames);
				updates = 0;
				frames = 0;
			}
		}
	}

	public void update() {
		bg.update();
		moon.update();
		cloud.update();
		objectHandler.update();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// START DRAWING TO SCREEN
		bg.render(g);
		moon.renderAlone(g);
		cloud.render(g);
		objectHandler.render(g);
		// STOP DRAWING TO SCREEN
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}