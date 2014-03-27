import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	protected static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("Please put in the diameter of your circle:");
		double diameter = inputNumber();
		
		System.out.println("Please put in the maximum precisionof pi:");
		double precision = inputNumber();
		
		double pi;
		double circumference;
		
		//Borwein's algorithm
		double a=6-4*Math.sqrt(2);
		double y=Math.sqrt(2)-2;
		
		for (int k=1; k<precision; k=k+1){
			y=(1-Math.pow((1-(Math.pow(y, 4))), 0.25))
					/(1+Math.pow((1-Math.pow(y, 4)), 0.25));
			a=a*(Math.pow((1+y), 4))
					- 2*Math.pow(2, 2*k+3)*y*(1+y+y*y);
			pi= a;//NOPE!
			
			circumference=pi*diameter;
			
			System.out.println("First iteration precision:" + String.format("%."+k+"g%n", pi));
			if (k>1){
				System.out.println("The percentual growth of the circumference of a circle with a diameter of"
						+ diameter + " is "+(pi*diameter)/circumference + "%");
				circumference=pi*diameter;
			}
		}
		
		//
		
		
		
	}
	
	

	public static double inputNumber(){
		Double inputNumber = null;
		while (inputNumber == null) {
		    try {
		        inputNumber = Double.parseDouble(input.next());
		        while(inputNumber<1){
		        	System.out.println("You need to choose a positive number");
		        }
		    } catch (Exception e) {
		        System.out.println( input + "is not an Integer please input an integer");}
		}
		return inputNumber;
	}
}