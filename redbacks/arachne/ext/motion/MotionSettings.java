package redbacks.arachne.ext.motion;

/**
 * Similar to the typical RobotMap class, this holds a list of static variables to configure trajectory settings.
 * The only one without a default value is {@link #encoderTicksPerMetre}. You will have to set this yourself based on your drivetrain.
 *
 * @author Sean Zammit
 */
public class MotionSettings
{
	/** The change in encoder tick value when the robot travels precisely 1 metre. Sorry, imperial system users - you'll have to do the conversion. */
	public static int encoderTicksPerMetre;
	
	/**
	 * The number of yet-to-be-reached trajectory waypoints that are taken and averaged to determine the desired angle for the robot.
	 * If the robot responds too slowly to curves, try raising this number. Be warned that it will smooth slight "S" bends into a straighter line.
	 */
	public static int trajectoryAngleForesight = 1;

	/** A PID setting used for the encoder measuring the distance the robot is travelled. This shouldn't need changing. */
	public static double distanceEncoderMin = 0;

	/** A PID setting used for the encoder measuring the distance the robot is travelled. This shouldn't need changing. */
	public static double distanceEncoderMax = 0;

	/** A PID setting used for the encoder measuring the distance the robot is travelled. This shouldn't need changing. */
	public static boolean distanceEncoderIsContinuous = false;

	/** The maximum negative speed a drive motor can be set to while attempting to follow a trajectory. */
	public static double trajectoryMaxNegSpeed = -0.8D;
	
	/** The maximum positive speed a drive motor can be set to while attempting to follow a trajectory. */
	public static double trajectoryMaxPosSpeed = 0.8D;	
}
