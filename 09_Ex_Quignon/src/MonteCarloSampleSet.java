import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MonteCarloSampleSet<T> implements Set<MonteCarloSample> {

	Set<MonteCarloSample> samples = new HashSet<MonteCarloSample>();

	public void resample() {
		// TODO: Implement
		// was not presented in class
	}

	public String getVisualisation() {
		String visualString = new String();
		char[][] visual = new char[400][400];
		for (int i = 0; i < 400; i++) {
			for (int j = 0; j < 400; j++) {
				visual[i][j] = '.';
			}
		}

		for (MonteCarloSample mcs : this.samples) {
			char pose = 'x';
			// Approximation of the pose with chars
			/*
			 * switch((int)(mcs.pose.theta+22)/45){ case 0: pose = '-'; break;
			 * case 1: pose = '-'; break; case 2: pose = '/'; break; case 3:
			 * pose = '|'; break; case 4: pose = '\\'; break; case 5: pose =
			 * '-'; break; case 6: pose = '/'; break; case 7: pose = '|'; break;
			 * case 8: pose = '\\'; break; case 9: pose = '-'; break; default:
			 * pose= '.'; }
			 */
			visual[(int) mcs.getPose().getX() + 200][(int) mcs.getPose().getY() + 200] = pose;
		}

		// convert char [][] to String with linebreaks
		for (int i = 399; i >= 0; i--) {
			visualString = visualString + (new String(visual[i]))
					+ System.getProperty("line.separator");
		}
		return visualString;
	}

	public Set<MonteCarloSample> getSamples() {
		return samples;
	}

	// List functions all call back to the samples
	@Override
	public boolean add(MonteCarloSample e) {
		return samples.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends MonteCarloSample> c) {
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
	public Iterator<MonteCarloSample> iterator() {
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
		return samples.toArray(a);
	}
}
