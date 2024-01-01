import java.util.*;

public class HomeworkGenerareMatrici {
    // 1. https://www.pbinfo.ro/probleme/206/genmat1
    public static int[][] genMatUnu(int row, int col) {
        int[][] matGen = new int[row][col];
        int nrRow = 0;
        int nrCol = 0;
        
        for (int i = 0; i < row; i++) {
            nrRow = i + 1;
            for (int j = 0; j < col; j++) {
                nrCol = j + 1;
                
                if (nrRow < nrCol) {
                    matGen[i][j] = nrRow;
                } else {
                    matGen[i][j] = nrCol;
                }
            }
        }
        
        for (int i = 0; i < matGen.length; i++) {
            System.out.println(Arrays.toString(matGen[i]));
        }
        
        return matGen;
    }
    
    // 2.https://www.pbinfo.ro/probleme/207/genmat2
    public static int[][] genMatDoi(int rowCol) {
        int[][] matGen = new int[rowCol][rowCol];
        int rowColCopy = rowCol;
        
        for (int i = 0; i < rowCol; i++) {
            for (int j = 0; j < rowCol; j++) {
                if (i == j) {
                    matGen[j][i] = 0;
                } else {
                    matGen[j][i] = rowColCopy;
                }
            }
            rowColCopy--;
        }
        
        for (int i = 0; i < matGen.length; i++) {
            System.out.println(Arrays.toString(matGen[i]));
        }
        
        return matGen;
    }
    
    // 3. https://www.pbinfo.ro/probleme/208/genmat3
    public static int[][] genMatTrei(int row, int col) {
        int[][] matGen = new int[row][col];
        int imp = 1;
        int patrat = 0;
        
        
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
              patrat = (int)Math.pow(imp, 2);
              matGen[i][j] = patrat;
              imp += 2;
        }
            
    }
     
    for (int i = 0; i < matGen.length; i++) {
            System.out.println(Arrays.toString(matGen[i]));
    }
        
    
    return matGen;
    }

    // 4. https://www.pbinfo.ro/probleme/213/genmat4
    public static int[][] genMatPatru(int nr) {
        int[][] matGen = new int[nr][nr];

        for (int i = 0; i < nr; i++) {
            matGen[0][i] = i + 1;
            matGen[i][0] = i + 1;
        }

        for (int i = 1; i < nr; i++) {
            for (int j = 1; j < nr; j++) {
                matGen[i][j] = matGen[0][j] * matGen[i][0];
            }
        }

        for (int i = 0; i < matGen.length; i++) {
            System.out.println(Arrays.toString(matGen[i]));
    }

        return matGen;
    }


    // 5. https://www.pbinfo.ro/probleme/214/genmat5
    public static int nrCifre(int n) {
        int nrCifre = 0;
	    int aux = n;
	    while (aux > 0) {
	        nrCifre += 1;
	        aux /= 10;
	    }

        return nrCifre;
    }
    public static int[][] genMatCinci(int n) {
        int nrCifre = nrCifre(n);
        int[][] matGen = new int[nrCifre][nrCifre];

        for (int i = 0; i < nrCifre; i++) {
            for (int j = 0; j < nrCifre; j++) {
                matGen[j][i] = n % 10;
            }
            n /= 10;
        }

        for (int i = 0; i < matGen.length; i++) {
            System.out.println(Arrays.toString(matGen[i]));
    }

        return matGen;

    }
    
    
    public static void main(String[] args) {
        
        // 1.
        // genMatUnu(4, 5);
        
        // 2.
        // genMatDoi(4);
        
        // 3.
        // genMatTrei(2, 3);

        // 4.
        // genMatPatru(4);

        // 5.
        genMatCinci(1359);
    }
}
