import java.util.*;

public class HomeworkBacktrackingCombinariSiPowerSets {
    // 1.https://www.pbinfo.ro/probleme/197/combinari
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

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        return list;
    }

    public static void combinariHelper(List<Integer> result, List<Integer> m, int current, int k) {
        if (nrCifre(current) == k) {
            result.add(current);
        } else {
            for ( int i = 0; i < m.size(); i++) {
                List<Integer> newM = new ArrayList<>();
                for (int j = i + 1; j < m.size(); j++) {
                    newM.add(m.get(j));
                }

                int newCurrent = current;
                if (newCurrent == 0) {
                    newCurrent += m.get(i);
                } else {
                    newCurrent *= 10;
                    newCurrent += m.get(i);
                }

                combinariHelper(result, newM, newCurrent, k);
            }
        }
    }

    public static List<Integer> combinari(int m, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> listM = makeList(m);

        combinariHelper(result, listM, 0, k);
        return result;
    }


    // 2. https://www.pbinfo.ro/probleme/3152/combinari2
    public static void combinariDoiHelper(List<Integer> result, List<Integer> m, int current, int k) {
        if (nrCifre(current) == k) {
            result.add(current);
        } else {
            for (int i = 0; i < m.size(); i++) {
                List<Integer> newM = new ArrayList<>();
                for (int j = i + 1; j < m.size(); j++) {
                    newM.add(m.get(j));
                }

                int newCurrent = current;
                if (newCurrent == 0) {
                    newCurrent += m.get(i);
                } else if (!((newCurrent % 10) % 2 == 0 && m.get(i) % 2 == 0)) {
                    newCurrent *= 10;
                    newCurrent += m.get(i);
                }

                combinariDoiHelper(result, newM, newCurrent, k);
            }
        }
    }

    public static List<Integer> combinariDoi(int m, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> listM = makeList(m);

        combinariDoiHelper(result,listM, 0, k);
        return result;
    }

    
    // 3. https://www.pbinfo.ro/probleme/204/siruri
    public static void siruriHelper(List<Integer> result, List<Integer> m, int current, int k) {
        if (nrCifre(current) == k) {
            result.add(current);
        } else {
            for (int i = 0; i < m.size(); i++) {
                List<Integer> newM = new ArrayList<>();
                for (int j = i + 1; j < m.size(); j++) {
                    newM.add(m.get(j));
                }

                int newCurrent = current;
                if (newCurrent == 0) {
                    newCurrent += m.get(i);
                } else if ((newCurrent % 10) - m.get(i) <= 2 && m.get(i) - newCurrent % 10 <= 2) {
                    newCurrent *= 10;
                    newCurrent += m.get(i);
                }

                siruriHelper(result, newM, newCurrent, k);
            }
        }
    }

    public static List<Integer> siruri(int m, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> listM = makeList(m);

        siruriHelper(result, listM, 0, k);
        return result;
    }


    // 4.https://www.pbinfo.ro/probleme/201/submdiv
    public static List<Integer> listDividers(int n) {
        List<Integer> listDiv = new ArrayList<>();
		
		for (int i = 1; i < (int)Math.sqrt(n); i++) {
			if (n % i == 0) {
                listDiv.add(i);
                listDiv.add(n / i);
			}
		}

		if (n % (int)Math.sqrt(n) == 0) {
			listDiv.add((int)Math.sqrt(n));
		}

        Collections.sort(listDiv);

        return listDiv;
	}
    public static void submDivHelper(List<List<Integer>> result, List<Integer> m, List<Integer> current, int k) {
        if (current.size() == k) {
            result.add(current);
        } else {
            for (int i = 0; i < m.size(); i++) {
                List<Integer> newM = new ArrayList<>();
                for (int j = i + 1; j < m.size(); j++) {
                    newM.add(m.get(j));
                }

                List<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(m.get(i));
                
                
                submDivHelper(result, newM, newCurrent, k);
            }
        }
    }
    public static List<List<Integer>> submDiv(int m, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> listDiv = listDividers(m);

        submDivHelper(result, listDiv, new ArrayList<>() , k);
        return result;
    }

    // 5. https://www.pbinfo.ro/probleme/3160/cifre-c
    public static List<Integer> makeListFromNr(int n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n%10);
            n /= 10;
        }
        Collections.sort(list);
        return list;
    }

    public static void cifreCHelper(List<Integer> result, List<Integer> m, int current, int k) {
        if (nrCifre(current) == k) {
            result.add(current);
        } else {
            for (int i = 0 ; i < m.size(); i++) {
                List<Integer> newM = new ArrayList<>();
                for (int j = i + 1; j < m.size(); j++) {
                    newM.add(m.get(j));
                }

                int newCurrent = current;
                newCurrent *= 10;
                newCurrent += m.get(i);

                cifreCHelper(result, newM, newCurrent, k);
            }
        }
    }
    public static List<Integer> cifreC(int m, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> listM = makeListFromNr(m);

        cifreCHelper(result, listM, 0, k);
        Collections.reverse(result);
        return result;
    }

    
    public static void main(String[] args) {
        // 1.
        // List<Integer> result = combinari(4, 2);

		// for (Integer newResult: result) {
		// 	System.out.println(newResult.toString());
		// }


        // 2. 
        // List<Integer> result = combinariDoi(5, 3);

		// for (Integer newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 3.
        // List<Integer> result = siruri(5, 3);

		// for (Integer newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 4.
        // List<List<Integer>> result = submDiv(45, 4);
        

        // for (List<Integer> newResult: result) {
		// 	System.out.println(newResult.toString());
		// }

        // 5.
        List<Integer> result = cifreC(4618, 3);
        for (Integer newResult: result) {
			System.out.println(newResult.toString());
		}

    }
}
