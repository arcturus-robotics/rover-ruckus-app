package org.firstinspires.ftc.teamcode.mecanum;

/**
 * TODO: Use meters rather than milliseconds
 *       Our code could be much more efficient if we measured with meters
 */

public class Mecanum {
    public static final double DRIVE_POWER = 0.5; // Global drive power multiplier
    public static final double DEPLOY_POWER      = 0.5; // The power at which the marker will be deployed
    public static final long CIRCLE              = 6000; // 360 degrees (in milliseconds)
    public static final long FIELD               = 6000; // The length of the field (in milliseconds)
    public static final long LANDER              = 2500; // The distance from the lander to the corner of the field (in millseconds)
    public static final long DEPLOY_DURATION     = 600; // The amount of time the marker will be deployed for
    public static final long AUTONOMOUS_DURATION = 30000; // The duration of autonomous (in milliseconds)
    public static final long MOVEMENT_PADDING    = 30; // A divider between each movement (in milliseconds)
    public static final long INITIAL_DELAY       = 0; // The initial delay so that we don't get in the way of our ally's autonomous program
    // public static final double FEET_PER_SECOND = 0; // The distance the robot moves in a second, in feet
    // public static final double PI                = 0;
    // public static final double FIELD_LENGTH      = 0;

}
