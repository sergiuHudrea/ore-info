import java.util.*;

public class BacktrackingTwo {
    // Time: O(n * n * n!)
	// Space: O(n * n!)
	public static void permHelper(List<List<Integer>> result, List<Integer> m, List<Integer> current) {
		if (m.size() == 0) {
			result.add(current);
		} else {
			for (int i = 0; i < m.size(); i++) {
				// m = {2}; i = 0
				List<Integer> newM = new ArrayList<>(m);
				// newM = {}
				newM.remove(i);
				
				List<Integer> newCurrent = new ArrayList<>(current);
				// newCurrent = {1, 3, 2}
				newCurrent.add(m.get(i));
				
				permHelper(result, newM, newCurrent);
			}
		}
	}
	
	public static List<List<Integer>> permutations(List<Integer> m) {
		List<List<Integer>> result = new ArrayList<>();
		permHelper(result, m, new ArrayList<Integer>());
		return result;
	}
	
	// Time: O(n * n * n! / (n - k)!)
	// Space: O(n * n! / (n - k)!)
	public static void aranjamenteHelper(List<List<Integer>> result, List<Integer> m,
										 List<Integer> current, int k) {
		// Base case
		if (current.size() == k) {
			result.add(current);
		} else {
			for (int i = 0; i < m.size(); i++) {
				// Step 1 - prepare new input m
				List<Integer> newM = new ArrayList<>(m);
				newM.remove(i);
				
				// Step 2 - prepare new current
				List<Integer> newCurrent = new ArrayList<>(current);
				newCurrent.add(m.get(i));
				
				aranjamenteHelper(result, newM, newCurrent, k);
			}
		}
	}
	
	public static List<List<Integer>> aranjamente(List<Integer> m, int k) {
		List<List<Integer>> result = new ArrayList<>();
		aranjamenteHelper(result, m, new ArrayList<Integer>(), k);
		return result;
	}


	// COMBINARI
	public static void combinariHelper(List<List<Integer>> result, List<Integer> m, List<Integer> current, int k) {
		if (current.size() == k) {
			result.add(current);
		} else {
			for (int i = 0; i < m.size(); i++) {
				List<Integer> newM = new ArrayList<>();
				for (int j = i + 1; j < m.size(); j++) {
					newM.add(m.get(j));
				}

				List<Integer> newCurrent = new ArrayList<>(current);
				newCurrent.add(m.get(i));
				
				combinariHelper(result, newM, newCurrent, k);
			}
		}
	}

	public static List<List<Integer>> combinari(List<Integer> m, int k) {
		List<List<Integer>> result = new ArrayList<>();

		combinariHelper(result, m, new ArrayList<>(), k);

		return result;
	}


	// POWER SETS
	public static void powerSetsHelper(List<List<Integer>> result, List<Integer> arr, List<Integer> current) {
		if (arr.size() == 0) {
			result.add(current);
		} else {
			for (int i = 0; i < arr.size(); i++) {
				List<Integer> newArr = new ArrayList<>();
				for (int j = i + 1; j < arr.size(); j++) {
					newArr.add(arr.get(j));
				}


			}
		}
	}

	public static List<List<Integer>> powerSets(Integer m) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> arr = new ArrayList<>();

		for (int i = 1 ; i <= m; i++) {
			arr.add(i);
		}

		powerSetsHelper(result, arr, new ArrayList<>());

		return result;
	}
	
	public static void main(String[] args) {
		
		// List<Integer> m = new ArrayList<>(Arrays.asList(1, 2, 3));
		// List<List<Integer>> result = permutations(m);
		
		// for (List<Integer> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }
		

		// List<Integer> m = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		// List<List<Integer>> result = aranjamente(m, 2);
		
		// for (List<Integer> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }


		List<Integer> m = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		List<List<Integer>> result = combinari(m, 3);
		
		for (List<Integer> newResult: result) {
			System.out.println(newResult.toString());
		}
	
	}
}
