import java.util.ArrayList;
import java.util.Arrays;

public class HomeworkSecvente {
    
    public static class SequenceResult {
        public int left;
        public int right;
    }

    // 1. https://www.pbinfo.ro/probleme/518/secvzero
    public static SequenceResult secvZero(ArrayList<Integer> arr) {
        int lenMax = 0;
        int left = -1;
        int right = -1;
        int contor = 0;
        SequenceResult sequenceResult = new SequenceResult();
        
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                contor = i;
                while (contor < arr.size() && arr.get(contor) == 0) {
                    contor++;
                }
                
                int len = contor - i;
                if (len > lenMax) {
                    lenMax = len;
                    left = i;
                    right = contor - 1;
                }
                i = contor;
            }
        }
        
        sequenceResult.left = left;
        sequenceResult.right = right;
        
        return sequenceResult;
    }
    
    // 2. https://www.pbinfo.ro/probleme/981/secventa11
    public static int baseTenToBaseTwo(int nr) {
        int baseTwo = 0;
        int pwr = 0;
        while (nr > 0) {
            baseTwo += Math.pow(10, pwr) * (nr % 2);
            nr /= 2;
            pwr++;
        }

        return baseTwo;
    }
    
    public static boolean onlyOnes(int nr) {
        while (nr > 0) {
            if (nr % 10 != 1) {
                return false;
            }
            nr /= 10;
        }
        return true;
    }
    
    public static int secventa11(ArrayList<Integer> arr) {
        int lenMax = 0;
        int contor = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            if (onlyOnes(baseTenToBaseTwo(arr.get(i)))) {
                contor = i;
                while (contor < arr.size() && onlyOnes(baseTenToBaseTwo(arr.get(contor)))) {
                    contor++;
                }
                
                int len = contor - i;
                if (len > lenMax) {
                    lenMax = len;
                }
                i = contor;
            }
        }
        
        return lenMax;
    }
    
    // 3. https://www.pbinfo.ro/probleme/862/nrsecvente
    public static int nrSecvente(ArrayList<Integer> arr, int t, int k) {
        int nrSecvente = 0;
        boolean flag = true;
        
        for (int i = 0; i < arr.size() - k + 1; i++) {
            flag = true;
            for (int j = 0; j < k; j++) {
                System.out.println(arr.get(i + j));
                if (arr.get(i + j) > t) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                nrSecvente++;
            }
        }
        
        return nrSecvente;
    }
    
    // 4. https://www.pbinfo.ro/probleme/524/secvegale1
    public static SequenceResult secventeEgale1(ArrayList<Integer> arr) {
        int lenMax = 0;
        int left = -1;
        int right = -1;
        int contor = 0;
        int len = 0;
        SequenceResult sequenceResult = new SequenceResult();
        
        for (int i = 0; i < arr.size(); i++) {
            contor = i;
            while (contor < arr.size()) {
                len = contor - i + 1;
                if (arr.get(i) == arr.get(contor) && len > lenMax) {
                    lenMax = len;
                    left = i;
                    right = contor;
                }
                contor++;
            }
        }
        
        sequenceResult.left = left;
        sequenceResult.right = right;
        
        return sequenceResult; 
    }
    
    // 5. https://www.pbinfo.ro/probleme/71/reducere
    public static class Tablou {
        public int[] A;
        public int[] B;
    }
    
    public static void reducere(ArrayList<Tablou> arr) {
        int[] a;
        int[] b;
        int indexB = 0;
        boolean flag = true;
        int suma = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            a = arr.get(i).A;
            b = arr.get(i).B;
            flag = true;
            indexB = 0;
            suma = 0;
            for (int indexA = 0; indexA < a.length; indexA++) {
                suma += a[indexA];
                if (suma > b[indexB]) {
                    System.out.println("NU");
                    flag = false;
                    break;
                } else if (suma == b[indexB]) {
                    indexB++;
                    suma = 0;
                } 
            }
            if (flag) {
                System.out.println("DA");
            }
            
            
        }
    }
    
    // 6. https://www.pbinfo.ro/probleme/299/sumesecv
    public static void sumeSecv(int[] arr, int[] perechi) {
        int from = 0;
        int to = 0;
        int suma = 0;
        
        for (int i = 0; i < perechi.length; i += 2) {
            from = perechi[i];
            to = perechi[i + 1];
            suma = 0;
            
            for (int j = from; j <= to; j++) {
                suma += arr[j];
            }
            System.out.println(suma);
        }
    }
    
    // 7. https://www.pbinfo.ro/probleme/2921/sumesecv1
    public static int sumeSecv1(int[] arr, int[] perechi) {
        int from = 0;
        int to = 0;
        int suma = 0;
        int sumaMax = 0;
        
        for (int i = 0; i < perechi.length; i += 2) {
            if (perechi[i] < perechi[i + 1]) {
                from = perechi[i];
                to = perechi[i + 1];
            } else {
                from = perechi[i];
                to = perechi[i + 1];
            }
            suma = 0;
            
            for (int j = from; j <= to; j++) {
                suma += arr[j];
            }
            if (suma > sumaMax) {
                sumaMax = suma;
            }
        }
        
        return sumaMax;
    }
    
    // 8. https://www.pbinfo.ro/probleme/297/secvsummax
    public static SequenceResult secvMax(int[] arr) {
        SequenceResult sequenceResult = new SequenceResult();
        long sumMax = Long.MIN_VALUE;
        int st = -1;
        int dr = -1;
        int suma = -1;
        int start = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (suma < 0) {
                suma = 0;
                start = i;
            }
            suma += arr[i];
            
            if (suma > sumMax) {
                sumMax = suma;
                st = start;
                dr = i;
            }
        }
        
        sequenceResult.left = st;
        sequenceResult.right = dr;
        return sequenceResult;
    }
    
    // 9. https://www.pbinfo.ro/probleme/2142/easy-sum
    public static int easySum(int[] arr) {
        ArrayList<Integer> subSecv = new ArrayList<>();
        int contor = 0;
        int sum = 0;
        int sumaTotala = 0;
        
        
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                subSecv.add(sum);
            }
        }
        sumaTotala = suma(subSecv);
        
        return sumaTotala;
    }
    
    public static int suma(ArrayList<Integer> arr) {
        int suma = 0;
        for (int i = 0; i < arr.size(); i++) {
            suma += arr.get(i);
        }
        
        return suma;
    }
    
    // 10. https://www.pbinfo.ro/probleme/3937/ksum3 
    public static int kSum(int[] arr, int from, int to) {
        int sumMax = 0;
        int index = 0;
        int sum = 0;
        int contor = 0;
        
        for (int i = from; i <= to; i++) {
            for (int j = 0; j <= arr.length - i; j++) {
                index = j;
                sum = 0;
                contor = i;
                while (contor > 0) {
                    sum += arr[index];
                    index++;
                    contor--;
                }
                if (sum > sumMax) {
                    sumMax = sum;
                }
            }
        }
        return sumMax;
    }
    


     public static void main(String[] args) {
        
        // 1.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 5, 0, 0, 0, 2));
        // SequenceResult res = secvZero(arr);
        // System.out.println(res.left);
        // System.out.println(res.right);
        
        // 2.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 6, 7, 15, 88));
        // System.out.println(secventa11(arr));
        
        // 3. 
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 3, 5, 7, 3, 4, 2));
        // System.out.println(nrSecvente(arr, 5, 3));
        
        // 4.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(6, 6, 8, 3, 6, 6, 3, 8, 4, 3, 3, 4));
        // SequenceResult res = secventeEgale1(arr);
        // System.out.println(res.left);
        // System.out.println(res.right);
        
        // 5.
        // Tablou tablouUnu = new Tablou();
        // int[] a1 = {7, 3, 4, 1, 6, 4, 6, 9, 7, 1, 8, 7};
        // int[] b1 = {14, 7, 26, 16};
        // tablouUnu.A = a1;
        // tablouUnu.B = b1;
        // Tablou tablouDoi = new Tablou();
        // int[] a2 = {1, 4, 2, 2, 3};
        // int[] b2 = {5, 3, 4};
        // tablouDoi.A = a2;
        // tablouDoi.B = b2;
        
        // ArrayList<Tablou> arr = new ArrayList<>(Arrays.asList(tablouUnu, tablouDoi));
        // reducere(arr);
        
        // 6.
        // int[] arr = {5, 5, 1, 3, 6, 4, 1, 2, 10, 6};
        // int[] perechi = {4, 7, 1, 5, 5, 9};
        // sumeSecv(arr, perechi);
        
        // 7.
        // int[] arr = {7, 9, -6, 1, -8};
        // int[] perechi = {0, 2, 3, 1, 1, 4};
        // int res = sumeSecv1(arr, perechi);
        // System.out.println(res);
        
        // 8.
        // int[] arr = {-4, 1, -5, 1, 4, -2, 2, 3, -4, 4};
        // SequenceResult res = secvMax(arr);
        // System.out.println(res.left);
        // System.out.println(res.right);
        
        // 9.
        // int[] arr = {1, 2, 3, 4};
        // int res = easySum(arr);
        // System.out.println(res);
        
        // 10.
        // int[] arr = {5, 4, -10, 1, 2, 3};
        // int res = kSum(arr, 3, 4);
        // System.out.println(res);

    }
}