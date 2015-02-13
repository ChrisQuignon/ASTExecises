
public class MonteCarloSample3D {
		private Pose3D pose;
		private double weight; 
		
		public MonteCarloSample3D(Pose3D pose, double weight){
			this.setPose(pose);
			this.setWeight(weight);
		}

		//getter and setter functions
		public Pose3D getPose() {
			return pose;
		}

		public void setPose(Pose3D pose) {
			this.pose = pose;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}
}
