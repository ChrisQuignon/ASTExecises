public class Tuple<F, S> { 
	  public final F first; 
	  public final S second; 
	  public Tuple(F first, S second) { 
	    this.first = first; 
	    this.second = second; 
	  }
	  
	public Object first() {
		return this.first;
	}
	
	public Object second() {
		return this.second;
	}
} 