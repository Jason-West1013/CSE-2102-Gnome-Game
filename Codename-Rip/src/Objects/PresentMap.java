package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PresentMap extends GameObject {

	public PresentMap(int x, int y, ObjectID id) {
		super(x, y, id);
	}

	public void update() {
		
	}

	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);
		
		Rectangle floor = new Rectangle(0, 376, 635, 64);
		g.fill(floor);
		
		Rectangle pillar = new Rectangle(300, 0, 64, 376);
		g.fill(pillar);
	}
}