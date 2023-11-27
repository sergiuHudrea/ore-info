import java.util.*;

public class MatriciAprofundare {
    // 1. Diag Traverse Bottom left to top right
    public static void bottomLeftToTopRight(int[][] mat, int startRow, int startCol) {
        while (startRow >= 0 && startCol < mat[0].length) {
            System.out.println(mat[startRow][startCol]);
            startRow--;
            startCol++;
        }
    }

    // 2. Diag Traverse top right to bottom left
    public static void topRightToBottomLeft(int[][] mat, int startRow, int startCol) {
        while (startRow < mat.length && startCol >= 0) {
            System.out.println(mat[startRow][startCol]);
            startRow++;
            startCol--;
        }
    }

    // 3. Diag Traverse bottom right to top left
    public static void bottomRightToTopLeft(int[][] mat, int startRow, int startCol) {
        while (startRow >= 0 && startCol >= 0) {
            System.out.println(mat[startRow][startCol]);
            startRow--;
            startCol--;
        }
    }

    // 4. Diag Traverse top left to bottom right
    public static void topLeftToBottomRight(int[][] mat, int startRow, int startCol) {
        while (startRow < mat.length && startCol < mat[0].length) {
            System.out.println(mat[startRow][startCol]);
            startRow++;
            startCol++;
        }
    }

    // 5. https://www.pbinfo.ro/probleme/794/serpuire
    public static void serpuire(int[][] mat) {
        int startCol = 0;
        int startRow = 0;
        boolean isSecDiagTraversed = false;

        while (startRow < mat.length && startCol < mat[0].length) {

            if (startCol + startRow == mat.length - 1) {
                isSecDiagTraversed = true;
            }

            while (startRow < mat.length && startCol >= 0) {
            System.out.println(mat[startRow][startCol]);
            startRow++;
            startCol--;
            }
    
            if (isSecDiagTraversed) {
                startRow--;
                startCol += 2;
            } else {
                startCol++;
            }
            
            if (startCol + startRow == mat.length - 1) {
                isSecDiagTraversed = true;
            }

            while (startRow >= 0 && startCol < mat[0].length) {
                System.out.println(mat[startRow][startCol]);
                startRow--;
                startCol++;
            }

            if (isSecDiagTraversed) {
                startRow += 2;
                startCol--;
            } else {
                startRow ++;
            }

        }
    }

    // 6. https://www.pbinfo.ro/probleme/4024/matprod
    public static List<Integer> buildRoad(int mat[][], int row, int col) {
        List<Integer> road = new LinkedList<>();

        int r = 0;
        int c = 0;

        while (r <= row) {
            road.add(mat[r][c]);
            r++;
        }

        r--;
        c++;

        while (c <= col) {
            road.add(mat[r][c]);
            c++;
        }

        return road;
    }

    public static int roadSum(List<Integer> road) {
        int sum  = 0;

        for (int i = 0; i < road.size() - 1; i++) {
            for (int j = i + 1; j < road.size(); j++) {
                sum += road.get(i) * road.get(j);
            }
        }

        return sum;
    }



    public static int[][] matProd(int[][] mat) {
        int[][] matrixProd = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                List<Integer> road = buildRoad(mat, i, j);
                matrixProd[i][j] = roadSum(road);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(matrixProd[i]));
        }

        return matrixProd;
    }

        

    

    public static void main(String[] args) {
        // 5.
        // int[][] matrice = {
        //         {1, 3, 4, 10}, 
        //         {2, 5, 9, 11}, 
        //         {6, 8, 12, 15},
        //         {7, 13, 14, 16}
        //     };

        // serpuire(matrice);

        // 6.
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 0},
            {9, 3, 7}
        };

        matProd(mat);
            
    }
}
