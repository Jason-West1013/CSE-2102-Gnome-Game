package Objects;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class ObjectHandler {
	private LinkedList<GameObject> _objectList = new LinkedList<GameObject>();
	
	/*********************************************
	 * Loops through all the objects in the game, 
	 * updates each one individually. 
	 *********************************************/
	public void tick() {
		for (int i = 0; i < _objectList.size(); i++) {
			GameObject tempObject = _objectList.get(i);
			tempObject.tick();
		}
	}

	/*********************************************
	 * Loops through all the objects in the game, 
	 * renders each one individually. 
	 *********************************************/
	public void render(Graphics2D g) {
		for (int i = 0; i < _objectList.size(); i++) {
			GameObject tempObject = _objectList.get(i);

			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		_objectList.add(object);
	}

	/*********************************************
	 * Removes an object from the game when called, 
	 * receives the object to be erased. 
	 *********************************************/
	public void removeObject(GameObject object) {
		_objectList.remove(object);
	}
}
