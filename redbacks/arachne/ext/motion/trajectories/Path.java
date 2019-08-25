package redbacks.arachne.ext.motion.trajectories;

import redbacks.arachne.ext.motion.MotionSettings;

public class Path
{
	public double[][] waypoints;
	private int progressIndex = 0;
	public double totalDistance;
	
	public MotionSettings settings;
	
	public Path(MotionSettings settings, double[]... waypoints) {
		this.settings = settings;
		this.waypoints = waypoints;
		totalDistance = waypoints[waypoints.length-1][0] * settings.getEncoderTicksPerMetre();
	}
	
	public void reset() {
		progressIndex = 0;
	}
	
	public double getAngleFromDistance(double distance) {
		while(progressIndex < waypoints.length - 1 && Math.abs(distance) > Math.abs(waypoints[progressIndex][0] * settings.getEncoderTicksPerMetre())) progressIndex++;
		
		double[] angles = new double[Math.min(settings.trajectoryAngleForesight, waypoints.length - progressIndex)];
		for(int i = 0; i < angles.length; i++) angles[i] = waypoints[i + progressIndex][1];
		
		return avg(angles);
	}
	
	@Deprecated
	public double getCurvatureFromDistance(double distance) {
		while(progressIndex < waypoints.length - 1 && Math.abs(distance) > Math.abs(waypoints[progressIndex][0] * settings.getEncoderTicksPerMetre())) progressIndex++;
		
		double[] curvatures = new double[Math.min(settings.trajectoryAngleForesight, waypoints.length - progressIndex)];
		for(int i = 0; i < curvatures.length; i++) curvatures[i] = waypoints[i + progressIndex][2];
		
		return avg(curvatures);
	}
	
	public boolean isPathComplete() {
		return progressIndex >= waypoints.length - 1;
	}
	
	public double avg(double... ds) {
		double sum = 0;
		for(double d : ds) sum += d;
		return sum / ds.length;
	}
}
