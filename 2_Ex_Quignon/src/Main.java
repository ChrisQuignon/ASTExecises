import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	static final int LARGEST_INTEGER =  Integer.MAX_VALUE; 
	static final long LARGEST_LONG = Long.MAX_VALUE;
	
	public static void main(String[] args) {
		List<Integer> integerPrimeList = new LinkedList<Integer>();
		List<Long> longPrimeList = new LinkedList<Long>();
		
		long calculationTimeLargestInteger = 0;
		long calculationTimeLargestLong = 0;
		long startTime = 0;
		long endTime = 0;
		
		startTime = System.currentTimeMillis();
		integerPrimeList = allprimes(LARGEST_INTEGER);
		endTime = System.currentTimeMillis();
		calculationTimeLargestInteger = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		longPrimeList = allprimes(LARGEST_LONG);
		endTime = System.currentTimeMillis();
		calculationTimeLargestLong = endTime - startTime;
		
		System.out.println("Prime Numbers up to " + LARGEST_INTEGER + ": ");
		for (int prime : integerPrimeList){
			System.out.print(prime + ", ");		
		}
		System.out.println("");
		System.out.println("Time to compute in milliseconds: " + calculationTimeLargestInteger);
				
		System.out.println("Prime Numbers up to " + LARGEST_LONG + ": ");
		for (long prime : longPrimeList){
			System.out.print(prime + ", ");		
		}
		
		System.out.println("");
		System.out.println("Time to compute in milliseconds: " + calculationTimeLargestLong);		
	}
	
	private static List<Long> allprimes(Long n) {
		List<Long> primeList = new LinkedList<Long>();
		ListIterator<Long> iterator = primeList.listIterator();
		long next;
		int index;
		
		for(long i = 1 ; i < 10; i = i+1){primeList.add(i);}
		
		if(iterator.hasNext()){
			iterator.next();
			for (Long previous = iterator.next(); iterator.hasNext(); ) {
				index = iterator.nextIndex();
			    while (iterator.hasNext()) {
			    	next = iterator.next();
			    	if(next % previous == 0) {
			    		iterator.remove();
			    	}
			    }
			    iterator = primeList.listIterator(index);
			    iterator.next();
			}
		}
		return primeList;
	}

	private static List<Integer> allprimes(Integer n) {
		List<Integer> primeList = new LinkedList<Integer>();
		long next;
		
		for(int i = 1; i <= n; i = i + 1){primeList.add(i);}
		
		ListIterator<Integer> iterator = primeList.listIterator();
		if(iterator.hasNext()){
			iterator.next();
			for (Integer previous = iterator.next(); iterator.hasNext(); ) {
				Integer index = iterator.nextIndex();		
			    while (iterator.hasNext()) {
			    	next = iterator.next();
			    	if(next % previous == 0) {
			    		iterator.remove();
			    	}
			    }
			    iterator = primeList.listIterator(index);
			    iterator.next();
			}
		}
		return primeList;
	}
}