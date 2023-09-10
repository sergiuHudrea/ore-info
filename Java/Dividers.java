class Dividers {
	public static void prinDividers(int n) {
		
		for (int i = 1; i < (int)Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println(i);
				System.out.println(n / i);
			}
		}

		if (n % (int)Math.sqrt(n) == 0) {
			System.out.println((int)Math.sqrt(n));
		}
	}

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

	public static int cmmdcArr(int[] arr) {
		// Etapa de initializare
		int auxA = arr[0];
		int auxB = arr[1];
		int div = Dividers.cmmdc(auxA, auxB);


		for (int i = 2; i < arr.length; i++) {
			div = Dividers.cmmdc(div, arr[i]);
		}

		return div;
	}


	public static int cmmmc(int a, int b) {
		int auxA = a;
		int auxB = b;

		while (auxA != auxB) {
			if (auxA < auxB) {
				auxA += a;
			} else {
				auxB += b;
			}
		}

		return auxA;
	}

	public static int cmmmcArr(int[] arr) {
		// Etapa de initializare
		int auxA = arr[0];
		int auxB = arr[1];
		int div = Dividers.cmmmc(auxA, auxB);


		for (int i = 2; i < arr.length; i++) {
			div = Dividers.cmmmc(div, arr[i]);
		}

		return div;
	}


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


	public static void main(String[] args) {
		// int nB = 36;
		// int nR = 85;

		// Dividers.prinDividers(nB);
		// Dividers.prinDividers(nR);

		// int n1 = 17;
		// int n2 = 35;
		// System.out.println(cmmdc(n1, n2));
		

		// int[] arr = new int[] {32, 24, 41};

		// System.out.println(Dividers.cmmdcArr(arr));

		// int n1 = 8;
		// int n2 = 6;
		// System.out.println(Dividers.cmmmc(n1, n2));

		// int[] arr = new int[] {8, 6, 4};

		// System.out.println(Dividers.cmmmcArr(arr));

		int n1 = 8;

		System.out.println(Dividers.isPrime(n1));

	}
}