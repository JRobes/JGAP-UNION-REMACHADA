
import java.util.List;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.DeltaFitnessEvaluator;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.SwappingMutationOperator;

import math.geom2d.Point2D;

public class OptimizarUnionRemachada {
	private static final int NUMBER_OF_EVOLUTIONS = 5000;
	// The amount of boxes used to move things from one location to the other. The number of boxes determines the number of genes.
	private static final int NUMBER_OF_ELEMENTS_AT_ONCE = 20;
    private static final int SIZE_OF_POPULATION = 50;
    
	double forceFh = 2000;
	double forceFv = 2320;
	Point2D loadPoint = new Point2D(105,300);

	
	public OptimizarUnionRemachada() throws Exception {
		Genotype genotype = this.configureJGAP();
		this.evolve(genotype);
	}
	private Genotype configureJGAP() throws InvalidConfigurationException {
		Configuration gaConf = new DefaultConfiguration();
		// Here we specify a fitness evaluator where lower values means a better fitness
		Configuration.resetProperty(Configuration.PROPERTY_FITEVAL_INST);
		gaConf.setFitnessEvaluator(new DeltaFitnessEvaluator());

		// Only use the swapping operator. Other operations makes no sense here
		// and the size of the chromosome must remain constant
		gaConf.getGeneticOperators().clear();
		SwappingMutationOperator swapper = new SwappingMutationOperator(gaConf);
		gaConf.addGeneticOperator(swapper);

        // We are only interested in the most fittest individual
        gaConf.setPreservFittestIndividual(true);
		gaConf.setKeepPopulationSizeConstant(true);
		
		gaConf.setPopulationSize(SIZE_OF_POPULATION);
	      // The number of chromosomes is the number of boxes we have. Every chromosome represents one box.
        
		Genotype genotype;

		// Setup the structure with which to evolve the solution of the problem.
        // An IntegerGene is used. This gene represents the index of a box in the boxes array.
		IChromosome sampleChromosome = new Chromosome(gaConf, new IntegerGene(gaConf), 4);
		gaConf.setSampleChromosome(sampleChromosome);
        // Setup the fitness function
		RemachesFitnessFunction01 fitnessFunction = new RemachesFitnessFunction01();
		fitnessFunction.setForceFh(this.forceFh);
		fitnessFunction.setForceFv(this.forceFv);
		fitnessFunction.setForcePoint(this.loadPoint);

		gaConf.setFitnessFunction(fitnessFunction);

		// Because the IntegerGenes are initialized randomly, it is neccesary to set the values to the index. Values range from 0..boxes.length
		genotype = Genotype.randomInitialGenotype(gaConf);
	/*
		List chromosomes = genotype.getPopulation().getChromosomes();
  
		for (Object chromosome : chromosomes) {
            IChromosome chrom = (IChromosome) chromosome;
            for (int j = 0; j < chrom.size(); j++) {
                Gene gene = chrom.getGene(j);
                gene.setAllele(j);
            }
        }
        */

		return genotype;
		
	}

	
	private void evolve(Genotype a_genotype) {
        long startTime = System.currentTimeMillis();
        int repeticionDeMinimo = 0;
		double previousFittestMoment = a_genotype.getFittestChromosome().getFitnessValue();

        for (int i = 0; i < NUMBER_OF_EVOLUTIONS; i++) {
        	
			a_genotype.evolve();
			double fittnessMoment = a_genotype.getFittestChromosome().getFitnessValue();

			if (fittnessMoment < previousFittestMoment) {
				this.printSolution(a_genotype.getFittestChromosome());
				previousFittestMoment = fittnessMoment;
				repeticionDeMinimo = 0;
			}
			else{
				repeticionDeMinimo++;
			}
			if(repeticionDeMinimo > 20)break;
	     	
        	
        }
       long endTime = System.currentTimeMillis();
	    System.out.println("computation time = " + (endTime - startTime));
        IChromosome fittest = a_genotype.getFittestChromosome();

        this.printSolution(fittest);
	}
	
	
	private void printSolution(IChromosome fittest) {
		
	}
	public static void main(String[] args) throws Exception {

		new OptimizarUnionRemachada();


	}

}
