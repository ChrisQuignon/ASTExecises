import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
	static final int LARGEST_INTEGER =  Integer.MAX_VALUE; 
	static final long LARGEST_LONG = Long.MAX_VALUE;
	
	public static void main(String[] args) {
		long tempTime = 0;
		long integerCountTime = 0;
		long longCountTime = 0;
		
		List<Integer> integerPrimeList = new LinkedList<Integer>();
		List<Long> longPrimeList = new LinkedList<Long>();
				
		integerPrimeList = allprimes(Integer.MAX_VALUE);		
		longPrimeList = allprimes(Long.MAX_VALUE);
		
		tempTime=System.currentTimeMillis();
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i = i+1){
			//just counting
		}
		integerCountTime = System.currentTimeMillis() - tempTime;
		
		tempTime=System.currentTimeMillis();
		for (long i = Long.MIN_VALUE; i < Long.MAX_VALUE; i = i+1){
			//just counting
		}
		longCountTime = System.currentTimeMillis() - tempTime;
		
		System.out.println("Prime Numbers up to " + Integer.MAX_VALUE + ": ");
		for (int prime : integerPrimeList){
			System.out.print(prime + " ");		
		}

		System.out.println("Prime Numbers up to " + Long.MAX_VALUE + ": ");
		for (long prime : longPrimeList){
			System.out.print(prime + " ");		
		}
		
		System.out.println("Time to count from"
				+ Integer.MIN_VALUE + " to " + Integer.MAX_VALUE
				+ "n milliseconds: " + integerCountTime);
				
		System.out.println("Time to count from"
				+ Long.MIN_VALUE + " to " + Long.MAX_VALUE
				+ "n milliseconds: " + longCountTime);		
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