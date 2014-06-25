import java.lang.Math;


public class Main {

	public static void main(String[] args) {
		double[][] results = new double[100][7];
		
		for(int n = 0; n < (results.length); n = n + 1){
			results[n][0] = n;
			results[n][1] = twice(n);
			results[n][2] = cubic(n);
			results[n][3] = squareRoot(n);
			results[n][4] = twoPowerOfNHalf(n);
			results[n][5] = tenPowerN(n);
			results[n][6] = ePowN(n);
		}
		
		System.out.format("%14s%14s%14s%14s%14s%14s%14s%n",
				"n=",
				"f(n)=2n",
				"f(n)=n^3",
				"f(n)=n^(1/2)", 
				"f(n)=2^(1/n)",
				"f(n)=10^(n)", 
				"f(n)=e^(n)" );
		
		for(int i = 0; i < (results.length); i = i + 1){
			System.out.format("%14g%14g%14g%14g%14g%14g%14g%n",
					results[i][0],
					results[i][1],
					results[i][2],
					results[i][3],
					results[i][4],
					results[i][5],
					results[i][6]);
		}	
	}

	private static double ePowN(int n) {
		return Math.pow(Math.E, n);
	}

	private static double tenPowerN(int n) {
		return Math.pow(10, n);
	}

	private static double twoPowerOfNHalf(double n) {
		return Math.pow(2, (1/n));
	}

	private static double squareRoot(double n) {
		return Math.sqrt(n);
	}

	private static double cubic(double n) {
		return n * n * n;
	}

	private static double twice(double n) {
		return 2 * n;
	}
}
