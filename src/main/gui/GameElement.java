package main.gui;

import java.io.Serializable;

public abstract class GameElement implements Serializable {
	private Point position;
	protected double orientation;
	public static final long serialVersionUID = 14;

	public double getPosX() {
		return this.position.getX();
	}

	public void setPosX(double _x) {
		this.position.setX(_x);
	}

	public double getPosY() {
		return this.position.getY();
	}

	public void setPosY(double _y) {
		this.position.setY(_y);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}

	abstract public void setPosition();
	abstract public void setOrientation();
	abstract public void init();

}
