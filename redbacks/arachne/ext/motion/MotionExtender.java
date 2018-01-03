package redbacks.arachne.ext.motion;

import redbacks.arachne.core.api.RobotAPI.Order;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.PIDController;
import redbacks.arachne.core.api.RobotExtender;

/**
 * An extension on the {@link RobotExtender} class that handles the list of active {@link PIDController PIDControllers}.
 * It disables and clears the list when the robot is disabled.
 *
 * @author Sean Zammit
 */
public class MotionExtender extends RobotExtender
{
	private static MotionExtender instance;
	
	/** A list of all active {@link PIDController PIDControllers}. */
	public ArrayList<PIDController> activePIDs = new ArrayList<PIDController>();
	
	private MotionExtender(Order order) {
		super(order);
	}
	
	/** Ensures that one and only one instance of this class exists. */
	public static MotionExtender getInstance() {
		if(instance == null) instance = new MotionExtender(Order.POST);
		return instance;
	}
	
	public void initialiseDisabled() {
		for(PIDController pid : activePIDs) pid.disable();
		activePIDs.clear();
	}
}
