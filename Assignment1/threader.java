class MatrixMultiply extends Thread {
	private int[][] A;
	private int[][] B;
	private int[][] C;
	//private int row;
	//private int col;
	private int t; // thread nr.
	private int nor; // number of rows in each thread
	private int n; // dimension of matrix
	
	//public MatrixMultiply(int[][] A, int[][] B, int[][] C, int row, int col, int n) {
	public MatrixMultiply(int[][] A, int[][] B, int[][] C, int t, int nor, int n) {
		this.A = A;
		this.B = B;
		this.C = C;
		//this.row = row;
		//this.col = col;
		this.t = t;
		this.nor = nor;
		this.n = n;
	}

	public void run() {
		for (int i=nor*t; i<nor*(t+1); i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		//System.out.println("Thread nr. " + t + " is finished");
	}
		
	/*
	public void run() {
		for (int i=0; i<n; i++) {
			C[row][col] += A[row][i]*B[i][col];
		}
		System.out.println("The thread calculating " + row + ", " + col + " is done");
	}
	*/
}
