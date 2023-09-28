import java.util.Arrays;
import java.util.ArrayList;

class HomeworkSortari {
    // 1. https://www.pbinfo.ro/probleme/618/inaltimi
    public static int[] inaltimi(int[] arr) {
        int[] indexArr = arr.clone();
        int[] copyArr = arr.clone();
        int aux = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < copyArr.length; l++) {
                if (arr[k] == copyArr[l]) {
                    indexArr[k] = l + 1;
                }
            }
        }
        return indexArr;
    }
    
    // 2. https://www.pbinfo.ro/probleme/183/sortpp
    public static ArrayList<Integer> sortPP(ArrayList<Integer> arr) {
        ArrayList<Integer> copyArr = new ArrayList<>(arr);
        int aux = 0;
        int lenArr = arr.size();
        
        for (int i = 0; i < lenArr; i++) {
            if (arr.get(i) % Math.sqrt(arr.get(i)) != 0.0) {
                arr.remove(i);
                lenArr--;
            }
        }
        
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    aux = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, aux);
                }
            }
        }
        
        for (int k = 0; k < copyArr.size(); k++) {
            if (copyArr.get(k) % Math.sqrt(copyArr.get(k)) != 0.0) {
                arr.add(k, copyArr.get(k));
            }
        }
        
        return arr;
    }
    
    // 3. https://www.pbinfo.ro/probleme/180/sortminma
    static class IndexMinMax {
        public int indexMin;
        public int indexMax;
    }
    
    public static IndexMinMax minMax(ArrayList<Integer> arr) {
        IndexMinMax indexMinMax = new IndexMinMax();
        int min = arr.get(0);
        int indexMin = 0;
        int max = arr.get(0);
        int indexMax = 0;
        
        for (int i = 0; i< arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
                indexMax = i;
            }
            if (arr.get(i) < min) {
                min = arr.get(i);
                indexMin = i;
            }
        }
        
        indexMinMax.indexMin = indexMin;
        indexMinMax.indexMax = indexMax;
        
        return indexMinMax;
    }
    
    public static void sortMinMax(ArrayList<Integer> arr) {
        int aux = 0;
        IndexMinMax indexMinMax = minMax(arr);
        
        for (int i = indexMinMax.indexMax; i < indexMinMax.indexMin; i++) {
            for (int j = indexMinMax.indexMax + 1; j <= indexMinMax.indexMin; j++) {
                if (arr.get(i) > arr.get(j)) {
                    aux = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, aux);
                }
            }
        }
    }
    
    
    // 4. https://www.pbinfo.ro/probleme/514/sortpie
    public static int cmmdc(int a, int b) {
		int auxA = a;
		int auxB = b;

		while (auxA != auxB) {
			if (auxA > auxB) {
				auxA -= auxB;
			} else {
				auxB -= auxA;
			}
		}

		return auxA;
	}
	
	public static ArrayList<Integer> sortPie(int[] arr) {
	    ArrayList<Integer> pieArr = new ArrayList<>();
	    int aux = 0;
	    int index = 0;
	    
	    for (int i = 0; i < arr.length - 1; i++) {
	        if (cmmdc(arr[i], arr[arr.length - 1]) == 1) {
	            pieArr.add(arr[i]);
	        }
	    }
	    
	   // With Insertion Sort
	    for (int j = 1; j < pieArr.size(); j++) {
	        index = j;
	        while ( index > 0 && (pieArr.get(index - 1) < pieArr.get(index)) ) {
	            aux = pieArr.get(index);
	            pieArr.set(index, pieArr.get(index - 1));
	            pieArr.set((index - 1), aux);
	            index--;
	        }
	    }
	   
	   // With Selection Sort
	   //for (int i = 0; i < pieArr.size() - 1; i++) {
    //         for (int j = i + 1; j < pieArr.size(); j++) {
    //             if (pieArr.get(i) < pieArr.get(j)) {
    //                 aux = pieArr.get(i);
    //                 pieArr.set(i, pieArr.get(j));
    //                 pieArr.set(j, aux);
    //             }
    //         }
    //     }
	    
	    return pieArr;
	}
    
    
    // 5. https://www.pbinfo.ro/probleme/1608/sortare-divizori
    public static Integer countDividers(int n) {
		int counter = 0;
		
		for (int i = 1; i < (int)Math.sqrt(n); i++) {
			if (n % i == 0) {
				counter += 2;
			}
		}

		if ((int)Math.sqrt(n) != 0 && n % (int)Math.sqrt(n) == 0) {
			counter++;
		}
		
		return counter;
	}
	
	public static void sortareDivizori(int[] arr) {
	    int aux = 0;
	    
	    for (int i = 0; i < arr.length - 1; i++) {
	        for (int j = i + 1; j < arr.length; j++) {
	            if (countDividers(arr[i]) < countDividers(arr[j])) {
	                aux = arr[i];
	                arr[i] = arr[j];
	                arr[j] = aux;
	            } else if (countDividers(arr[i]) == countDividers(arr[j])) {
	                if (arr[i] > arr[j]) {
	                    aux = arr[i];
	                    arr[i] = arr[j];
	                    arr[j] = aux;
	                }
	            }
	        }
	    }
	}
    
    
    public static void main(String[] args) {
        // 1.
        // int[] arr = {8, 20, 16, 14, 10, 4, 12};
        // System.out.println(Arrays.toString(inaltimi(arr)));
        
        // 2.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9, 15, 16, 4, 5, 1, 7, 9));
        // System.out.println(sortPP(arr));

        // 3.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 15, 7, 12));
        // sortMinMax(arr);
        // System.out.println(arr);
        
        // 4. 
        // int[] arr = {16, 7, 6, 3, 1, 5, 9, 14};
        // ArrayList<Integer> pieArr = sortPie(arr);
        // System.out.println(pieArr);
        
        // 5.
        int[] arr = {12, 20, 4, 100, 13};
        sortareDivizori(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(countDividers(0));
        
    }
}