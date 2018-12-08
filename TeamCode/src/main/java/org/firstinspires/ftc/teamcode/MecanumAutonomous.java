package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * The Mecanum autonomous opmode.
 */
@TeleOp(name="Pushbot: Mecanum Autonomous", group="Pushbot")
public class MecanumAutonomous extends LinearOpMode {
    public static final long AUTONOMOUS_DURATION = 30000; // The duration of autonomous

    HardwareMecanum robot = new HardwareMecanum(); // The robot, containing each motor, servo, etc.
    private ElapsedTime elapsedTime = new ElapsedTime(); // Keep track of the time so you know when to stop
    private long movementPadding = 30; // A sort of divider between each movement

    public MecanumAutonomous() {}

    @Override
    public void runOpMode() {
        /*
         * Initialize the robot using the hardware map
         */
        robot.init(hardwareMap);

        // Wait until the start of the match (when driver presses START)
        waitForStart();

        // Reset the elapsed time
        elapsedTime.reset();

        // Run until the end of the match (when driver presses STOP)
        while(opModeIsActive()) {
            long ms = 1000;
            moveRight(ms);
            moveForward(ms);

            // If more than the maximum time has elapsed, break out of the loop
            if (elapsedTime.milliseconds() > AUTONOMOUS_DURATION) { break; }

            // Wait until the end of autonomous
            sleep(AUTONOMOUS_DURATION - (long) elapsedTime.milliseconds());
        }
    }

    /**
     * Utility function to easily move a motor in one line
     * @param motor The motor to turn
     * @param direction The direction the motor will turn in
     * @param duration The amount of time the motor will turn for (in milliseconds)
     */
    private void turnMotor(DcMotor motor, DcMotor.Direction direction, long duration) {
        if (direction == DcMotor.Direction.FORWARD) {
            motor.setPower(1);
        } else if (direction == DcMotor.Direction.REVERSE) {
            motor.setPower(-1);
        }

        sleep(duration);

        motor.setPower(0);

        sleep(movementPadding);
    }

    /**
     * Utility function to easily move a servo in one line
     * NOTE: This will only work with 1 servo, because it uses `sleep`!
     * @param servo The servo to turn
     * @param direction The direction the servo will turn in
     * @param position The position the servo will turn to
     */
    private void turnServo(Servo servo, Servo.Direction direction, double position) {
        servo.setDirection(direction);
        servo.setPosition(position);

        sleep(movementPadding);
    }

    /**
     * Make the robot move forward
     * @param duration The amount of time the robot should move forward for (in milliseconds)
     */
    public void moveForward(long duration) {
        robot.frontLeftDrive.setPower(1);
        robot.frontRightDrive.setPower(1);
        robot.backLeftDrive.setPower(1);
        robot.backRightDrive.setPower(1);

        sleep(duration);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the robot move right
     * @param duration The amount of time the robot should move right for (in milliseconds)
     */
    public void moveRight(long duration) {
        robot.frontLeftDrive .setPower(1);
        robot.frontRightDrive.setPower(-1);
        robot.backLeftDrive  .setPower(-1);
        robot.backRightDrive .setPower(1);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the robot move backward
     * @param duration The amount of time the robot should move backward for (in milliseconds)
     */
    public void moveBackward(long duration) {
        robot.frontLeftDrive .setPower(-1);
        robot.frontRightDrive.setPower(-1);
        robot.backLeftDrive  .setPower(-1);
        robot.backRightDrive .setPower(-1);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the robot move left
     * @param duration The amount of time the robot should move left for (in milliseconds)
     */
    public void moveLeft(long duration) {
        robot.frontLeftDrive .setPower(-1);
        robot.frontRightDrive.setPower(1);
        robot.backLeftDrive  .setPower(1);
        robot.backRightDrive .setPower(-1);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the robot turn left
     * @param duration The amount of time the robot should turn left for (in milliseconds)
     */
    public void turnLeft(long duration) {
        robot.frontLeftDrive .setPower(-1);
        robot.frontRightDrive.setPower(1);
        robot.backLeftDrive  .setPower(-1);
        robot.backRightDrive .setPower(1);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the robot turn right
     * @param duration The amount of time the robot should turn right for (in milliseconds)
     */
    public void turnRight(long duration) {
        robot.frontLeftDrive .setPower(1);
        robot.frontRightDrive.setPower(-1);
        robot.backLeftDrive  .setPower(1);
        robot.backRightDrive .setPower(-1);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the arm turn
     * @param direction The direction for the arm to turn in
     * @param duration The amount of time the arm should turn for (in milliseconds)
     */
    public void turnArm(DcMotor.Direction direction, long duration) {
        turnMotor(robot.armTilt, direction, duration);
    }

    /**
     * Make the claw turn
     * @param direction The direction for the claw to turn in
     * @param duration The amount of time the claw should turn for (in milliseconds)
     */
    public void turnClaw(DcMotor.Direction direction, long duration) {
        turnMotor(robot.clawTilt, direction, duration);
    }

    /**
     * Make the launcher turn
     * @param direction The direction for the launcher to turn in
     * @param position The position for the launcher to turn to
     */
    public void turnLauncher(Servo.Direction direction, double position) {
        turnServo(robot.launcherTilt, direction, position);
    }

    /**
     * Make the launcher turn using degrees
     * // NOTE: This is untested!
     * @param direction The direction for the launcher to turn in
     * @param degrees The angle for the launcher to turn to (in degrees)
     */
    public void turnLauncherDeg(Servo.Direction direction, double degrees) {
        turnLauncher(direction, degrees / 180);
    }

    /**
     * Make the launcher turn using radians
     * NOTE: This is untested!
     * @param direction The direction for the launcher to turn in
     * @param radians The angle for the launcher to turn to (in radians)
     */
    public void setLauncherRad(Servo.Direction direction, double radians) {
        turnLauncher(direction, radians / Math.PI);
    }
}
