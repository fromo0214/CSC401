public class Individual {
    private double[] genes;
    private double fitness = 0;
    private int geneLength;

    public Individual(double[] genes) {
        this.genes = genes;
        // this.geneLength = geneLength;
        this.fitness = 0;
        genes = new double[geneLength];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = -5.12 + Math.random() * (5.12 - (-5.12)); // Random values between -5.12 and 5.12
        }
    }

    public double getFitness() {
        if (fitness == 0) {
            fitness = calculateFitness();
        }
        return fitness;
    }

    private double calculateFitness() {
        double sum = 0;
        for (double gene : genes) {
            sum += gene * gene - 10 * Math.cos(2 * Math.PI * gene);
        }
        return 10 * genes.length + sum;
    }

    public double[] getGenes() {
        return genes;
    }

    public void setGene(int index, double value) {
        genes[index] = value;
        fitness = 0;
    }

    public int getGeneLength() {
        return geneLength;
    }
}