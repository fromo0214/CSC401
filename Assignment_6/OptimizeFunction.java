public class OptimizeFunction {
    public static void main(String[] args) {
        int geneLength = 10; // Number of dimensions for the Rastrigin function
        int populationSize = 100;
        double mutationRate = 0.01;
        double crossoverRate = 0.9;
        int elitismCount = 1;
        int maxGenerations = 1000;

        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize, mutationRate, crossoverRate, elitismCount);

        // Initialize population
        Population population = new Population(populationSize, geneLength);

        // Evolve population for a certain number of generations
        int generationCount = 0;
        while (generationCount < maxGenerations) {
            population = ga.evolvePopulation(population);
            generationCount++;
        }

        // Output the best solution found
        System.out.println("Finished");
        System.out.println("Best solution:");
        System.out.println(population.getFittest().getFitness());
    }
}