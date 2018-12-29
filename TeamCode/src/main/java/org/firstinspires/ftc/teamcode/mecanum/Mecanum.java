package org.firstinspires.ftc.teamcode.mecanum;

/**
 * TODO: Use meters rather than milliseconds
 *       Our code could be much more efficient if we measured with meters
 */

public class Mecanum {
    public static final long AUTONOMOUS_DURATION  = 30000; // The duration of autonomous, in milliseconds
    public static final long MOVEMENT_PADDING     = 30; // A divider between each movement, in milliseconds
    public static final long INITIAL_DELAY        = 0; // The initial delay so that we don't get in the way of our ally's autonomous program
    public static final double DEPLOY_POWER       = 0.5; // The power at which the marker will be deployed
    public static final double DEPLOY_ANGLE       = 120; // The amount of time the marker will be deployed for
    public static final double INCHES_PER_SECOND  = 36.0416666666666667; // The distance the robot moves in a second, in inches
    public static final double DEGREES_PER_SECOND = 85; // (approximate) The angle the robot turns in one second
    public static final double CIRCLE             = 360; // 360 degrees
    public static final double FIELD_LENGTH       = 144; // The length of the field, in inches
    public static final double FIELD_DIAGONAL     = FIELD_LENGTH * Math.sqrt(2); // The length of the field diagonally
    public static final double RADIUS             = 11.66726188957803; // The radius of the robot, in inches

    /**
     * Find the duration to move for in milliseconds using a distance, in inches
     * @param inches The distance, in inches (of course)
     * @return The duration, in milliseconds
     */
    public static long duration(double inches) {
        return (long) (1000 * (inches / INCHES_PER_SECOND));
    }

    /**
     *
     * @param degrees The angle
     * @return
     */
    public static long angle(double degrees) {
        return (long) (1000 * (degrees / DEGREES_PER_SECOND));
    }
}
