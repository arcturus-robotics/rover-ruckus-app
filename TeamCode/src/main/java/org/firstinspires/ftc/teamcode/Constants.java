package org.firstinspires.ftc.teamcode;

/**
 * A collection of constants about the field, our robot, and Vuforia.
 * They are mainly durations, distances, and angles
 */
public class Constants {
    /**
     * Our Vuforia license key
     */
    public static final String VUFORIA_LICENSE_KEY = "AagmIFb/////AAABmQeoELJRUUhBnw22N1rfAeURKsi4lO2PBquW4po2++umNgidlnmVALYdHmMXwjhAD9owXoF2zkCbWmBDEStv642zdEddYZGqPjK2pn4bDvhEeSVj4mQs3zR7mB2T94RenHo+qz8zhq4yidyNRZNYF/Y3OUTayx7H6EtYnU6kaOZi30xW6ZzrzzyP/dEG5mHV2pzBHTEu/Qe1g7RcsCG5sFDg0KAagyjxgC6X3z4/EA0tC2554q+o8S+glD7nFidnAF5e2Pti3+gAnwDN6Nl/nRGrsD0JyAVUFFk2Ii0uEorRz31VCD3C4+ib2UHN0QOZwTYgqXQ4JcH5bXJsqn1aDmSeky2smnk7xamtfXkdBm0I";

    /**
     * The duration of autonomous (in milliseconds)
     */
    public static final long AUTONOMOUS_DURATION = 30000;

    /**
     * Padding between each movement of the robot (in milliseconds)
     */
    public static final long PADDING_DURATION = 30;

    /**
     * An initial delay so we don't get in the way of our ally's autonomous program (in milliseconds)
     */
    public static final long INITIAL_DELAY_DURATION = 0;

    /**
     * The angle the arm will be turned by to deploy the marker (in degrees)
     */
    public static final double DEPLOY_ANGLE = 60;

    /**
     * The approximate rate at which the robot drives in a second (in inches)
     */
    public static final double DRIVE_RATE = 36.0416666666666667;

    /**
     * The approximate rate at which the robot turns in a second (in degrees)
     */
    public static final double TURN_RATE = 175;

    /**
     * The approximate rate at which a motor turns in a second (in degrees) (to be measured)
     */
    public static final double MOTOR_TURN_RATE = 1395;

    /**
     * The approximate rate at which a Torquenado motor turns in a second (in degrees)
     */
    public static final double TORQUENADO_TURN_RATE = 1395;

    /**
     * 360 degrees
     */
    public static final double CIRCLE = 360;

    /**
     * The approximate radius of the robot (in inches)
     */
    public static final double RADIUS = 11.66726188957803;

    /**
     * The length of the field (in inches)
     */
    public static final double FIELD_DISTANCE = 144;

    /**
     * The length of the field diagonally (in inches)
     *
     * @see Constants#FIELD_DISTANCE
     */
    public static final double FIELD_DIAGONAL_DISTANCE = FIELD_DISTANCE * Math.sqrt(2);

    /**
     * The approximate distance from the lander to the corner of the field (in inches)
     */
    public static final double LANDER_TO_CORNER_DISTANCE = 88;

    /**
     * The position of the middle of a servo
     */
    public static final double MID_SERVO = 0.5;

    /**
     * The amount of degrees it takes for the latch to lower the robot to the ground or raise it to the lander
     */
    public static final double LATCH_ANGLE = Utilities.revolutions(16);

    /**
     * The approximate distance from the lander to the edge of the lander (in inches)
     */
    public static final double LANDER_TO_CRATER_DISTANCE = 24;

    /**
     * The distance to move off of the lander so we don't get caught on the hanger (in inches)
     */
    public static final double DISMOUNT_DISTANCE = 7.75;

    /**
     * The distance to move forward to escape the lander (in inches)
     */
    public static final double DISMOUNT_FORWARD_DISTANCE = 0.85;
}
