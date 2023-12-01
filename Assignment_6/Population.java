public class Population {
    private Individual[] individuals;

    //declaring the Rastrigin values
    private final double MIN_VALUE = -5.12;
    private final double MAX_VALUE = 5.12;


    public Population(int populationSize, int geneLength) {
        individuals = new Individual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            double[] genes = new double[geneLength];
            for(int j = 0; j < geneLength; j++){
                genes[j] = MIN_VALUE + Math.random() * (MAX_VALUE - (MIN_VALUE));
            }
            individuals[i] = new Individual(genes);
        }
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        for (int i = 1; i < individuals.length; i++) {
            if (fittest.getFitness() > individuals[i].getFitness()) {
                fittest = individuals[i];
            }
        }
        return fittest;
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public int getGeneLength(){
        return individuals[0].getGeneLength();
    }

    public void setIndividual(int index, Individual individual){
        individuals[index] = individual;
    }
}