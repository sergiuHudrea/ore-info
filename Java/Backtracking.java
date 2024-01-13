import java.util.*;

public class Backtracking {
    // Time: O(n * len(arr) ^ n)
    // 2 ^ n solutions
    // For each solution O(n) for a new array
    // Space: O(len(arr) ^ n)
    public static void generate(char[] arr, int n, List<List<Character>> result, List<Character> current) {
        if (current.size() == n) {
            result.add(current);
        } else {
            for (int i = 0; i < arr.length; i++) {
                // O(n) for the new Array
                List<Character> newCurrent = new ArrayList<>(current);
                newCurrent.add(arr[i]); 
                generate(arr, n, result, newCurrent);
            }
        }                     
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        char[] arr = {'a', 'b', 'c'};
        int n = 2;
        
        // find all combinations
        // aa
        // ab
        // ba
        // bb
        List<Character> current = new ArrayList<>();
        List<List<Character>> result = new ArrayList<>();
        generate(arr, n, result, current);
        
        for (List<Character> res: result) {
            System.out.println(res.toString());
        }
    }
}
