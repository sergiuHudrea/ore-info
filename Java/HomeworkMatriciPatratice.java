import java.util.*;

class HomeworkMatriciPatratice {

    // 1. https://www.pbinfo.ro/probleme/1749/zona4
    public static int zonaPatru(int z, int[][] matrice) {
        int suma = 0;


        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (z == 1) {
                    if ((i + j) < matrice.length - 1 && i < j) {
                        suma += matrice[i][j];
                    }
                } else if (z == 2) {
                    if ((i + j) > matrice.length - 1 && i < j) {
                        suma += matrice[i][j];
                    }
                } else if (z == 3) {
                    if ((i + j) > matrice.length - 1 && i > j) {
                        suma += matrice[i][j];
                    }
                } else if (z == 4) {
                    if ((i + j) < matrice.length - 1 && i > j) {
                        suma += matrice[i][j];
                    }
                }
            }
            
        }
        return suma;
    }


    // 2.https://www.pbinfo.ro/probleme/313/diagonale
    public static int diagonale(int[][] matrice) {
        int sumaDP = 0;
        int sumaDS = 0;

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (i == j) {
                    sumaDP += matrice[i][j];
                } else if (i + j == matrice.length - 1) {
                    sumaDS += matrice[i][j];
                }
            }
        }

        if (sumaDP > sumaDS) {
            return sumaDP - sumaDS;
        } else {
            return sumaDS - sumaDP;
        }
    }

    // 3. https://www.pbinfo.ro/probleme/780/cmmdcsum
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

    public static int cmmdcSum(int[][] matrice) {
        int sumaD = 0;
        int sumaS = 0;

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (i < j) {
                    sumaD += matrice[i][j];
                } else if (i > j) {
                    sumaS += matrice[i][j];
                }
            }
        }

        return cmmdc(sumaD, sumaS);
    }

    // 4. https://www.pbinfo.ro/probleme/786/matsim
    public static void matSim(int[][] matrice) {
        int[][] matSim = new int[matrice.length][matrice.length];

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matSim[j][i] = matrice[i][j];
            }
        }

        for (int i = 0; i < matSim.length; i++) {
            for (int j = 0; j < matSim[i].length; j++) {
                System.out.println(matSim[i][j]);
            }
        }
    }


    // 5. https://www.pbinfo.ro/probleme/781/zone1
    public static void sortCresc(int[] arr) {
        int aux = 0;
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            index = i;
            while (index > 0 && arr[index - 1] > arr[index]) {
                aux = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = aux;
                index--;
            }
        }
    }

    public static int[] zoneUnu(int[][] matrice) {
        int[] sumeZone = new int[4];

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                    if ((i + j) < matrice.length - 1 && i < j) {
                        sumeZone[0] += matrice[i][j];
                    }
                    if ((i + j) > matrice.length - 1 && i < j) {
                        sumeZone[1] += matrice[i][j];
                    }
                    if ((i + j) > matrice.length - 1 && i > j) {
                        sumeZone[2] += matrice[i][j];
                    }
                    if ((i + j) < matrice.length - 1 && i > j) {
                        sumeZone[3] += matrice[i][j];
                    }
                }
        }

        sortCresc(sumeZone);
        return sumeZone;
    }


    // 6. https://www.pbinfo.ro/probleme/787/matsim1
    public static void matSimUnu(int[][] matrice) {
        int[][] matSim = new int[matrice.length][matrice.length];
        int len = matrice.length - 1;

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (i + j == matrice.length - 1) {
                    matSim[i][j] = matrice[i][j];
                } else {
                    matSim[i][j] = matrice[len - j][len - i];
                }
            }
        }

        for (int i = 0; i < matSim.length; i++) {
            System.out.println(Arrays.toString(matSim[i]));
        }
    }

    public static void main(String[] args) {
        
        // 1.
        // int[][] matrice = {
        //     {7, 4, 8, 5, 10}, 
        //     {7, 7, 10, 2, 2}, 
        //     {1, 2, 8, 8, 4}, 
        //     {9, 9, 5, 3, 2}, 
        //     {3, 6, 7, 1, 7} 
        // };

        // int z = 2;
        // System.out.println(zonaPatru(z, matrice));

        // 2.
        // int[][] matrice = {
        //     {8, 3, 3, 7}, 
        //     {1, 1, 6, 5},
        //     {8, 7, 1, 1}, 
        //     {9, 8, 7, 1}, 
        // };

        // System.out.println(diagonale(matrice));

        // 3.
        // int[][] matrice = {
        //     {8, 3, 5, 6 },
        //     {5, 5, 6, 5 },
        //     {3, 8, 6, 5 },
        //     {8, 4, 8, 8 }
        // };

        // System.out.println(cmmdcSum(matrice));

        // 4.
        // int[][] matrice = {
        //     {3, 1, 8, 5}, 
        //     {7, 8, 5, 1}, 
        //     {2, 2, 6, 7},
        //     {9, 8, 1, 3},
        // };

        // matSim(matrice);

        // 5. 
        // int[][] matrice = {
        //     {3, 1, 8, 5, 4}, 
        //     {7, 8, 5, 1, 2}, 
        //     {2, 2, 6, 7, 3},
        //     {9, 8, 1, 3, 6},
        //     {7, 5, 3, 1, 7}
        // };
        // System.out.println(Arrays.toString(zoneUnu(matrice)));

        // 6.
        int[][] matrice = {
            {3, 1, 8, 5}, 
            {7, 8, 5, 1}, 
            {2, 2, 6, 7},
            {9, 8, 1, 3},
        };
        matSimUnu(matrice);
    }
}