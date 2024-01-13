import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeworkBacktracking {
    //	Scrie o functie care primeste ca input un sir de caractere arr si un numar n.
    //	Scrie o functie care sa genereze toate cuvintele de n litere in care nu au voie 2 vocale sa fie una langa alta.
    //	Antetul functiei:
	
	// Time: O(n * len(arr) ^ n)
	// Space: O(len(arr) ^ n)
	public static void helper(List<List<Character>> result, char[] arr, int n, List<Character> current) {
		// Test base case
		if (current.size() == n) {
			result.add(current);
		} else {
			// Recursive case
			for (int i = 0; i < arr.length; i++) {
				List<Character> newCurrent = new ArrayList<>(current);
				Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
				if (!(newCurrent.size() > 0 &&
					  vowelsSet.contains(newCurrent.get(newCurrent.size() - 1)) &&
					  vowelsSet.contains(arr[i]))) {
					newCurrent.add(arr[i]);
					helper(result, arr, n, newCurrent);
				}
			}
		}
	}
	
	public static List<List<Character>> generateNoTwoVowels(char[] arr, int n) {
		List<List<Character>> result = new ArrayList<>();
		helper(result, arr, n, new ArrayList<Character>());
		return result;
	}


    // 2. Scrie o functie care primeste ca input un sir de caractere arr si un numar n. 
    // Scrie o functie care sa genereze toate cuvintele de n litere in care nu au voie 2 consoane sa fie una langa alta. 
    // Antetul functiei:
    public static void helperCons(List<List<Character>> result, char[] arr, int n, List<Character> current) {
        // Base case
        if (current.size() == n) {
            result.add(current);
        } else {
            // Recursive case
            for (int i = 0; i < arr.length; i++) {
                List<Character> newCurrent = new ArrayList<>(current);
                Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
				if (!(newCurrent.size() > 0 &&
					  !vowelsSet.contains(newCurrent.get(newCurrent.size() - 1)) &&
					  !vowelsSet.contains(arr[i]))) {
					newCurrent.add(arr[i]);
					helperCons(result, arr, n, newCurrent);
				}
            }
        }
    }
    
    public static List<List<Character>> generateNoTwoConsonants(char[] arr, int n) {
        List<List<Character>> result = new ArrayList<>();
        helperCons(result, arr, n, new ArrayList<>());

        return result;
    } 


    // 3.Scrie o functie care primeste ca input un sir de caractere arr, un numar n si un numar m. 
    // Scrie o functie care sa genereze toate cuvintele de n litere in care contin exact m vocale.
    public static int nrVowels(List<Character> arr) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int counter = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (vowelsSet.contains(arr.get(i))) {
                counter++;
            }
        }

        return counter;
    }
    public static void helperMVowels(List<List<Character>> result, char[] arr, int n, int m, List<Character> current) {
        if (current.size() == n) {
            if (nrVowels(current) == m) {
                result.add(current);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                List<Character> newCurrent = new ArrayList<>(current);
                newCurrent.add(arr[i]);

                helperMVowels(result, arr, n, m, newCurrent);
            }
        }

    }
    public static List<List<Character>> generateMVowels(char[] arr, int n, int m) {
        List<List<Character>> result = new ArrayList<>();
        helperMVowels(result, arr, n, m, new ArrayList<>());

        return result;
    } 

    // 4. Scrie o functie care primeste ca input un sir de caractere arr, un numar n si un numar m. 
    // Scrie o functie care sa genereze toate cuvintele de n litere in care contin exact m vocale dupa fiecare consoana.  
    public static void helperMVAC(List<List<Character>> result, char[] arr, int n, int m, List<Character> current) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        if (current.size() == n) {
            for (int i = 0; i < current.size(); i++) {
                if (!vowelsSet.contains(current.get(i)) && ((i + m) < current.size())) {
                    Boolean toggle = true;
                    for (int j = i + 1; j <= i + m; j++) {
                        if (!vowelsSet.contains(current.get(j))) {
                            toggle = false;
                            break;
                        } 
                    }
                    if (toggle) {
                        result.add(current);
                    }
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                List<Character> newCurrent = new ArrayList<>(current);
                newCurrent.add(arr[i]);

                helperMVAC(result, arr, n, m, newCurrent);
            }
        }
    }
    public static List<List<Character>> generateMVowelsAfterConsonant(char[] arr, int n, int m) {
        List<List<Character>> result = new ArrayList<>();
        helperMVAC(result, arr, n, m, new ArrayList<>());

        return result;
    }


    // 5. Scrie o functie care primeste ca input un sir de caractere arr, un numar n. 
    // Scrie o functie care sa genereze toate cuvintele de n litere care se termina cu o vocala.
    public static void helperGenerateEV(List<List<Character>> result, char[] arr, int n, List<Character> current) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        if (current.size() == n) {
            if (vowelsSet.contains(current.get(current.size() - 1))) {
                result.add(current);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                List<Character> newCurrent = new ArrayList<>(current);
                newCurrent.add(arr[i]);
                helperGenerateEV(result, arr, n, newCurrent);
            }
        }

    }

    public static List<List<Character>> generateEndingVowel(char[] arr, int n) {
        List<List<Character>> result = new ArrayList<>();
        helperGenerateEV(result, arr, n, new ArrayList<>());

        return result;
    }  

public static void main(String[] args) {
        // 1.
        char[] arr = {'a', 'b', 'e'};
		int n = 3;
		// List<List<Character>> result = generateNoTwoVowels(arr, n);
		// for (List<Character> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 2.
        // List<List<Character>> result = generateNoTwoConsonants(arr, n);
		// for (List<Character> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 3.
        // int m = 3;
        // List<List<Character>> result = generateMVowels(arr, n, m);
		// for (List<Character> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 4.
        // int m = 2;
        // List<List<Character>> result = generateMVowelsAfterConsonant(arr, n, m);
		// for (List<Character> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 5.
        List<List<Character>> result = generateEndingVowel(arr, n);
		for (List<Character> newResult: result) {
			System.out.println(newResult.toString());
		}


}

}
