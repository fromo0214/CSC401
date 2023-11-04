//Fernando Romo
//A thief breaks into a house, carrying a knapsack, each item has some weight and value. The knapsack has a capacity of N lbs.

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem{

    public static int knapsack(int[] items, int[] weights, int[] values, int capacity){
        //number of items
        int n = items.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        //initializing dynamic programming table
        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= capacity; w++){
                if(i == 0 || w == 0){
                    dp[i][w] = 0;
                }  
                else if(weights[i - 1] <= w){
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                }else{
                    dp[i][w] = dp[i - 1][w];
                }

            }
        }

        //reconstruct the selected items
        List<Integer> selected_items = new ArrayList<>();
        int i = n;
        int w = capacity;
        while(i > 0 && w > 0){
            if(dp[i][w] != dp[i-1][w]){
                selected_items.add(items[i - 1]);
                w -= weights[i - 1];
            }
            i--;
        }
        System.out.println("The stolen items: " + selected_items);
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int[] items =   {1, 2, 3, 4, 5};
        int[] weights = {2, 2, 3, 4, 5};
        int[] values =  {3, 4, 5, 8, 2};
        //total weight of the knapsack
        int capacity = 100;//lbs

        int maxValue = knapsack(items, weights, values, capacity);
        System.out.println("The capacity in the knapsack is: " + capacity +" lbs.");
        System.out.println("Max value: $" + maxValue);

    }
}
