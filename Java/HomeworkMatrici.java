import java.util.Arrays;

class HomeworkMatrici {
    
    // 1. https://www.pbinfo.ro/probleme/658/sumalinii
    public static int[] sumaLinii(int[][] matrice) {
        int[] sume = new int[matrice.length];
        int suma = 0;
        
        for (int i = 0; i < matrice.length; i++) {
            suma = 0;
            for (int j = 0; j < matrice[i].length; j++) {
                suma += matrice[i][j];
            }
            sume[i] = suma;
        }
        
        return sume;
    }
    
    // 2.
    public static int[] sumaLiniiUnu(int[][] matrice) {
        int[] sume = new int[matrice.length];
        int suma = 0;
        int max = 0;
        
        for (int i = 0; i < matrice.length; i++) {
            suma = 0;
            max = 0;
            
            for (int j = 0; j < matrice[i].length; j++) {
                suma += matrice[i][j];
                if (matrice[i][j] > max) {
                    max = matrice[i][j];
                }
            }
            suma -= max;
            sume[i] = suma;
        }
        
        return sume;
    }
    
    // 3. https://www.pbinfo.ro/probleme/666/nrprime
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
	
    public static int nrPrime(int[][] matrice) {
        int contor = 0;
        
        for (int i = 0; i < matrice.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < matrice[i].length; j++) {
                    if (isPrime(matrice[i][j])) {
                        contor++;
                    }
                }
            }
        }
        
        return contor;
    }
    
    // 4. https://www.pbinfo.ro/probleme/770/permcol
    public static void permCol(int[][] matrice) {
        int aux = 0;
        
        for (int i = 0; i < matrice.length; i++) {
            aux = matrice[i][0];
            for (int j = 1; j < matrice[i].length; j++) {
                matrice[i][j - 1] = matrice[i][j];
            } 
            matrice[i][matrice[i].length - 1] = aux;
        }
        
        for (int i = 0; i < matrice.length; i++) {
            System.out.println(Arrays.toString(matrice[i]));
        }
    }
    
    // 5. https://www.pbinfo.ro/probleme/771/ordlin
    public static void ordLin(int[][] matrice) {
        int suma = 0;
        int max = 0;
        int[] sume = new int[matrice.length];
        
        for (int i = 0; i < matrice.length; i++) {
            suma = 0;
            for (int j = 0; j < matrice[i].length; j++) {
                suma += matrice[i][j];
            }
            sume[i] = suma;
        }
        
        int auxS = 0;
        int[] auxM = new int[matrice[0].length];
        int index = 0;
        
        for (int i = 1; i < sume.length; i++) {
            index = i;
            while (index > 0 && sume[index] < sume[index - 1]) {
                auxS = sume[index];
                sume[index] = sume[index - 1];
                sume[index - 1] = auxS;
                
                auxM = matrice[index];
                matrice[index] = matrice[index - 1];
                matrice[index - 1] = auxM;
                
                index--;
            }
        }
        
        
        for (int i = 0; i < matrice.length; i++) {
            System.out.println(Arrays.toString(matrice[i]));
        }
    }
    
    // 6. https://www.pbinfo.ro/probleme/773/maxap1
    public static int maxApUnu(int[][] matrice) {
        int max = 0;
        int maxAp = 0;
        
        
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] > max) {
                    max = matrice[i][j];
                }
            }
        }
        
        int[] vecFrecv = new int[max + 1];
        
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                vecFrecv[matrice[i][j]]++;
                if (vecFrecv[matrice[i][j]] > maxAp) {
                    maxAp = vecFrecv[matrice[i][j]];
                }
            }
        }
        
        max = 0;
        for (int i = 0; i < vecFrecv.length; i++) {
            if (vecFrecv[i] == maxAp) {
                if (i > max) {
                    max = i;
                }
            }
        }
        
        return max;
    }
    
    // 7.https://www.pbinfo.ro/probleme/772/maxap
    public static void maxAp(int[][] matrice) {
        int max = 0;
        int maxAp = 0;
        
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] > max) {
                   max = matrice[i][j];
                }
            }
        }
        
        int[] vectorFrecv = new int[max + 1];
        
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                vectorFrecv[matrice[i][j]]++;
                if (vectorFrecv[matrice[i][j]] > maxAp) {
                    maxAp = vectorFrecv[matrice[i][j]];
                }
            }
        }
        
        
        for (int i = 0; i < vectorFrecv.length; i++) {
            if (vectorFrecv[i] == maxAp) {
                System.out.println(i);
            }
        }
    }
    
    // 8. https://www.pbinfo.ro/probleme/2807/matrice10
    public static void matriceZece(int[][] matrice) {
        int indexLinMinPrim = 0;
        int indexLinMinUlt = 0;
        int minPrim = matrice[0][0];
        int minUlt = matrice[0][matrice[0].length - 1];
        
        for (int i = 0; i < matrice.length; i++) {
            if (matrice[i][0] < minPrim) {
                minPrim = matrice[i][0];
                indexLinMinPrim = i;
            }
            
            if (matrice[i][matrice[i].length - 1] < minUlt) {
                minUlt = matrice[i][matrice[i].length - 1];
                indexLinMinUlt = i;
            }
        }
        
        matrice[indexLinMinPrim][0] = minUlt;
        matrice[indexLinMinUlt][matrice[indexLinMinUlt].length - 1] = minPrim;
        
        for (int i = 0; i < matrice.length; i++) {
            System.out.println(Arrays.toString(matrice[i]));
        }
    }
    
    // 9. https://www.pbinfo.ro/probleme/776/cntlinii
    public static int cntLinii(int[][] matrice) {
        int contor = 0;
        int identic = 0;
        boolean flag = true;
        
        for (int i = 0; i < matrice.length; i++) {
            flag = true;
            identic = matrice[i][0];
            for (int j = 1; j < matrice[i].length; j++) {
                if (matrice[i][j] != identic) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                contor++;
            }
        }
        
        return contor;
    }
    
    public static void main(String[] args) {
        // 1.
        // int[][] matrice = {
        //                   {5, 5, 10, 5}, 
        //                   {3, 9, 1, 9}, 
        //                   {4, 10, 1, 2} 
        //                   };
        // System.out.println(Arrays.toString(sumaLinii(matrice)));
        
        // 2.
        // System.out.println(Arrays.toString(sumaLiniiUnu(matrice)));
        
        // 3.
        //  int[][] matrice = {
        //                   {5, 12, 10}, 
        //                   {3, 9, 1}, 
        //                   {7, 10, 1}, 
        //                   {10, 9, 3}
        //                   };
        // System.out.println(nrPrime(matrice));
        
        // 4.
        // int[][] matrice = {
        //                   {4, 20, 15, 23, 18, 9}, 
        //                   {15, 8, 23, 23, 14, 18}, 
        //                   {17, 15, 13, 18, 12, 1}, 
        //                   {3, 18, 8, 23, 12, 15}
        //                   };
        // permCol(matrice);
        
        // 5.
        // ordLin(matrice);
        
        // 6.
        // System.out.println(maxApUnu(matrice));
        
        // 7.
        //  int[][] matrice = {
        //                   {4, 20, 15, 23, 18, 9}, 
        //                   {1, 8, 23, 23, 14, 18}, 
        //                   {17, 15, 13, 18, 12, 15}, 
        //                   {3, 18, 8, 23, 12, 5}
        //                   };
        // maxAp(matrice);
        
        // 8. 
        // int[][] matrice = {
        //                   {7, 5, 19}, 
        //                   {3, 8, 4}, 
        //                   {23, 6, 1}, 
        //                   {10, 2, 9}
        //                   };
                          
        // matriceZece(matrice);
        
        // 9.
        int[][] matrice = {
                          {23, 23, 15, 23, 18, 23}, 
                          {17, 17, 17, 17, 17, 17}, 
                          {17, 18, 13, 18, 12, 15}, 
                          {34, 34, 34, 34, 34, 34}
                          };
                          
        System.out.println(cntLinii(matrice));
    }
}