import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class monteCarloResampling {

	public static void main(String[] args) {
		int[] ks = { 100, 1000, 10000, 100000 };
		List<MonteCarloSampleSet<MonteCarloSample>> mcpsUniformList = new LinkedList<MonteCarloSampleSet<MonteCarloSample>>();
		List<MonteCarloSampleSet<MonteCarloSample>> mcpsGaussianList = new LinkedList<MonteCarloSampleSet<MonteCarloSample>>();
		List<String> visualisationsUniform = new LinkedList<String>();
		List<String> visualisationsGaussian = new LinkedList<String>();

		// create samples
		for (int i : ks) {
			MonteCarloSampleSet<MonteCarloSample> newMcps = uniformDistribution(i);
			visualisationsUniform.add(newMcps.getVisualisation());
			mcpsUniformList.add(newMcps);
		}

		for (int i : ks) {
			MonteCarloSampleSet<MonteCarloSample> newMcps = gaussianDistribution(i);
			visualisationsGaussian.add(newMcps.getVisualisation());
			mcpsGaussianList.add(newMcps);
		}

		// write outcome to files
		for (MonteCarloSampleSet<MonteCarloSample> sample : mcpsUniformList) {
			try {
				String filename = "Normal_" + sample.size() + ".txt";
				PrintWriter printer = new PrintWriter(filename);
				printer.print(sample.getVisualisation());
				printer.close();
				System.out.println(filename + " written.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Could not create File. Sorry.");
			}
		}

		for (MonteCarloSampleSet<MonteCarloSample> sample : mcpsGaussianList) {
			try {
				String filename = "Gaussian_" + sample.size() + ".txt";
				PrintWriter printer = new PrintWriter(filename);
				printer.print(sample.getVisualisation());
				printer.close();
				System.out.println(filename + " written.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Could not create File. Sorry.");
			}
		}

	}

	// Method for creating uniform distributed Monte Carlo Samples
	public static MonteCarloSampleSet<MonteCarloSample> uniformDistribution(
			int k) {
		MonteCarloSampleSet<MonteCarloSample> samples = new MonteCarloSampleSet<MonteCarloSample>();
		Random randomGenerator = new Random();
		// one generator for every variable
		for (int i = 0; i < k; i++) {
			int x = randomGenerator.nextInt(400) - 200;
			int y = randomGenerator.nextInt(400) - 200;

			// x + y has to be between -200 and 200
			while ((x + y) < -200 || (x + y) > 200) {
				x = randomGenerator.nextInt(400) - 200;
				y = randomGenerator.nextInt(400) - 200;
			}

			int theta = randomGenerator.nextInt(360);
			Pose pose = new Pose(x, y, theta);
			MonteCarloSample mcs = new MonteCarloSample(pose, 1.0 / k);
			// System.out.println(Double.toString(pose.x) + " " +
			// Double.toString(pose.y) + " " + Double.toString(pose.theta) );
			samples.add(mcs);
			//
			samples.resample();
		}
		return samples;
	}

	// Method for creating gaussian distributed Monte Carlo Samples
	public static MonteCarloSampleSet<MonteCarloSample> gaussianDistribution(
			int k) {
		MonteCarloSampleSet<MonteCarloSample> samples = new MonteCarloSampleSet<MonteCarloSample>();

		// every Number need its own random number generator
		Random randomGeneratorX = new Random();
		Random randomGeneratorY = new Random();
		Random randomGeneratorZ = new Random();

		// generate 5 Poses for the gaussians
		double[] muX = { -140.0, -60.0, 20.0, 80.0, 100.0 };
		double[] muY = { 20.0, 120.0, 120.0, 0.0, -100.0 };
		double[] muTheta = { 125.0, 270.0, 0.0, 225.0, 125.0 };

		Pose[] gaussianPoses = new Pose[5];
		for (int i = 0; i < gaussianPoses.length; i++) {
			gaussianPoses[i] = new Pose(muX[i], muY[i], muTheta[i]);
		}

		double sigmaX = 20.0;
		double sigmaY = 20.0;
		double sigmaTheta = 10.0;

		// Create K samples and distribute them equally over the muX and muY and muPhi
		for (int i = 0; i < k; i++) {
			double x = (randomGeneratorX.nextGaussian() * sigmaX + muX[i
					% muX.length]) % 200;
			double y = (randomGeneratorY.nextGaussian() * sigmaY + muY[i
					% muY.length]) % 200;
			double theta = (randomGeneratorZ.nextGaussian() * sigmaTheta + muTheta[i
					% muX.length]) % 360;
			// Make sure theta is positive
			theta = Math.abs(theta);
			Pose mcp = new Pose(x, y, theta);
			MonteCarloSample mcs = new MonteCarloSample(mcp, 1.0 / k);
			samples.add(mcs);
		}
		return samples;
	}
}