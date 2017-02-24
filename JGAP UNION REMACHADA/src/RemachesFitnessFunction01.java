import math.geom2d.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;


@SuppressWarnings("serial")
public class RemachesFitnessFunction01 extends FitnessFunction {

	//private DatosIniciales datosIniciales;
	private int numeroTotalDeRemaches;
	List<Point2D> remaches = new ArrayList<Point2D>();
	
	@Override
	protected double evaluate(IChromosome arg0) {
		
		for (int i = 0 ; i < arg0.size(); i = i + 2) {
			
			Point2D punto = new Point2D((Double)arg0.getGene(i).getAllele(),(Double)arg0.getGene(i+1).getAllele());
			remaches.add(punto);
		}
		
		//UnionRemachada unionRemachada = new UnionRemachada(this.remaches, this.datosIniciales); 
		//unionRemachada.testInterfenciaRemaches(remaches, datosIniciales);
		
		return 0;
	}

	public int getNumeroTotalDeRemaches() {
		return numeroTotalDeRemaches;
	}

	public void setNumeroTotalDeRemaches(int numeroTotalDeRemaches) {
		this.numeroTotalDeRemaches = numeroTotalDeRemaches;
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
