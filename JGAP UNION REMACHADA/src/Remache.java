import math.geom2d.Point2D;

import math.geom2d.Vector2D;


public class Remache {
	private Point2D posicion;
	private Vector2D force;
	
	public Remache(Point2D a_posicion, Vector2D a_force) {
		setPosicion(a_posicion);
		setForce(a_force);
	}
	
	public double getModule() {
		return Math.pow(Math.pow(force.getX(), 2) + Math.pow(force.getY(), 2), 0.5);
	}
	
	public Point2D getPosicion() {
		return posicion;
	}
	public void setPosicion(Point2D posicion) {
		this.posicion = posicion;
	}
	
	public Vector2D getForce() {
		return force;
	}
	public void setForce(Vector2D force) {
		this.force = force;
	}
}
