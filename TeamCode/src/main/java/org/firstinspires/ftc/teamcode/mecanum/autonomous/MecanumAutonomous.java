package org.firstinspires.ftc.teamcode.mecanum.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;
import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * The Mecanum autonomous opmode
 * NOTE: If you are manually using the wheel motors, multiply your power by <code>Mecanum.POWER</code>
 */
@Autonomous(name="Mecanum Autonomous", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous extends LinearOpMode {
    protected HardwareMecanum robot   = new HardwareMecanum(); // The robot, containing each motor, servo, etc.
    protected ElapsedTime elapsedTime = new ElapsedTime(); // Keep track of the time so you know when to stop

    public MecanumAutonomous() {}

    @Override
    public void runOpMode() {
        // Initialize the robot using the hardware map
        robot.init(hardwareMap);

        // Wait until the start of the match (when driver presses START)
        waitForStart();

        // Reset the elapsed time
        elapsedTime.reset();
    }

    /**
     * Returns the remaining time
     * NOTE: If more time has elapsed than the duration of autonomous, this will return 0
     */
    public long remainingTime() {
        long remaining = Mecanum.AUTONOMOUS_DURATION - (long) elapsedTime.milliseconds();
        if (remaining < 0) remaining = 0;
        return remaining;
    }

    /**
     * Make the robot move forward
     * @param power The speed the robot will move forward at
     * @param duration The amount of time the robot will move forward for (in milliseconds)
     */
    public void moveForward(double power, long duration) {
        power *= Mecanum.POWER;

        robot.frontLeftDrive.setPower(power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive.setPower(power);
        robot.backRightDrive.setPower(power);

        sleep(duration);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot move right
     * @param power The speed the robot will move right at
     * @param duration The amount of time the robot will move right for (in milliseconds)
     */
    public void moveRight(double power, long duration) {
        power *= Mecanum.POWER;

        robot.frontLeftDrive .setPower(power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(power);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot move backward
     * @param power The speed the robot will move backward at
     * @param duration The amount of time the robot will move backward for (in milliseconds)
     */
    public void moveBackward(double power, long duration) {
        power *= Mecanum.POWER;

        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(-power);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot move left
     * @param power The speed the robot will move left at
     * @param duration The amount of time the robot will move left for (in milliseconds)
     */
    public void moveLeft(double power, long duration) {
        power *= Mecanum.POWER;

        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive  .setPower(power);
        robot.backRightDrive .setPower(-power);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot turn left
     * @param power The speed the arm will turn left at
     * @param duration The amount of time the robot will turn left for (in milliseconds)
     */
    public void turnLeft(double power, long duration) {
        power *= Mecanum.POWER;

        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(power);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot turn right
     * @param power The speed the robot will turn right at
     * @param duration The amount of time the robot will turn right for (in milliseconds)
     */
    public void turnRight(double power, long duration) {
        power *= Mecanum.POWER;

        robot.frontLeftDrive .setPower(power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(power);
        robot.backRightDrive .setPower(-power);

        sleep(duration);

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
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

        sleep(Mecanum.MOVEMENT_PADDING);
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

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the launcher turn
     * @param direction The direction for the launcher to turn in
     * @param position The position for the launcher to turn to
     */
    public void turnLauncher(Servo.Direction direction, double position) {
        robot.launcherTilt.setDirection(direction);
        robot.launcherTilt.setPosition(position);

        sleep(Mecanum.MOVEMENT_PADDING);
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
