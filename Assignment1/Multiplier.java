class A1 {
        public static void main ( String [] args) {

		// Generate a matrix with a random 
		// number between 1 and 100
		int n = Integer.parseInt(args[0]); 
               	double r;
		int r_int;
		int [][] A = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				r = Math.random()*100 +1;
				r_int = (int)r;
				A[i][j] = r_int;
				System.out.print(r_int + " ");
			}
			System.out.println();
		}
 		
		// Generate new matrix C
		int [][] C = new int[n][n];

		// Start time
		long start_time = System.nanoTime();

		// Do matrix multiplication
		C = matrixMultiply(A,A);

		int sum = 0;
		for (int i=0; i<n; i++) {
			sum += C[i][i];
		}
	
		// Time used
		long used_time = System.nanoTime() - start_time;
		
		System.out.println("The sum of the diagional is: " + sum);
		System.out.println("Elapsed time is: " + used_time + " nanoseconds");

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}	
        }

	public static int[][] matrixMultiply( int [][] A, int [][] B ) {
		int n = A.length;
		int [][] C = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		} 
		
		return C;
	} 
}

