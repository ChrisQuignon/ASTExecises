import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	protected static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		//subtask 1
		System.out.println("How many numbers do you want to input?");
		int inputlength = inputNumber();
		while(inputlength<1){
			System.out.println("you need to choose a positive number");
			inputlength = inputNumber();
		}
		int[] numbers = new int[inputlength];
		
		//subtask 2
		for (int i = 0; i<inputlength; i=i+1){
			System.out.println("Please input an integer");		    
			numbers[i]=inputNumber();
		}
		
		//subtask 3
		List<Tuple<Integer, String>> computations = new LinkedList<Tuple<Integer, String>>();
	 	
		computations.add(new Tuple<Integer, String>(sum(numbers), "sum"));
		computations.add(new Tuple<Integer, String>(product(numbers), "product"));
		computations.add(new Tuple<Integer, String>(average(numbers), "average"));
		computations.add(new Tuple<Integer, String>(variance(numbers), "variance"));
		computations.add(new Tuple<Integer, String>(smallestValue(numbers), "smallest value"));
		computations.add(new Tuple<Integer, String>(largestValue(numbers), "largest value"));
		
		//subtask 4
		for (Tuple <Integer, String> element : computations){
		    System.out.println("The " + element.second() + " of the given numbers is:" + element.first());
		}
		
	}
			
	public static int inputNumber(){
		Integer inputNumber = null;
		while (inputNumber == null) {
		    try {
		        inputNumber = Integer.parseInt(input.next());
		    } catch (Exception e) {
		        System.out.println( input + "is not an Integer please input an integer");}
		}
		return inputNumber;
	}
	
	public static int sum(int[] in){
		int sum =0;
		for(int i=0; i<in.length; i=i+1) sum=sum+in[i];
		return sum;
	}
	
	public static int product (int[] in) {
		int product=1;
		for(int i=0; i<in.length; i=i+1) product=product*in[i];
		return product;
	}

	public static int average (int[] in){
		return sum(in)/in.length;
	}
	
	public static int variance(int[]in){
		int sum = 0;
		int sqrsum = 0;
		for(int i=1; i<in.length; i=i+1){
			sum=sum+in[i];
			sqrsum=sqrsum+in[i]*in[i];
		}
		return (sqrsum-sum*sum)/(in.length-in.length-1);
	}
	
	public static int smallestValue(int[] in){
		int min=in[0];
		for(int i=1; i<in.length; i=i+1){
			if (in[i] < min) min = in[i]; 
		}
		return min;
	}

	public static int largestValue(int[] in){
		int max=in[0];
		for(int i=1; i<in.length; i=i+1){
			if (in[i] > max) max = in[i]; 
		}
		return max;
	}
}