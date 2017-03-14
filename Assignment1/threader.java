class MatrixMultiply extends Thread {
	private int[][] A;
	private int[][] B;
	private int[][] C;
	private int row;
	private int col;
	private int n; // dimension
	
	public MatrixMultiply(int[][] A, int[][] B, int[][] C, int row, int col, int n) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.row = row;
		this.col = col;
		this.n = n;
	}

	public void run() {
		for (int i=0; i<n; i++) {
			C[row][col] += A[row][i]*B[i][col];
		}
		System.out.println("The thread calculating " + row + ", " + col + " is done");
	}
}
