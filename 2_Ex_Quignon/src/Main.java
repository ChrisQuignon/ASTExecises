import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;


public class Main {

	public static void main(String[] args) {    
		long integerCountTime = 0;
		long longCountTime = 0;
		
		List<Integer> integerPrimeList = new LinkedList<Integer>();
		List<Long> longPrimeList = new LinkedList<Long>();
		
		System.out.println("Computation startet. This will take a very long time and more than 16 Exabyte of free space.");
		System.out.println("Feel free to cancel and look at the code.");
		
		integerPrimeList = primeGenerator(Integer.MAX_VALUE);		
		longPrimeList = primeSieve(Long.MAX_VALUE);
		
		longCountTime = countTime(Long.MIN_VALUE, Long.MAX_VALUE);
		integerCountTime = countTime((long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE);
		
		
		System.out.println("Prime Numbers up to " + Integer.MAX_VALUE + ": ");
		for (int prime : integerPrimeList){
			System.out.print(prime + " ");		
		}

		System.out.println("Prime Numbers up to " + Long.MAX_VALUE + ": ");
		for (long prime : longPrimeList){
			System.out.print(prime + " ");		
		}
		
		System.out.println("Time to count from "
				+ Integer.MIN_VALUE + " to " + Integer.MAX_VALUE
				+ " in milliseconds: " + integerCountTime);
				
		System.out.println("Time to count from "
				+ Long.MIN_VALUE + " to " + Long.MAX_VALUE
				+ " in milliseconds: " + longCountTime);		
	}
	
	private static long countTime(long minValue, long maxValue) {
		long startTime;
		long swap;
		
		if (minValue > maxValue){
			swap = maxValue;
			maxValue = minValue;
			minValue = swap;
		}
		
		startTime=System.currentTimeMillis();
		for (long i = minValue; i < maxValue; i = i+1){
			//just counting
		}
		return System.currentTimeMillis() - startTime;
	}

	//needs more than 16 Exabyte space
	private static List<Long> primeSieve(long n) {
		List<Long> primeList = new LinkedList<Long>();
		Iterator<Long> iter;
		long lastPrime = 2;
		int index = 2;
		
		for(long i = 1; i < n; i = i + 1){
			primeList.add(i);
		}
		
		//Sieve of Eratosthenes
		iter = primeList.listIterator(1);
		
		while(lastPrime < (n / 2)){
			lastPrime = iter.next();
			while (iter.hasNext()) {
				if((iter.next() % lastPrime) == 0){
					iter.remove();
				  }
			}
			index = index + 1;
			iter = primeList.listIterator(index);
		}
		return primeList;
	}
	
	//Takes a very long time.
	private static List<Integer> primeGenerator(int n){
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		boolean remove;
		
		for (int i = 3; i < n; i++){
			primes.add(i);
			remove = false;
			
			for(Iterator<Integer> iter = primes.listIterator(); iter.hasNext() && !remove; ){
				int prime =  iter.next();
				if (((i % prime) == 0) && (i != prime)) {
					remove = true;
				}
			}
			if(remove){
				primes.remove(primes.size()-1);
			}
		}
		return primes;
	}
}