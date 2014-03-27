import java.util.Scanner;

public class Main {
	protected static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//subtask 1
		System.out.println("Please put in the diameter of your circle:");
		double diameter = inputNumber();
		
		System.out.println("Please put in the maximum precision of pi:");
		double precision = inputNumber();
		
		double piApproximation=3;
		double circumference = piApproximation*diameter;
		double area = piApproximation*diameter/2*diameter/2;
		
		System.out.format("%n%-10s %-24s %-24s %-24s %-24s %-24s %n"
				, "Iteration"
				, "Area"
				, "Area growth"
				, "Circumference"
				, "Circumference growth"
				, "Approximated pi" );
		
		for (int i=0; i<precision; i=i+1){
			//subtask 3 & 4
			piApproximation=Math.floor(Math.PI * Math.pow(10, i)) / Math.pow(10, i);
			System.out.format("%-10s %-24s %-24s %-24s %-24s %-400s%n"
					, i + 1  
					, (piApproximation * diameter / 2 * diameter / 2)
					, 1 -(area / (piApproximation * diameter / 2 * diameter / 2)) + "%"
					, (piApproximation * diameter)
					, 1 - (circumference / (piApproximation * diameter)) + "%"
					, piApproximation );				
			circumference = piApproximation * diameter;
			area = piApproximation * diameter / 2 * diameter / 2;
		}
		System.out.println("Precision is limited by its datatype double.");
	}


	public static double inputNumber(){
		Double inputNumber = null;
		//subtask 2
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