
import java.util.*;

public class NaiveTSM {

    public static List<Integer> naiveTSP(int[][] matrix){
        int n = matrix.length;
        int startCity = 0;
        int[] otherCities = new int [n-1];

        for(int i = 0, j = 0; i < n; i++){
            
            //if the index is not at the starting vertice, increments 
            if(i != startCity){
                otherCities[j++] = i;
            }
        }
        
        int minDistance = Integer.MAX_VALUE;
        ArrayList<Integer> bestRoute = new ArrayList<>();
        //generates permuations of otherCities
        permute(otherCities, 0 ,minDistance, bestRoute,startCity, matrix);

        bestRoute.add(0, startCity);
        return bestRoute;
    }

//recursive method that gets all possible permutations of otherCities 
public static void permute(int[] otherCities, int index, int minDistance, ArrayList<Integer> bestRoute, int startCity, int[][] matrix) {
        //checks if index has reached the length of the otherCities array
        if(index == otherCities.length){
            int currentDistance = calculateTotalDistance(startCity, otherCities, matrix);
            //if a permutation is represents a shorter route it sets min distance to the permutation found
            if(currentDistance < minDistance){
                minDistance = currentDistance;
                //clears the list to store the new permutation
                bestRoute.clear();
                for(int city : otherCities){
                    bestRoute.add(city);
                }

            }
        }else{
            for(int i = index; i < otherCities.length; i++){
                swap(otherCities, index, i);
                permute(otherCities, index + 1, minDistance, bestRoute, startCity, matrix);
                swap(otherCities, index, i);
            }
        }
      
    }

//method to swap elements in an array, creates a temp placeholder to store elements
public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp; 
}


public static int calculateTotalDistance(int startCity, int[] route, int[][] matrix){
    //accumulate the total distance of the route
    int totalDistance = 0;

    int currentCity = startCity;

    //for each city in the route, adds distance from current city to the next city
    for(int nextCity : route){
        totalDistance += matrix[currentCity][nextCity];
        currentCity = nextCity;
    }

    totalDistance += matrix[currentCity][startCity];

    return totalDistance;
}

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 34, 21, 15},
            {20, 0, 5, 17},
            {40, 12, 2, 3},
            {3, 23, 30, 1}
        };
        List<Integer> bestRoute = naiveTSP(matrix);
        //I used chatgpt as a resource to find out how to get the best route in an array to display the minimum distance
        int minDistance = calculateTotalDistance(0, bestRoute.stream().mapToInt(Integer::intValue).toArray(), matrix);

        System.out.println("Best route: "+ bestRoute);
        System.out.println("Minimum distance: "+ minDistance);



    }
    
}