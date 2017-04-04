package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PresentMap extends GameObject {
	Rectangle floor = new Rectangle(0, 376, 634, 64);
	Rectangle pillar = new Rectangle(288, 0, 64, 376);

	public PresentMap(int x, int y, ObjectID id) {
		super(x, y, id);
	}

	public void update() {
	}

	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);

		g.fill(floor);
		g.fill(pillar);
	}
}