public class Multiplier {
        public static void main ( String [] args) {

		// n - dimension of matrices
                int n = Integer.parseInt(args[0]);
		// not - nr of threads
		int not = Integer.parseInt(args[1]);
		// nor - nr of rows in each thread
		int nor = n/not;
                double r;
                int r_int;

                if (n%not != 0) {
                        System.out.println("Current number of threads is impossible");
                        System.exit(-1);
                }

		// Generate two random matrices, A and B,
		// with numbers between 1 and 100
                System.out.println("Matrix A: ");
                int [][] A = new int[n][n];
                for (int i=0; i<n; i++) {
                        for (int j=0; j<n; j++) {
                                r = Math.random()*100 +1;
                                r_int = (int)r;
                                A[i][j] = r_int;
                        //        System.out.print(r_int + " ");
                        }
                        //System.out.println();
                }

                System.out.println();
                System.out.println("Matrix B: ");
                int [][] B = new int[n][n];
                for (int i=0; i<n; i++) {
                        for (int j=0; j<n; j++) {
                                r = Math.random()*100 +1;
                                r_int = (int)r;
                                B[i][j] = r_int;
                        //        System.out.print(r_int + " ");
                        }
                        //System.out.println();
                }
                System.out.println();

                //Generate new matrix C
                int [][] C = new int[n][n];
                MultiplierThreads[] thread = new MultiplierThreads[not];

                // Start time
                long start_time = System.nanoTime();


                for (int i=0; i<not; i++) {
                        thread[i] = new MultiplierThreads(A,B,C,i,nor,n);
                        thread[i].start();
                }

                for (int i=0; i<not; i++) {
                        try {
                                thread[i].join();
                        }
                        catch(InterruptedException e) {}
                }

		int sum = 0;
		for (int i=0; i<n; i++) {
			sum += C[i][i];
		}

                // Time used
                long used_time = System.nanoTime() - start_time;


                //System.out.println("The sum of the diagional is: " + sum);

                System.out.println();
                System.out.println("Elapsed time is: " + (float)used_time/1000000000 + " seconds");
                System.out.println();
                System.out.println("Results: ");

                //for (int i=0; i<n; i++) {
                  //      for (int j=0; j<n; j++) {
                    //            System.out.print(C[i][j] + " ");
                      //  }
                       // System.out.println();
                //}
        }

}
