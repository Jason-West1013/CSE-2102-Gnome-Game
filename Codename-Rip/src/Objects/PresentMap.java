package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Graphics.SpriteSheet;

public class PresentMap extends GameObject {
	Rectangle floor = new Rectangle(0, 376, 634, 64);
	Rectangle pillar = new Rectangle(288, 0, 64, 376);

	public PresentMap(int x, int y, ObjectID id) {
		super(x, y, id);
	}

	public void update() {
	}

	public void render(Graphics2D g) {
		g.drawImage(SpriteSheet.floor,0,375,null);
		g.drawImage(SpriteSheet.pillar,282,175,null);
		g.setColor(Color.GREEN);
	}
}