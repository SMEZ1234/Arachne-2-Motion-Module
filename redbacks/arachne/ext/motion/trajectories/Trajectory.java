package redbacks.arachne.ext.motion.trajectories;

import redbacks.arachne.ext.motion.MotionSettings;

public class Trajectory
{
	public double[][] waypoints;
	private int progressIndex = 0;
	public double totalDistance;
	
	public Trajectory(double[]... waypoints) {
		this.waypoints = waypoints;
		totalDistance = waypoints[waypoints.length-1][0] * MotionSettings.encoderTicksPerMetre;
	}
	
	public void reset() {
		progressIndex = 0;
	}
	
	public double getAngleFromDistance(double distance) {
		while(progressIndex < waypoints.length - 1 && Math.abs(distance) > Math.abs(waypoints[progressIndex][0] * MotionSettings.encoderTicksPerMetre)) {
			progressIndex++;
		}
		
		double[] angles = new double[Math.min(MotionSettings.trajectoryAngleForesight, waypoints.length - progressIndex)];
		
		for(int i = 0; i < Math.min(MotionSettings.trajectoryAngleForesight, waypoints.length - progressIndex); i++) angles[i] = waypoints[i + progressIndex][1];
		
		return avg(angles);
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