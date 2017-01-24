package Game;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private boolean running = false;

	private Thread thread;

	public static final int WIDTH = 640, HEIGHT = 480;

	public Game() {
		new Window(WIDTH, HEIGHT, "Swordman", this);
		this.requestFocus();
	}

	public synchronized void start() {
		running = true;

		thread = new Thread(this);
		thread.start();
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
				System.out.println("UPS: " + updates + ", FPS: " + frames);

				updates = 0;
				frames = 0;

				timer += 1000;
			}
		}
	}

	public void tick() {
	}

	public void render() {
	}

	public static void main(String[] args) {
		new Game();
	}
}