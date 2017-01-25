package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.game.input.InputHandler;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private boolean running = false;

	private Thread thread;

	int x = 200, y = 200;

	public static final int WIDTH = 640, HEIGHT = 480;

	public Game() {
		new Window(WIDTH, HEIGHT, "Swordman with time and stuff", this);
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
		if (InputHandler.keys[0] == true) {
			y--;
		}
		if (InputHandler.keys[1] == true) {
			x--;
		}
		if (InputHandler.keys[2] == true) {
			y++;
		}
		if (InputHandler.keys[3] == true) {

			x++;
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 50);

		g.setColor(Color.RED);
		g.fillRect(x, y, 10, 10);

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}