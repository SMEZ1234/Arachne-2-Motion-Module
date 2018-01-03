package redbacks.arachne.ext.motion.pid;

import redbacks.arachne.core.ArachneRobot;
import redbacks.arachne.lib.actions.Action;
import redbacks.arachne.lib.checks.ChTrue;

/**
 * A basic action used to manually set drivetrain motors to be controlled individually.
 * This is only necessary before using {@link AcMultiPID} to set the drivetrain speed values.
 *
 * @author Sean Zammit
 */
public class AcSetIndivDrive extends Action
{
	public AcSetIndivDrive() {
		super(new ChTrue());
	}
	
	public void onStart() {
		ArachneRobot.isIndivDriveControl = true;
	}
}
