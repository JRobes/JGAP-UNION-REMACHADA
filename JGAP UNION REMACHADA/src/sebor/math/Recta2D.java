package sebor.math;


public class Recta2D {
	private static double Xo,Yo;
	private static double X1,Y1;
	private static double Vx,Vy;
	private static Double m,b;
	private static boolean esRectaVertical = false;
	
	@SuppressWarnings("null")
	public Recta2D(double xo, double yo, double x1, double y1) throws Recta2DException{
		//ARREGLARRRRR
		double vx = x1-xo;
		double vy = y1-yo;
		if(Math.abs(vx) < 0.00000001){
			if(Math.abs(vy) < 0.00000001){
				//Recta mal definida
				throw new Recta2DException("Recta mal definida, con dos puntos coincidentes");
				/*
				System.out.println("Recta mal definida");
				Recta2D.Vx = (Double) null;
				Recta2D.Vy = (Double) null;
				Recta2D.m = null;
				Recta2D.b = (Double) null;
				Recta2D.Xo = (Double) null;
				Recta2D.Yo = (Double) null;
				Recta2D.esRectaVertical = (Boolean) null;
				*/
			}
			else{
				//Recta vertical X = x0
				esRectaVertical = true;
				Recta2D.Vx = 0;
				Recta2D.Vy = vy;
				Recta2D.Xo = xo;
				Recta2D.Yo = yo;
				Recta2D.m = null;
				Recta2D.b = (Double) null;

			}
		}
		else{
			if(Math.abs(vy) < 0.00000001){
				//Recta horizontal
				Recta2D.Vx = vx;
				Recta2D.Vy = 0;
				Recta2D.m = (Double)0.0;
				Recta2D.b = xo;
				Recta2D.Xo = xo;
				Recta2D.Yo = yo;
			}
			else{
				Recta2D.Vx = vx;
				Recta2D.Vy = vy;
				Recta2D.m = vy/vx;
				Recta2D.b = yo-(xo/vy);
				Recta2D.Xo = xo;
				Recta2D.Yo = yo;
			}
			
		}
		
	}

	public double getDistanceToPoint(double Px, double Py){
		if(esRectaVertical) return (Recta2D.Xo - Px);
		return Math.abs((Recta2D.m * Px) - Py + Recta2D.b) / Math.sqrt((Recta2D.m * Recta2D.m) + 1);
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


	public double getM() throws Recta2DException {
		if(this.m == null){
			//System.out.println("??????????????");
			throw new Recta2DException("Recta con pendiente infinita o null");
		}
		
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

	public static double getX1() {
		return X1;
	}

	public static void setX1(double x1) {
		X1 = x1;
	}

	public static double getY1() {
		return Y1;
	}

	public static void setY1(double y1) {
		Y1 = y1;
	}

	public boolean isEsRectaVertical() {
		return esRectaVertical;
	}
	public class Recta2DException extends Exception{
		public Recta2DException(String msg){
		      super(msg);
		   }
	}

}
