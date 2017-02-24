import math.geom2d.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;


@SuppressWarnings("serial")
public class RemachesFitnessFunction01 extends FitnessFunction {

	//private DatosIniciales datosIniciales;
	//private int numeroTotalDeRemaches;
	
	
	@Override
	protected double evaluate(IChromosome the_chromosome) {
		List<Point2D> remaches = new ArrayList<Point2D>();
		
		for (int i = 0 ; i < the_chromosome.size(); i++) {
			Point2D remache = fromChromosomeToPoint((Integer)the_chromosome.getGene(i).getAllele());
			
			Point2D punto = new Point2D((Double)the_chromosome.getGene(i).getAllele(),(Double)the_chromosome.getGene(i+1).getAllele());
			remaches.add(punto);
		}
	
		return 0;
	}

	
	private Point2D fromChromosomeToPoint(int allele) {
		return null;
	}


	public void setForceFh(double forceFh) {
		// TODO Auto-generated method stub
		
	}

	public void setForceFv(double forceFv) {
		// TODO Auto-generated method stub
		
	}

	public void setForcePoint(Point2D loadPoint) {
		// TODO Auto-generated method stub
		
	}

}
