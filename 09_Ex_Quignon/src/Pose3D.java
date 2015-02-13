public class Pose3D {
	double x;
	double y;
	double z;
	double alpha;
	double beta;
	double gamma;

	public Pose3D(double x, double y, double z, double alpha, double beta,
			double gamma) {

		// Value checking
		if (x < -200 || x > 200) {
			this.setX(0);
			System.out.println("x invalid, set from " + Double.toString(x)
					+ " to 0.");
		} else {
			this.setX(x);
		}

		if (y < -200 || y > 200) {
			this.setY(0);
			System.out.println("y invalid, set from " + Double.toString(y)
					+ " to 0.");
		} else {
			this.setY(y);
		}

		if (z < -20 || z > 20) {
			this.setZ(0);
			System.out.println("z invalid, set from " + Double.toString(z)
					+ " to 0.");
		} else {
			this.setZ(z);
		}

		if (alpha < 0 || alpha > 360) {
			this.setAlpha(0);
			System.out.println("alpha invalid, set from "
					+ Double.toString(alpha) + " to 0.");
		} else {
			this.setAlpha(alpha);
		}

		if (beta < 0 || beta > 360) {
			this.setBeta(0);
			System.out.println("beta invalid, set from "
					+ Double.toString(beta) + " to 0.");
		} else {
			this.setBeta(beta);
		}

		if (gamma < 0 || gamma > 360) {
			this.setGamma(0);
			System.out.println("gamma invalid, set from "
					+ Double.toString(gamma) + " to 0.");
		} else {
			this.setGamma(gamma);
		}
	}

	// Computes the euclidean distance to a given pose p
	public double distance(Pose3D p) {
		double xSquare = Math.pow((this.getX() - p.getX()), 2);
		double ySquare = Math.pow((this.getY() - p.getY()), 2);
		double zSquare = Math.pow((this.getZ() - p.getZ()), 2);
		return Math.sqrt(xSquare + ySquare + zSquare);
	}

	// getter and setter functions
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}
}
