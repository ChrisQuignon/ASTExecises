import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
	public static void main(String[] args) {
		int largestInteger =  Integer.MAX_VALUE; 
		long largestLong =Long.MAX_VALUE;
		
		//subtask 1
		List<Integer> integerPrimeList = new LinkedList<Integer>();
		long startTimeInteger = System.currentTimeMillis();
		integerPrimeList = allprimes(largestInteger);
		long endTimeInteger = System.currentTimeMillis();
		
		long startTimeLong = System.currentTimeMillis();
		List<Long> longPrimeList=new LinkedList<Long>();
		//longPrimeList = allprimes(largestLong);
		long endTimeLong = System.currentTimeMillis();
		
		
		
		//subtask 2
		
		
		
		//subtask 3
		System.out.println("Prime Number up to " + largestInteger + ": ");
		for (int prime : integerPrimeList){
			System.out.print(prime + ", ");		
		}
		System.out.println("");
		System.out.println("Time to compute: " + String.valueOf(endTimeInteger - startTimeInteger));
		
		
		System.out.println("Prime Number up to " + largestLong + ": ");
		for (long prime : longPrimeList){
			System.out.print(prime + ", ");		
		}
		System.out.println("");
		System.out.println("Time to compute: " + String.valueOf(endTimeLong -startTimeLong));		
	}

	private static List<Long> allprimes(Long n) {
		List<Long> primeList = new LinkedList<Long>();
		
		//fill List
		for(long i =1; i<n; i=i+1){
			primeList.add(i);
			}
		
		ListIterator<Long> iter = primeList.listIterator();
		if(iter.hasNext()){
			iter.next();
			for (Long previous = iter.next(); iter.hasNext(); ) {
				int index=iter.nextIndex();
				
			    while (iter.hasNext()) {
			    	long next=iter.next();
			    	if(next%previous==0) {
			    		iter.remove();
			    	}
			    }
			    iter=primeList.listIterator(index);
			    iter.next();
			}
		}
		return primeList;
	}

	private static List<Integer> allprimes(Integer n) {
		List<Integer> primeList = new LinkedList<Integer>();
		
		//fill List
		for(int i =1; i<n; i=i+1){
			primeList.add(i);
			}
		
		ListIterator<Integer> iter = primeList.listIterator();
		if(iter.hasNext()){
			iter.next();
			for (Integer previous = iter.next(); iter.hasNext(); ) {
				Integer index=iter.nextIndex();
				
			    while (iter.hasNext()) {
			    	long next=iter.next();
			    	if(next%previous==0) {
			    		iter.remove();
			    	}
			    }
			    iter=primeList.listIterator(index);
			    iter.next();
			}
		}
		return primeList;
	}
}
