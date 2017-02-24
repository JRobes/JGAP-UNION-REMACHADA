//import java.awt.geom.Point2D;
import math.geom2d.Point2D;
import math.geom2d.Vector2D;
import math.geom3d.Point3D;
import math.geom3d.Vector3D;

import java.util.List;




public class UnionRemachada {
	private List<Point2D> remaches;
	private List<Load> loadCases;
	private DatosIniciales datosIniciales;
	private Point2D cdg;
	private Load cargaEquivalente;
	
	
	public UnionRemachada(List<Point2D> a_remaches, DatosIniciales a_datosIniciales) {
		remaches = a_remaches;
		datosIniciales = a_datosIniciales;
		setCdg();
		setCargaEquivalente();
		setLoadCases();
	}
	
	public double testInterfenciaRemaches(List<Point2D> a_remaches, DatosIniciales a_datosIniciales) {
		for(int i = 0; i < a_remaches.size(); i++) {
			for(int j = i + 1; j < a_remaches.size(); j++) {
				if(a_datosIniciales.diametroRemache > a_remaches.get(i).distance(a_remaches.get(j)))
					return 1000;
			}
		}
		
		return 0;
	}
	
	private void setCdg() {
		double x_coord =0, y_coord =0;
		for(Point2D remache : this.remaches){
			x_coord = x_coord + remache.getX();
			y_coord = y_coord + remache.getY();
			
		}
		
		if (this.remaches.size()==0)
		{}
		this.cdg = new Point2D(x_coord/this.remaches.size(), y_coord/this.remaches.size());
		
	}
	public Point2D getCdg() {
		
		return this.cdg;
		
	}
	private void setCargaEquivalente() {
		this.cargaEquivalente.setForce(this.datosIniciales.fuerza);
		this.cargaEquivalente.setMomento(getMomentoEquivalente());
		this.cargaEquivalente.setPuntoAplicacion(cdg);
		
		
	}
	
	public Load getCargaEquivalente() {
		
		return cargaEquivalente;
		
	}
	
	private double getMomentoEquivalente(){
		
		return this.datosIniciales.fuerza.norm() * this.getDistanciaPuntoRecta();
		
		
	}
	
	private double getDistanciaPuntoRecta() {
		
		//Es aqui donde hay que poner
		// d(A,D) = |a * xa - ya + b|/ (raiz(a^2 + 1))
		//con D recta y = a*x + b
		// la recta que pasa por el punto x_recta, y_recta
		// y tiene de vector la fuerza aplicada 
		// A el punto (xa,ya) corresponde con el cdg
		double a,b, x_recta, y_recta;
		x_recta = this.datosIniciales.puntoAplicacionFuerza.getX();
		y_recta = this.datosIniciales.puntoAplicacionFuerza.getY();
		
		if (this.datosIniciales.fuerza.getX() == 0.0) {
			
			
			return Math.abs(this.cdg.getX() - x_recta);
			
			
			
			//Math.abs(ya);
			//Math.sqrt(xa);
		}
		else {
			a = this.datosIniciales.fuerza.getY()/this.datosIniciales.fuerza.getX();
			b= -a*x_recta + y_recta;
			
			return Math.abs(a * this.cdg.getX() - this.cdg.getY() + b) / Math.sqrt(Math.pow(a,2) + 1);
		}
	}
	private void setLoadCases() {
		
		for(Point2D remache : this.remaches){
			
			Load o = new Load();
			o.setForce(this.cargaEquivalente.getForce().times(1.0/this.remaches.size()));
			o.setMomento(this.getMomentoEquivalente()/this.remaches.size());
			o.setPuntoAplicacion(remache);
			
			this.loadCases.add(o);
		}
		
	}
	
	
	private Vector2D calculateEquivalentForce(Point2D point1, Point2D the_cdg, double momentum) {
		
		Point3D origin = new Point3D(the_cdg.x(), the_cdg.y(), 0.0);
		Point3D end    = new Point3D(point1.x(), point1.y(), 0.0);
		Vector3D r     = new Vector3D(origin, end);
		Vector3D M     = new Vector3D(0.0, 0.0, momentum);
		Vector3D F     = new Vector3D();
		
		F = Vector3D.crossProduct(M, r);
		F = F.times(1/momentum);
		
		
		
		
		
		return new Vector2D(F.getX(),F.getX());
				
	}






}















