public class Pose {
	private double x;
	private double y;
	private double theta;

	public Pose(double x, double y, double theta) {
		this.setX(x);
		this.setY(y);
		this.setTheta(theta);

		// Value checking
		if (x < -200 || x > 200) {
			this.setX(0);
			System.out.println("x invalid, set from " + Double.toString(x) + " to 0.");
		}

		if (y < -200 || y > 200) {
			this.setY(0);
			System.out.println("y invalid, set from " + Double.toString(y) + " to 0.");
		}

		if (theta < 0 || theta > 360) {
			this.setTheta(0);
			System.out.println("theta invalid, set from " + Double.toString(theta) + " to 0.");
		}
	}

	// Computes the euclidean distance to a given pose p
	public double distance(Pose p) {
		double xSquare = Math.pow((this.getX() - p.getX()), 2);
		double ySquare = Math.pow((this.getY() - p.getY()), 2);
		return Math.sqrt(xSquare + ySquare);
	}

	// getter and setter Functions
	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

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

}
