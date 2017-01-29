package com.game.object;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class ObjectHandler {
	private LinkedList<GameObject> _objectList = new LinkedList<GameObject>();

	public ObjectHandler(GameObject object) {
		_objectList.add(object);
	}
	
	public void tick() {
		for (int i = 0; i < _objectList.size(); i++) {
			GameObject tempObject = _objectList.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics2D g) {
		for (int i = 0; i < _objectList.size(); i++) {
			GameObject tempObject = _objectList.get(i);

			tempObject.render(g);
		}
	}

	public void removeObject(GameObject object) {
		_objectList.remove(object);
	}
}
