package redbacks.arachne.ext.motion;

/**
 * Similar to the typical RobotMap class, this holds a list of static variables to configure trajectory settings.
 * Most variables here have default values, but you'll need to set the number of encoder ticks for your unit of measurement,
 * along with the PID variables for path following.
 *
 * @author Sean Zammit
 */
public class MotionSettings
{
	private double encoderTicksPerMetre;
	private static final double METRES_PER_FOOT = 0.3048;
	
	public static final MotionSettings standardSettings = new MotionSettings();
	
	/**
	 * Sets a global constant for the change in encoder tick value when the robot travels precisely 1 metre.
	 * 
	 * @param ticks The number of ticks.
	 */
	public void setEncoderTicksPerMetre(int ticks) {
		encoderTicksPerMetre = ticks;
	}
	
	/**
	 * Sets a global constant for the change in encoder tick value when the robot travels precisely 1 foot.
	 * The value is stored as a number of encoder ticks per metre.
	 * 
	 * @param ticks The number of ticks.
	 */
	public void setEncoderTicksPerFoot(int ticks) {
		encoderTicksPerMetre = ticks / METRES_PER_FOOT;
	}
	
	/**
	 * Gets the value of a constant set by {@link #setEncoderTicksPerMetre(int)} or {@link #setEncoderTicksPerFoot(int)}.
	 * 
	 * @return The change in encoder tick value when the robot travels precisely 1 metre.
	 */
	public int getEncoderTicksPerMetre() {
		return (int) encoderTicksPerMetre;
	}
	
	/**
	 * Gets the value of a constant set by {@link #setEncoderTicksPerMetre(int)} or {@link #setEncoderTicksPerFoot(int)}.
	 * 
	 * @return The change in encoder tick value when the robot travels precisely 1 foot.
	 */
	public int getEncoderTicksPerFoot() {
		return (int) (encoderTicksPerMetre * METRES_PER_FOOT);
	}
	
	/**
	 * The number of yet-to-be-reached trajectory waypoints that are taken and averaged to determine the desired angle for the robot.
	 * If the robot responds too slowly to curves, try raising this number. Be warned that it will smooth slight "S" bends into a straighter line.
	 */
	public int trajectoryAngleForesight = 1;

	/** A PID setting used for the encoder measuring the distance the robot is traveled. This shouldn't need changing. */
	public double distanceEncoderMin = 0;

	/** A PID setting used for the encoder measuring the distance the robot is traveled. This shouldn't need changing. */
	public double distanceEncoderMax = 0;

	/** A PID setting used for the encoder measuring the distance the robot is traveled. This shouldn't need changing. */
	public boolean distanceEncoderIsContinuous = false;

	/** The maximum negative speed a drive motor can be set to while attempting to follow a trajectory. */
	public double trajectoryMaxNegSpeed = -0.8D;
	
	/** The maximum positive speed a drive motor can be set to while attempting to follow a trajectory. */
	public double trajectoryMaxPosSpeed = 0.8D;
	
	/** Linear P constant for path following. Should be set by teams using Arachne's path following classes. */
	public double drivePIDLinearKP = 0;

	/** Linear I constant for path following. Should be set by teams using Arachne's path following classes. */
	public double drivePIDLinearKI = 0;

	/** Linear D constant for path following. Should be set by teams using Arachne's path following classes. */
	public double drivePIDLinearKD = 0;

	/** Rotational P constant for path following. Should be set by teams using Arachne's path following classes. */
	public double drivePIDRotKP = 0;

	/** Rotational I constant for path following. Should be set by teams using Arachne's path following classes. */
	public double drivePIDRotKI = 0;

	/** Rotational D constant for path following. Should be set by teams using Arachne's path following classes. */
	public double drivePIDRotKD = 0;
}
