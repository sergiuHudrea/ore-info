import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class HomeworkBacktrackingPermutariSiAranjamente {
    // 1. https://www.pbinfo.ro/probleme/123/permutari
    public static void permutariHelper(List<List<Integer>> result, List<Integer> arr, List<Integer> current) {
        if (arr.size() == 0) {
            result.add(current);
        } else {
            for (int i = 0; i < arr.size(); i++) {
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.remove(i);

                List<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(arr.get(i));

                permutariHelper(result, newArr, newCurrent);
            }
        }
    }


    public static List<List<Integer>> permutations(Integer m) {
        List<Integer> arr = new ArrayList<>(m);
        for (int i = 1; i <= m; i++) {
            arr.add(i - 1, i);
        }

		List<List<Integer>> result = new ArrayList<>();
		permutariHelper(result, arr, new ArrayList<Integer>());
		return result;
	}


    // 2. https://www.pbinfo.ro/probleme/124/permutari1
    public static void perm1Helper(List<List<Integer>> result, List<Integer> arr, List<Integer> current) {
        if (arr.size() == 0) {
            result.add(current);
        } else {
            for (int i = 0; i < arr.size(); i++) {
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.remove(i);

                List<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(arr.get(i));

                perm1Helper(result, newArr, newCurrent);
            }
        }
    }

    public static List<List<Integer>> permutari1(Integer m) {
        List<Integer> arr = new ArrayList<>(m);
        for (int i = 1; i <= m; i++) {
            arr.add(0, i);
        }

        System.out.println(arr);

        List<List<Integer>> result = new ArrayList<>();
		perm1Helper(result, arr, new ArrayList<Integer>());
		return result;
    }

    // 3. https://www.pbinfo.ro/probleme/1327/sirpie
    public static boolean suntPrimeIntreEle(int a, int b) {
		int auxA = a;
		int auxB = b;

		while (auxA != auxB) {
			if (auxA > auxB) {
				auxA -= auxB;
			} else {
				auxB -= auxA;
			}
		}

        if (auxA == 1) {
            return true;
        } else {
            return false;
        }
	}
    public static void sirPieHelper(List<List<Integer>> result, List<Integer> m,
										 List<Integer> current, int k) {
		if (current.size() == k) {
			result.add(current);
		} else {
			for (int i = 0; i < m.size(); i++) {
				List<Integer> newM = new ArrayList<>(m);
				newM.remove(i);
				
				List<Integer> newCurrent = new ArrayList<>(current);
                if (newCurrent.size() == 0) {
                    newCurrent.add(m.get(i));

                    sirPieHelper(result, newM, newCurrent, k);
                } else {
                    if (suntPrimeIntreEle(newCurrent.get(newCurrent.size() - 1), m.get(i))) {
                        newCurrent.add(m.get(i));

                        sirPieHelper(result, newM, newCurrent, k);
                    }
                }	
			}
		}
	}
	
	public static List<List<Integer>> sirPie(List<Integer> m, int k) {
		List<List<Integer>> result = new ArrayList<>();
		sirPieHelper(result, m, new ArrayList<Integer>(), k);
		return result;
	}

    // 4. https://www.pbinfo.ro/probleme/194/anagrame1
    public static void anagrame1Helper(List<List<Character>> result, List<Character> m, List<Character> current) {
        if (m.size() == 0) {
            result.add(current);
        } else {
            for (int i = 0; i < m.size(); i++) {
                List<Character> newArr = new ArrayList<>(m);
                newArr.remove(i);

                List<Character> newCurrent = new ArrayList<>(current);
                newCurrent.add(m.get(i));

                anagrame1Helper(result, newArr, newCurrent);
            }
        }
    }

    public static List<List<Character>> anagrame1(List<Character> m) {
		List<List<Character>> result = new ArrayList<>();
		anagrame1Helper(result, m, new ArrayList<Character>());

		return result;
	}


    // 5. https://www.pbinfo.ro/probleme/3159/numere124 
    public static int nrCifre(int n) {
        int nrCifre = 0;
	    int aux = n;
	    while (aux > 0) {
	        nrCifre += 1;
	        aux /= 10;
	    }

        return nrCifre;
    }

    public static List<Integer> makeList(int n) {
        List<Integer> list = new ArrayList<>();

	    while (n > 0) {
            list.add(n % 10);
	        n /= 10;
	    }

        return list;
    }
    public static void numere124Helper(List<Integer> result, List<Integer> m, int current, int k) {
        if (nrCifre(current) == k){
            result.add(current);
        } else {
            for (int i = 0; i < m.size(); i++) {
                List<Integer> newM = new ArrayList<>(m);
                newM.remove(i);

                int newCurrent = current;
                if (newCurrent == 0) {
                    newCurrent = m.get(i);
                } else {
                    newCurrent *= 10;
                    newCurrent += m.get(i);
                }

                numere124Helper(result, newM, newCurrent, k);
            }
        }
    }

    public static List<Integer> numere124(int m, int k) {
        List<Integer> mList = makeList(m);
        List<Integer> result = new ArrayList<>();
        numere124Helper(result, mList, 0 , k);
		return result;
    }



    public static void main(String[] args) {
        // 1.
		// List<List<Integer>> result = permutations(3);
		
		// for (List<Integer> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 2.
        // List<List<Integer>> result = permutari1(3);
		
		// for (List<Integer> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 3.
        // List<Integer> m = new ArrayList<>(Arrays.asList(8, 6, 7, 9));
		// List<List<Integer>> result = sirPie(m, 4);
		
		// for (List<Integer> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 4.
        // List<Character> m = new ArrayList<Character>(Arrays.asList('c', 'a', 'l'));
		// List<List<Character>> result = anagrame1(m);
		
		// for (List<Character> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 5.
		List<Integer> result = numere124(2576, 2);
        Collections.sort(result);

		for (Integer newResult: result) {
			System.out.println(newResult.toString());
		}

    }
}
