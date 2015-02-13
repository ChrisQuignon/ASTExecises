import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MonteCarloSampleSet3D<T> implements Set<MonteCarloSample3D>{

	Set<MonteCarloSample3D> samples = new HashSet<MonteCarloSample3D>();

	public void resample(){
		//TODO: Implement
		//was not presented in class
	}
	
	//List functions all call back to the samples
	@Override
	public boolean add(MonteCarloSample3D e) {
		return samples.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends MonteCarloSample3D> c) {
		return samples.addAll(c);
	}

	@Override
	public void clear() {
		samples.clear();
	}

	@Override
	public boolean contains(Object o) {
		return samples.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return samples.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return samples.isEmpty();
	}

	@Override
	public Iterator<MonteCarloSample3D> iterator() {
		return samples.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return samples.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return samples.remove(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return samples.retainAll(c);
	}

	@Override
	public int size() {
		return samples.size();
	}

	@Override
	public Object[] toArray() {
		return samples.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
