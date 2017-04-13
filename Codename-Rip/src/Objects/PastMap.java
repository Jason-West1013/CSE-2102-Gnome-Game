package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PastMap extends GameObject {
	Rectangle floor = new Rectangle(0, 376, 634, 64);

	public PastMap(int x, int y, ObjectID id) {
		super(x, y, id);
	}

	public void update() {
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);

		g.fill(floor);
	}
}