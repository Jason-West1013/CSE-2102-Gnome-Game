package Game;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640, HEIGHT = 480;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Swordman is the GOAT", this);
	}
	
	public synchronized void start() {}
	
	public void run() {}

	public static void main(String[] args) {
		new Game();
	}
}