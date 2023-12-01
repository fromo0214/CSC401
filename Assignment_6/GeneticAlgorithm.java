import java.util.Random;

public class GeneticAlgorithm { 
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;

    //declaring the Rastrigin function values
    private final double MIN_VALUE = -5.12;
    private final double MAX_VALUE = 5.12;

    // private final Random rand = new Random();

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    // Methods for initialization, selection, crossover, mutation, and creating new generation
    // These are more complex and depend on your chosen approach for each step

    //replaces the population, by evolving them 
    public Population evolvePopulation(Population population) {
        Population newPopulation = new Population(populationSize, population.getGeneLength());

        for(int i = 0; i < elitismCount; i++){
            newPopulation.setIndividual(i, population.getFittest());
        }

        //crossover and mutate to create new individuals
        for(int i = elitismCount; i < populationSize; i++){
            Individual parent1 = selectIndividual(population);
            Individual parent2 = selectIndividual(population);

            Individual child = crossover(parent1, parent2);
            mutate(child);

            newPopulation.setIndividual(i, child);
        }

        return newPopulation;
    }

    private void mutate(Individual child) {
        double[] genes = child.getGenes();

        for(int i = 0; i < genes.length; i++){
            if(Math.random() < mutationRate){
                genes[i] = getRandomValue(MIN_VALUE, MAX_VALUE);
            }
        }
    }

    private Individual crossover(Individual parent1, Individual parent2) {
        double[] genes1 = parent1.getGenes();
        double[] genes2 = parent2.getGenes();
        double[] childGenes = new double[genes1.length];

        //choosing a random crossover point
        int crossoverPoint = (int) (Math.random() * genes1.length);

        //Take genes from the first parent until the crossover point
        for(int i = 0; i < crossoverPoint; i++){
            childGenes[i] = genes1[i];
        }

        //Take genes from the second parent after the crossover point
        for(int i = crossoverPoint; i < genes1.length; i++){
            childGenes[i] = genes2[i];
        }

        return new Individual(childGenes);
    }

    private Individual selectIndividual(Population population) {
        double totalFitness = 0;

        //Calculate the total fitness of the population
        for(Individual individual : population.getIndividuals()){
            totalFitness += individual.getFitness();
        }

        //Randomly select a point on the roulette wheel
        double rouletteWheelPosition = Math.random() * totalFitness;

        //Find the individual that corresponds to the selected position
        double currentSum = 0;
        for(Individual individual : population.getIndividuals()){
            currentSum += individual.getFitness();
            if(currentSum >= rouletteWheelPosition){
                return individual;
            }
        }
        return population.getIndividuals()[population.getIndividuals().length - 1];
    }

    public double[] initializePopulation(int geneLength){
        double[] genes = new double[geneLength];
        
        for(int i = 0; i < geneLength; i++){
            genes[i] = getRandomValue(MIN_VALUE, MAX_VALUE);
        }

        return genes;
    }

    private double getRandomValue(double minValue, double maxValue){
        return minValue + (maxValue - minValue) * Math.random();
    }

  
}


