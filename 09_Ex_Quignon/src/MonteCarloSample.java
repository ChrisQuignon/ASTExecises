public class MonteCarloSample {
	private Pose pose;
	private double weight;

	public MonteCarloSample(Pose pose, double weight) {
		this.setPose(pose);
		this.setWeight(weight);
	}

	// the probability of a pose is approximated by the mean of the probability
	// of each vector
	public void setGaussianWeight(Pose p, double sigmaX, double sigmaY,
			double sigmaTheta) {
		double weightX = Math.exp(-Math.pow((p.getX() - pose.getX()), 2)
				/ (2 * Math.pow(sigmaX, 2.0)))
				/ (Math.sqrt(2.0 * Math.PI) * sigmaX);
		double weightY = Math.exp(-Math.pow((p.getY() - pose.getY()), 2)
				/ (2 * Math.pow(sigmaY, 2.0)))
				/ (Math.sqrt(2.0 * Math.PI) * sigmaY);
		double weightTheta = Math.exp(-Math.pow(
				(p.getTheta() - pose.getTheta()), 2)
				/ (2 * Math.pow(sigmaTheta, 2.0)))
				/ (Math.sqrt(2.0 * Math.PI) * sigmaTheta);
		this.weight = (weightX + weightY + weightTheta) / 3;
	}

	// getter and setter Functions
	public Pose getPose() {
		return pose;
	}

	public void setPose(Pose pose) {
		this.pose = pose;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
