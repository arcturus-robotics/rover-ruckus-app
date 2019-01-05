package org.firstinspires.ftc.teamcode.mecanum;

/**
 * TODO: Use meters rather than milliseconds
 *       Our code could be much more efficient if we measured with meters
 */

public class Mecanum {
    public static final long AUTONOMOUS_DURATION  = 30000; // The distance of autonomous, in milliseconds
    public static final long MOVEMENT_PADDING     = 30; // A divider between each movement, in milliseconds
    public static final long INITIAL_DELAY        = 0; // The initial delay so that we don't get in the way of our ally's autonomous program
    public static final double DEPLOY_POWER       = 0.5; // The power at which the marker will be deployed
    public static final double DEPLOY_ANGLE       = 120; // The amount of time the marker will be deployed for
    public static final double INCHES_PER_SECOND  = 36.0416666666666667; // The distance the robot moves in a second, in inches
    public static final double DEGREES_PER_SECOND = 175; // (approximate) The angle the robot turns in one second
    public static final double CIRCLE             = 360; // 360 degrees
    public static final double FIELD_LENGTH       = 144; // The length of the field, in inches
    public static final double FIELD_DIAGONAL     = FIELD_LENGTH * Math.sqrt(2); // The length of the field diagonally
    public static final double LANDER_TO_CORNER   = 91; // The distance from the lander to the corner
    public static final double RADIUS             = 11.66726188957803;  // The radius of the robot, in inches

    /**
     * Find the distance to move for in milliseconds using <code>inches</code>
     * @param inches The distance, in inches (of course)
     * @return <code>inches</code> converted to movement distance, in milliseconds
     * @see Mecanum#INCHES_PER_SECOND
     */
    public static long distance(double inches) {
        return (long) (1000 * (inches / INCHES_PER_SECOND));
    }

    /**
     * Find the distance to turn for in milliseconds using <code>degrees</code>
     * @param degrees The angle
     * @return <code>degrees</code> converted to movement distance, in milliseconds
     * @see Mecanum#DEGREES_PER_SECOND
     */
    public static long angle(double degrees) {
        return (long) (1000 * (degrees / DEGREES_PER_SECOND));
    }
}
