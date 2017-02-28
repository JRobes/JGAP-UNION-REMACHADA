package sebor.math;

import math.geom2d.Point2D;

public class Recta2D {
	private static double Xo,Yo;
	private static double Vx,Vy;
	private static double m,b;
	private boolean esRectaVertical = false;
	
	public void Recta2D(double xo, double yo, double vx, double vy){
		if(Math.abs(vx)<0.00000001){
			if(Math.abs(vy)<0.00000001){
				//Recta mal definida
				System.out.println("Recta mal definida");
			}
			else{
				//Recta vertical X = x0
				esRectaVertical = true;
				this.Vx = 0;
				this.Vy = vy;
				this.Xo = xo;
				this.Yo = yo;
			}
		}
		else{
			if(Math.abs(vy)<0.00000001){
				//Recta horizontal
				this.Vx = vx;
				this.Vy = 0;
				this.m = vy/vx;
				this.b = yo-(xo/vy);
				this.Xo = xo;
				this.Yo = yo;
			}
			else{
				this.Vx = vx;
				this.Vy = vy;
				this.m = 0;
				this.b = yo;
				this.Xo = xo;
				this.Yo = yo;
			}
			
		}
		
	}

	public void Recta2D(Point2D P1, Point2D P2){
		Recta2D(P1.getX(), P1.getY(), P2.getX(), P2.getY());
	}
	
	

	public double getDistanceToPoint(double Px, double Py){
		return 0;
		
	}


	public static double getXo() {
		return Xo;
	}


	public static void setXo(double xo) {
		Xo = xo;
	}


	public static double getYo() {
		return Yo;
	}


	public static void setYo(double yo) {
		Yo = yo;
	}


	public static double getVx() {
		return Vx;
	}


	public static void setVx(double vx) {
		Vx = vx;
	}


	public static double getVy() {
		return Vy;
	}


	public static void setVy(double vy) {
		Vy = vy;
	}


	public static double getM() {
		return m;
	}


	public static void setM(double m) {
		Recta2D.m = m;
	}


	public static double getB() {
		return b;
	}


	public static void setB(double b) {
		Recta2D.b = b;
	}
}
