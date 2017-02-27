import math.geom2d.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;


@SuppressWarnings("serial")
public class RemachesFitnessFunction01 extends FitnessFunction {
	private double Fh = 0,Fv=0;
	private Point2D loadPoint;
	//private DatosIniciales datosIniciales;
	//private int numeroTotalDeRemaches;
	
	
	@Override
	protected double evaluate(IChromosome the_chromosome) {
		List<Point2D> remaches = new ArrayList<Point2D>();
		Point2D centroid;
		
		for (int i = 0 ; i < the_chromosome.size(); i++) {
			Point2D remache = fromChromosomeToPoint((Integer)the_chromosome.getGene(i).getAllele());
			
			remaches.add(remache);
		}
		
		centroid = getCentroid(remaches);
		
	
		return 0;
	}

	private Point2D getCentroid(List<Point2D> remaches){
		double centroid_x = 0, centroid_y = 0;
		for(int i = 0; i < remaches.size(); i++){
			centroid_x = centroid_x +remaches.get(i).getX();
			centroid_y = centroid_y +remaches.get(i).getY();
		}
		if( remaches.size() == 0) return null;
		return new Point2D(centroid_x/remaches.size(),centroid_y/remaches.size());
	}
	
	private Point2D fromChromosomeToPoint(int allele) {
		int componente_x = 0, componente_y = 0, divisionEntera;
		componente_x = allele/100;
		divisionEntera = (int)componente_x;
		componente_y = allele - divisionEntera*100;
		
		return new Point2D(componente_x, componente_y);
	}


	public void setForceFh(double forceFh) {
		this.Fh = forceFh;
	}

	public void setForceFv(double forceFv) {
		this.Fv = forceFv;
		
	}

	public void setForcePoint(Point2D loadPoint) {
		this.loadPoint = loadPoint;
	}
	private void printPoint2D(Point2D p){
		System.out.println("Componente X:\t"+p.getX()+"\tComponente Y:\t"+ p.getY());
	}

}
