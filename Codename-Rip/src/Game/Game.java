package Game;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "SwordMan", this);
	}
	
	public synchronized void start() {}
	
	public void run() {}

	public static void main(String[] args) {
		new Game();
		
	}

}
