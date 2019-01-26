package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A collection of various conversion methods.
 */
public class Conversion {
    /**
     * Convert inches into a robot drive duration.
     *
     * @param inches The distance to be converted.
     * @return <code>inches</code> converted into a robot drive duration.
     * @see Constants#DRIVE_RATE
     */
    public static long inchesToDrive(double inches) {
        return (long) (1000 * (inches / Constants.DRIVE_RATE));
    }

    /**
     * Convert degrees into a robot drive turn duration.
     *
     * @param degrees The angle to be converted.
     * @return <code>degrees</code> converted into a robot drive turn duration.
     * @see Constants#TURN_RATE
     */
    public static long degreesToDrive(double degrees) {
        return (long) (1000 * (degrees / Constants.TURN_RATE));
    }

    /**
     * Convert degrees into a motor turn duration.
     *
     * @param degrees The angle to be converted.
     * @return <code>degrees</code> converted into a motor turn duration.
     * @see Constants#MOTOR_TURN_RATE
     */
    public static long degreesToMotor(double degrees) {
        return (long) (1000 * (degrees / Constants.MOTOR_TURN_RATE));
    }

    /**
     * Convert degrees into a Torquenado turn duration.
     *
     * @param degrees The angle to be converted.
     * @return <code>degrees</code> converted into a Torquenado turn duration.
     * @see Constants#TORQUENADO_TURN_RATE
     */
    public static long degreesToTorquenado(double degrees) {
        return (long) (1000 * (degrees / Constants.TORQUENADO_TURN_RATE));
    }

    /**
     * Convert degrees into a servo position.
     *
     * @param degrees The angle to be converted.
     * @return <code>degrees</code> converted into a servo position.
     */
    public static double degreesToServoPosition(double degrees) {
        return Math.abs(degrees) / 180;
    }

    /**
     * Calculate how many degrees are in <code>t</code> revolutions.
     *
     * @param revolutions The amount of revolutions.
     * @return The degrees in <code>revolutions</code>.
     */
    public static double revolutionsToDegrees(double revolutions) {
        return 360 * revolutions;
    }
}
