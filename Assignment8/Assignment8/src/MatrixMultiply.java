import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMultiply {

	public static double dotProduct(double[] v1, double[] v2) {
		if (v1.length != v2.length) {
			throw new ArithmeticException("vectors must be same length");
		} else {
			double result = 0;
			for (int i =0;i<v1.length ;i++) {
				result += v1[i]*v2[i];
			}
			return result;
		}
	}
	
	public static double[] getColumn(double[][] matrix, int column) {
		double[] vector = new double[matrix.length];
		for (int i=0;i<matrix.length;i++) {
			vector[i] = matrix[i][column];
		}
		return vector;
	}
	
	public static double[][] matrixMultiply(double[][] m1, double[][] m2, int numThreads) {
		int m1Rows = m1.length;
		int m2Columns = m2[0].length;
		int m2Rows = m2.length;
		int m1Columns = m1[0].length;
		if (m2Rows != m1Columns) {
			throw new ArithmeticException("incompatible matrices");
		}

		double[][] result = new double[m1Rows][m2Columns];
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		System.out.println("Using thread pool with 1 threads:");
//		System.out.println("Using " + numThreads + " threads:");
		if(numThreads > 0) {
//			MatrixThread[] threads = new MatrixThread[numThreads];
			int page = m1.length / numThreads;
		
			for(int i = 0; i < numThreads; i++) {
				int start = page * i;
				int end = start + page - 1;
//				threads[i] = new MatrixThread(m1, m2, result, start, end);
//				threads[i].run();
				executor.execute(new MatrixThread(m1, m2, result, start, end));
			}
		
//			for(int i = 0; i < numThreads; i++) {
//				try {
//					threads[i].join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		} else {
			for (int column=0;column < m2[0].length; column++) {
				double[] m2Col = getColumn(m2, column);
				for (int row=0;row < m1.length;row++) {
					double val = dotProduct(m1[row], m2Col);
					result[row][column] = val;
				}
			}
		}
		return result;
	}
	
	public static class MatrixThread extends Thread implements Runnable {
		private double[][] m1;
		private double[][] m2;
		private double[][] m3;
		private int start;
		private int end;
		
		public MatrixThread(double[][] m1, double[][] m2, double[][] m3, int start, int end) {
			this.m1 = m1;
			this.m2 = m2;
			this.m3 = m3;
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			for (int column = start; column < end; column++) {
				double[] m2Col = getColumn(m2, column);
				for (int row = start; row < end; row++) {
					double val = dotProduct(m1[row], m2Col);
					m3[row][column] = val;
				}
			}	
		}

		
	}
	
	public static void main(String[] args) {
		final int NUM_THREADS = 340;
		int m=2500,n=2500;
		double[][] matrix1 = new double[m][n];
		double[][] matrix2 = new double[m][n];
		double[][] matrix3 = new double[m][n];
		
		System.out.println("Using an M1 Mac:");
		System.out.println("360 threads performed the best without a thread pool.");
		System.out.println("1 thread performed the best with a fixed thread pool");
		System.out.println("--------------------");
		
		System.out.println(Runtime.getRuntime().availableProcessors() + " processors");
		for (int i=0;i<matrix1.length;i++) {
			for (int j=0;j<matrix1[i].length;j++) {
				matrix1[i][j] = ((int)(Math.random()*2500))/100.0;
			}
		}
		for (int i=0;i<matrix2.length;i++) {
			for (int j=0;j<matrix2[i].length;j++) {
				matrix2[i][j] = ((int)(Math.random()*2500))/100.0;
			}
		}
		
		for (int i=0;i<matrix3.length;i++) {
			for (int j=0;j<matrix3[i].length;j++) {
				matrix3[i][j] = ((int)(Math.random()*2500))/100.0;
			}
		}
		/*
		for (int i=0;i<matrix1.length;i++) {
			for (int j=0;j<matrix1[i].length;j++) {
				System.out.print(matrix1[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println();
		for (int i=0;i<matrix2.length;i++) {
			for (int j=0;j<matrix2[i].length;j++) {
				System.out.print(matrix2[i][j] + "\t");
			}
			System.out.println();
		}*/
		long startTime = System.currentTimeMillis();
		double[][] firstResult = matrixMultiply(matrix1, matrix2, NUM_THREADS);
		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		System.out.println("time to multiply " + m + " x " + n + " matrices: ");
		System.out.println(elapsed + "ms");

		/*
		System.out.println();
		for (int i=0;i<firstResult.length;i++) {
			for (int j=0;j<firstResult[i].length;j++) {
				firstResult[i][j] = ((int)(firstResult[i][j]*100))/100.0;
				System.out.print(firstResult[i][j] + "\t");
			}
			System.out.println();
		}*/
		
		startTime = System.currentTimeMillis();
		double[][] finalResult = matrixMultiply(firstResult, matrix3, NUM_THREADS);
		endTime = System.currentTimeMillis();
		long elapsed2 = endTime - startTime;

		System.out.println("total time to multiple all three matrices:");
		System.out.println((elapsed+elapsed2) + "ms");
		
		/*
		System.out.println();
		for (int i=0;i<finalResult.length;i++) {
			for (int j=0;j<finalResult[i].length;j++) {
				finalResult[i][j] = ((int)(finalResult[i][j]*100))/100.0;
				System.out.print(finalResult[i][j] + "\t");
			}
			System.out.println();
		}*/
	}
}
