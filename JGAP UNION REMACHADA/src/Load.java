
import math.geom2d.Point2D;
import math.geom2d.Vector2D;
public class Load {
	private Point2D puntoAplicacion;
	
	private Vector2D force;
	private double momento;
	
	
	
	public Vector2D getForce() {
		return force;
	}
	public void setForce(Vector2D force) {
		this.force = force;
	}
	public math.geom2d.Point2D getPuntoAplicacion() {
		return puntoAplicacion;
	}
	public void setPuntoAplicacion(Point2D remache) {
		this.puntoAplicacion = remache;
	}
	public double getMomento() {
		return momento;
	}
	public void setMomento(double momento) {
		this.momento = momento;
	}
	
	
	
	

}
