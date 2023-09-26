import java.util.ArrayList;
import java.util.Arrays;

class HomeworkStergeriSiInserari {

    // 1. https://www.pbinfo.ro/probleme/159/inseraredupa
    public static void inserareDupa(ArrayList<Integer> arr) {
        int doub = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                doub = arr.get(i) * 2;
                arr.add(i + 1, doub);
                i++;
            }
        }
    }
   
    // 2. https://www.pbinfo.ro/probleme/4386/inserare3
    public static Integer minim(ArrayList<Integer> arr) {
        int min = arr.get(0);
        
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }
    
    public static void inserare3(ArrayList<Integer> arr) {
        int min = minim(arr);
        
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == min) {
                arr.add(i + 1, min);
                i++;
            }
        }
    }
    
    // 3. https://www.pbinfo.ro/probleme/1453/stergere1
    public static void stergere1(ArrayList<Integer> arr) {
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            if (arr.get(i) % 2 == 0) {
                arr.remove(i);
                size--;
                i--;
            }
        }
    }
    
    // 4. https://www.pbinfo.ro/probleme/163/stergere
    public static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}

		for (int i = 2; i <= (n / 2); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
    public static void stergere(ArrayList<Integer> arr) {
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            if (isPrime(arr.get(i))) {
                arr.remove(i);
                size--;
                i--;
            }
        }
    }
    
    // 5. https://www.pbinfo.ro/probleme/160/inserareinainte
    public static void inserareInainte(ArrayList<Integer> arr) {
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            if (arr.get(i) % Math.sqrt(arr.get(i)) == 0.0) {
                arr.add(i, (int)Math.sqrt(arr.get(i)));
                i++;
                size++;
            }
        }
    }


    public static void main(String[] args) {
        
        // 1.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 3, 4, 1, 6));
        // inserareDupa(arr);
        // System.out.println(arr);
        
        // 2.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 9, 4, 2, 1, 6, 1));
        // inserare3(arr);
        // System.out.println(arr);
        
        // 3.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 9, 4, 2, 1, 6, 5));
        // stergere1(arr);
        // System.out.println(arr);
        
        // 4.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 17, 1));
        // stergere(arr);
        // System.out.println(arr);
        
        // 5.
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 3, 4, 1, 9));
        inserareInainte(arr);
        System.out.println(arr);
    }
}