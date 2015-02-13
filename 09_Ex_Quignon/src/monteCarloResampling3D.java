import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class monteCarloResampling3D {

	public static void main(String[] args) {
		int[] ks = { 100, 1000, 10000, 100000 };
		List<MonteCarloSampleSet3D<MonteCarloSample3D>> mcpsUniformList = new LinkedList<MonteCarloSampleSet3D<MonteCarloSample3D>>();
		List<MonteCarloSampleSet3D<MonteCarloSample3D>> mcpsGaussianList = new LinkedList<MonteCarloSampleSet3D<MonteCarloSample3D>>();

		// create samplings
		for (int i : ks) {
			MonteCarloSampleSet3D<MonteCarloSample3D> newMcps = uniformDistribution(i);
			mcpsUniformList.add(newMcps);
		}

		for (int i : ks) {
			MonteCarloSampleSet3D<MonteCarloSample3D> newMcps = gaussianDistribution(i);
			mcpsGaussianList.add(newMcps);
		}

		// write outcome to files
		// no visualisation for 3D
	}

	// Method One for Monte Carlo Samplings
	public static MonteCarloSampleSet3D<MonteCarloSample3D> uniformDistribution(
			int k) {
		MonteCarloSampleSet3D<MonteCarloSample3D> samples = new MonteCarloSampleSet3D<MonteCarloSample3D>();
		Random randomGenerator = new Random();
		for (int i = 0; i < k; i++) {
			double x = (randomGenerator.nextDouble() * 400 - 200) % 200;
			double y = (randomGenerator.nextDouble() * 400 - 200) % 200;
			double z = (randomGenerator.nextDouble() * 40 - 20) % 20;
			double alpha = (randomGenerator.nextDouble() * 360) % 360;
			double beta = (randomGenerator.nextDouble() * 360) % 360;
			double gamma = (randomGenerator.nextDouble() * 360) % 360;
			Pose3D mcp = new Pose3D(x, y, z, alpha, beta, gamma);
			MonteCarloSample3D mcs = new MonteCarloSample3D(mcp, 1.0 / k);
			samples.add(mcs);
		}
		return samples;
	}

	// Method Two for Monte Carlo Samplings
	public static MonteCarloSampleSet3D<MonteCarloSample3D> gaussianDistribution(
			int k) {
		MonteCarloSampleSet3D<MonteCarloSample3D> samples = new MonteCarloSampleSet3D<MonteCarloSample3D>();
		Random randomGeneratorX = new Random();
		Random randomGeneratorY = new Random();
		Random randomGeneratorZ = new Random();
		Random randomGenerator = new Random();
		for (int i = 0; i < k; i++) {
			double x = (randomGeneratorX.nextGaussian() * 200) % 200;
			double y = (randomGeneratorY.nextGaussian() * 200) % 200;
			double z = (randomGeneratorZ.nextGaussian() * 20) % 20;
			double alpha = randomGenerator.nextDouble() * 360;
			double beta = randomGenerator.nextDouble() * 360;
			double gamma = randomGenerator.nextDouble() * 360;
			Pose3D mcp = new Pose3D(x, y, z, alpha, beta, gamma);
			MonteCarloSample3D mcs = new MonteCarloSample3D(mcp, 1.0 / k);
			samples.add(mcs);
		}
		return samples;
	}
}