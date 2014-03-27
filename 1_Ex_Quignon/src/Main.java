import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	protected static Scanner inputScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int inputLength = inputNumber();
		int[] numbers = new int[inputLength];
		List<Tuple<Integer, String>> computations = new LinkedList<Tuple<Integer, String>>();
		
		//subtask 1
		System.out.println("How many numbers do you want to input?");
		while(inputLength < 1){
			System.out.println("you need to choose a positive number");
			inputLength = inputNumber();
		}
		
		//subtask 2
		for (int i = 0; i < inputLength; i = i + 1){
			System.out.println("Please input an integer");		    
			numbers[i] = inputNumber();
		}
		
		//subtask 3
		computations.add(new Tuple<Integer, String>(sum(numbers), "sum"));
		computations.add(new Tuple<Integer, String>(product(numbers), "product"));
		computations.add(new Tuple<Integer, String>(average(numbers), "average"));
		computations.add(new Tuple<Integer, String>(variance(numbers), "variance"));
		computations.add(new Tuple<Integer, String>(smallestValue(numbers), "smallest value"));
		computations.add(new Tuple<Integer, String>(largestValue(numbers), "largest value"));
		
		//subtask 4
		for (Tuple <Integer, String> result : computations){
		    System.out.println("The " + result.second() 
		    		+ " of the given numbers is:" + result.first());
		}
	}
			
	public static int inputNumber(){
		Integer inputNumber = null;
		while (inputNumber == null) {
		    try {
		        inputNumber = Integer.parseInt(inputScanner.next());
		    } catch (Exception e) {
		        System.out.println( inputScanner + "is not an Integer please input an integer");
		    }
		}
		return inputNumber;
	}
	
	public static int sum(int[] in){
		int sum = 0;
		for(int i = 0; i < in.length; i = i + 1) {
			sum = sum  + in[i];
		}
		return sum;
	}
	
	public static int product (int[] in) {
		int product = 1;
		for(int i = 0; i < in.length; i = i + 1) {
			product = product * in[i];
		}
		return product;
	}

	public static int average (int[] in){
		return sum(in) / in.length;
	}
	
	public static int variance(int[]in){
		int sum = 0;
		int squareSum = 0;
		int variance;
		
		for(int i = 1; i < in.length; i = i + 1){
			sum = sum + in[i];
			squareSum = squareSum + in[i] * in[i];
		}
		variance = (squareSum - sum * sum) / (in.length - in.length - 1);
		return variance;
	}
	
	public static int smallestValue(int[] in){
		int minimum = in[0];
		for(int i = 1; i < in.length; i = i + 1){
			if (in[i] < minimum) minimum = in[i]; 
		}
		return minimum;
	}

	public static int largestValue(int[] in){
		int maximum = in[0];
		for(int i = 1; i < in.length; i = i + 1){
			if (in[i] > maximum) maximum = in[i]; 
		}
		return maximum;
	}
}