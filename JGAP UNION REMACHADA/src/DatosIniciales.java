import math.geom2d.Point2D;

import math.geom2d.Vector2D;


public class DatosIniciales {
	public Point2D puntoAplicacionFuerza;
	public Vector2D fuerza;
	public int dimensionChapa_x;
	public int dimensionChapa_y;
	public int numeroRemaches;
	public double diametroRemache;
	public DatosIniciales(
			Point2D a_puntoAplicacionFuerza,
			Vector2D a_fuerza,
			int a_dimensionChapa_x,
			int a_dimensionChapa_y,
			int a_numeroRemaches,
			double a_diametroRemache) {
		
		puntoAplicacionFuerza = a_puntoAplicacionFuerza;
		fuerza = a_fuerza;
		dimensionChapa_x = a_dimensionChapa_x;
		dimensionChapa_y = a_dimensionChapa_y;
		numeroRemaches = a_numeroRemaches;
		diametroRemache = a_diametroRemache;
	
	}
	

}
