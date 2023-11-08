class Matrici {
    // 1.
    public static void diagPrincipala(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            System.out.println(matrice[i][i]);
        }
    }
    
    // 2.
    public static void diagPrincipalaDoi(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (i == j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 3.
    public static void diagSecundara(int[][] matrice) {
         for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if ((i + j) == matrice.length - 1) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 4.
    public static void diagPrincipalaRev(int[][] matrice) {
        for (int i = matrice.length - 1; i >= 0; i--) {
            for (int j = matrice.length - 1; j >= 0; j--) {
                if (i == j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 5.
    public static void diagSecundaraRev(int[][] matrice) {
        for (int i = matrice.length - 1; i >= 0; i--) {
            for (int j = matrice.length - 1; j >= 0; j--) {
                if ((i + j) == matrice.length - 1) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    
    // 6.
    public static void subPrincipala(int[][] matrice) {
        int len = matrice.length;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i > j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 7.
    public static void deasupraPrincipala(int[][] matrice) {
        int len = matrice.length;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i < j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 8.
    public static void subSecundara(int[][] matrice) {
        for (int i = 0; i < matrice.length ; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if ((i + j) > matrice.length - 1) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 9.
    public static void deasupraSecundara(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if ((i + j) < matrice.length - 1) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 10.
    public static void deasupraSDeasupraP(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if ((i + j) < matrice.length - 1 && i < j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 11.
    public static void deasupraSSubP(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if ((i + j) < matrice.length - 1 && i > j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 12.
     public static void subSSubP(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if ((i + j) > matrice.length - 1 && i > j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 13.
    public static void subSDeasupraP(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if ((i + j) > matrice.length - 1 && i < j) {
                    System.out.println(matrice[i][j]);
                }
            }
        }
    }
    
    // 14. https://www.pbinfo.ro/probleme/767/sumapare2
    public static int sumaPareDoi(int[][] matrice) {
        int suma = 0;
        
         for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if (matrice[i][j] % 2 == 0) {
                    suma += matrice[i][j];
                }
            }
        }
        
        return suma;
    }
    
    
    
    public static void main(String[] args) {
        int[][] matrice = {{1, 2, 3, 4}, 
                           {5, 6, 7, 8}, 
                           {9, 10, 11, 12}, 
                           {13, 14, 15, 16}
                          };
        // 1.
        // diagPrincipala(matrice);
        
        // 2.
        // diagPrincipalaDoi(matrice);
        
        // 3.
        // diagSecundara(matrice);
        
        // 4.
        // diagPrincipalaRev(matrice);
        
        // 5.
        // diagSecundaraRev(matrice);
        
        // 6.
        // subPrincipala(matrice);
        
        // 7.
        // deasupraPrincipala(matrice);
        
        // 8.
        // subSecundara(matrice);
        
        // 9.
        // deasupraSecundara(matrice);
        
        // 10.
        // deasupraSDeasupraP(matrice);
        
        // 11.
        // deasupraSSubP(matrice);
        
        // 12.
        // subSSubP(matrice);
        
        // 13.
        // subSDeasupraP(matrice);
        
        // 14.
        System.out.println(sumaPareDoi(matrice));
    }
}