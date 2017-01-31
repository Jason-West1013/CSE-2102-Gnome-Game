package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import input.InputHandler;
import object.ObjectHandler;
import object.ObjectID;
import object.Player;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640, HEIGHT = 480, SCALE = 2;

	private boolean running = false;

	private ObjectHandler objectHandler;
	private Thread thread;

	public Game() {
		new Window(WIDTH, HEIGHT, "Swordman", this);

		objectHandler = new ObjectHandler();
		objectHandler.addObject(new Player((this.getWidth() / 2) - 16, (this.getHeight() / 2) - 16, ObjectID.PLAYER));

		this.addKeyListener(new InputHandler());
		this.requestFocus();
	}

	public synchronized void start() {
		running = true;

		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		running = false;

		try {
			thread.join();
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
				tick();
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

	public void tick() {
		objectHandler.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		// START DRAWING TO SCREEN
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		objectHandler.render(g);
		// STOP DRAWING TO SCREEN
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}