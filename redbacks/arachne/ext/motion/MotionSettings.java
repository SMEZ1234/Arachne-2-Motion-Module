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
	/** The change in encoder tick value when the robot travels precisely 1 metre. Sorry, imperial system users - you'll have to do the conversion. */
	public static int encoderTicksPerMetre; // FIXME Hide variable and create getters and setters for imperial and metric systems.
	
	/**
	 * The number of yet-to-be-reached trajectory waypoints that are taken and averaged to determine the desired angle for the robot.
	 * If the robot responds too slowly to curves, try raising this number. Be warned that it will smooth slight "S" bends into a straighter line.
	 */
	public static int trajectoryAngleForesight = 1;

	/** A PID setting used for the encoder measuring the distance the robot is traveled. This shouldn't need changing. */
	public static double distanceEncoderMin = 0;

	/** A PID setting used for the encoder measuring the distance the robot is traveled. This shouldn't need changing. */
	public static double distanceEncoderMax = 0;

	/** A PID setting used for the encoder measuring the distance the robot is traveled. This shouldn't need changing. */
	public static boolean distanceEncoderIsContinuous = false;

	/** The maximum negative speed a drive motor can be set to while attempting to follow a trajectory. */
	public static double trajectoryMaxNegSpeed = -0.8D;
	
	/** The maximum positive speed a drive motor can be set to while attempting to follow a trajectory. */
	public static double trajectoryMaxPosSpeed = 0.8D;
	
	/** Linear P constant for path following. Should be set by teams using Arachne's path following classes. */
	public static double drivePIDLinearKP = 0;

	/** Linear I constant for path following. Should be set by teams using Arachne's path following classes. */
	public static double drivePIDLinearKI = 0;

	/** Linear D constant for path following. Should be set by teams using Arachne's path following classes. */
	public static double drivePIDLinearKD = 0;

	/** Rotational P constant for path following. Should be set by teams using Arachne's path following classes. */
	public static double drivePIDRotKP = 0;

	/** Rotational I constant for path following. Should be set by teams using Arachne's path following classes. */
	public static double drivePIDRotKI = 0;

	/** Rotational D constant for path following. Should be set by teams using Arachne's path following classes. */
	public static double drivePIDRotKD = 0;
}
