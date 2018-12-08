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
 * The Mecanum autonomous opmode
 */
@TeleOp(name="Pushbot: Teleop Mecanum (None)", group="Pushbot")
//@Disabled
public class MecanumAutonomous extends LinearOpMode {
    public static final long AUTONOMOUS_DURATION = 30000; // The duration of autonomous

    HardwareMecanum robot = new HardwareMecanum(); // The robot, containing each motor, servo, etc.
    protected ElapsedTime elapsedTime = new ElapsedTime(); // Keep track of the time so you know when to stop
    protected long movementPadding = 30; // A divider between each movement

    public MecanumAutonomous() {}

    /**
     * Call this function before your main loop
     *
     * Example:
     *
     * super.runOpMode();
     *
     * while (opModeIsActive()) {
     *     doStuff();
     *     if (endOpMode()) break;
     * }
     */
    @Override
    public void runOpMode() {
        // Initialize the robot using the hardware map
        robot.init(hardwareMap);

        // Wait until the start of the match (when driver presses START)
        waitForStart();

        // Reset the elapsed time
        elapsedTime.reset();

        // Run until the end of the match (when driver presses STOP)
        /* (loop goes here) */
    }

    protected void endOpMode() {
        sleep(AUTONOMOUS_DURATION - (long) elapsedTime.milliseconds());
    }

    /**
     * Make the robot move forward
     * @param duration The amount of time the robot should move forward for (in milliseconds)
     */
    public void moveForward(double power, long duration) {
        robot.frontLeftDrive.setPower(power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive.setPower(power);
        robot.backRightDrive.setPower(power);

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
    public void moveRight(double power, long duration) {
        robot.frontLeftDrive .setPower(power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(power);

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
    public void moveBackward(double power, long duration) {
        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(-power);

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
    public void moveLeft(double power, long duration) {
        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive  .setPower(power);
        robot.backRightDrive .setPower(-power);

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
    public void turnLeft(double power, long duration) {
        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(power);

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
    public void turnRight(double power, long duration) {
        robot.frontLeftDrive .setPower(power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(power);
        robot.backRightDrive .setPower(-power);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the arm turn
     * @param power The speed the arm will turn at
     * @param duration The amount of time the arm will turn for (in milliseconds)
     */
    public void turnArm(double power, long duration) {
        robot.armTilt.setPower(power);

        sleep(duration);

        robot.armTilt.setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the claw turn
     * @param power The speed the claw will turn at
     * @param duration The amount of time the claw will turn for (in milliseconds)
     */
    public void turnClaw(double power, long duration) {
        robot.clawTilt.setPower(power);

        sleep(duration);

        robot.clawTilt.setPower(0);

        sleep(movementPadding);
    }

    /**
     * Make the launcher turn
     * @param direction The direction for the launcher to turn in
     * @param position The position for the launcher to turn to
     */
    public void turnLauncher(Servo.Direction direction, double position) {
        robot.launcherTilt.setDirection(direction);
        robot.launcherTilt.setPosition(position);

        sleep(movementPadding);
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
