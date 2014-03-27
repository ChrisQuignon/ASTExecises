import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
	public static void main(String[] args) {
		
		
		int largestInteger =  Integer.MAX_VALUE; 
		long calculationTimeLargestInteger=0;
		long largestLong = Long.MAX_VALUE;
		long calculationTimeLargestLong=0;
		
		long startTime=0;
		long endTime=0;
		
		//subtask 2
		List<Integer> integerPrimeList = new LinkedList<Integer>();
		
		startTime = System.currentTimeMillis();
		integerPrimeList = allprimes(largestInteger);
		endTime = System.currentTimeMillis();
		calculationTimeLargestInteger=endTime-startTime;
		
		startTime = System.currentTimeMillis();
		List<Long> longPrimeList=new LinkedList<Long>();
		longPrimeList = allprimes(largestLong);
		endTime = System.currentTimeMillis();
		calculationTimeLargestLong=endTime-startTime;
		
		//subtask 3
		System.out.println("Prime Numbers up to " + largestInteger + ": ");
		for (int prime : integerPrimeList){
			System.out.print(prime + ", ");		
		}
		System.out.println("");
		System.out.println("Time to compute in milliseconds: " + calculationTimeLargestInteger);
		
		
		System.out.println("Prime Numbers up to " + largestLong + ": ");
		for (long prime : longPrimeList){
			System.out.print(prime + ", ");		
		}
		System.out.println("");
		System.out.println("Time to compute in milliseconds: " + calculationTimeLargestLong);		
	}
	
	//task 1
	private static List<Long> allprimes(Long n) {
		List<Long> primeList = new LinkedList<Long>();
		
		//fill List
		for(long i =1; i<10; i=i+1){
			primeList.add(i);
			}
		
		ListIterator<Long> iterator = primeList.listIterator();
		if(iterator.hasNext()){
			iterator.next();
			for (Long previous = iterator.next(); iterator.hasNext(); ) {
				int index=iterator.nextIndex();
				
			    while (iterator.hasNext()) {
			    	long next=iterator.next();
			    	if(next%previous==0) {
			    		iterator.remove();
			    	}
			    }
			    iterator=primeList.listIterator(index);
			    iterator.next();
			}
		}
		return primeList;
	}

	private static List<Integer> allprimes(Integer n) {
		List<Integer> primeList = new LinkedList<Integer>();
		
		//fill List
		for(int i =1; i<=113; i=i+1){
			primeList.add(i);
			}
		
		ListIterator<Integer> iterator = primeList.listIterator();
		if(iterator.hasNext()){
			iterator.next();
			for (Integer previous = iterator.next(); iterator.hasNext(); ) {
				Integer index=iterator.nextIndex();
				
			    while (iterator.hasNext()) {
			    	long next=iterator.next();
			    	if(next%previous==0) {
			    		iterator.remove();
			    	}
			    }
			    iterator=primeList.listIterator(index);
			    iterator.next();
			}
		}
		return primeList;
	}
}
