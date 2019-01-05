package org.firstinspires.ftc.teamcode.mecanum.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;
import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * The Mecanum autonomous opmode
 */
@Autonomous(name="Mecanum Autonomous", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous extends LinearOpMode {
    protected HardwareMecanum robot   = new HardwareMecanum(); // The robot, containing each motor, servo, etc.
    protected ElapsedTime elapsedTime = new ElapsedTime(); // Keep track of the time so you know when to stop

    @Override
    public void runOpMode() {
        // Initialize the robot using the hardware map
        robot.init(hardwareMap);

        // Wait until the start of the match (when driver presses START)
        waitForStart();

        // Reset the elapsed time
        elapsedTime.reset();

        // Sleep for the initial delay so we don't get in the way of our ally
        sleep(Mecanum.INITIAL_DELAY);
    }

    /**
     * Calculate the remaining time
     * @return The remaining time
     * @see Mecanum#AUTONOMOUS_DURATION
     */
    public long remainingTime() {
        long remaining = Mecanum.AUTONOMOUS_DURATION - (long) elapsedTime.milliseconds();
        if (remaining < 0)  {
            remaining = 0;
        }
        return remaining;
    }

    /**
     * Deploy the marker
     * @see Mecanum#DEPLOY_POWER
     */
    public void deployMarker() {
        turnClaw(Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_ANGLE);
        turnClaw(-Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_ANGLE);
    }

    /**
     * Make the robot move forward
     * @param power The speed the robot will move forward at
     * @param distance The distance, in inches, to move the robot forward for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void moveForward(double power, double distance) {
        robot.frontLeftDrive.setPower(power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive.setPower(power);
        robot.backRightDrive.setPower(power);

        sleep(Mecanum.duration(distance));

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot move right
     * @param power The speed the robot will move right at
     * @param distance The distance, in inches, to move the robot right for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void moveRight(double power, double distance) {
        robot.frontLeftDrive .setPower(power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(power);

        sleep(Mecanum.duration(distance));

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot move backward
     * @param power The speed the robot will move backward at
     * @param distance The distance, in inches, to move the robot backward for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void moveBackward(double power, double distance) {
        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(-power);

        sleep(Mecanum.duration(distance));

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot move left
     * @param power The speed the robot will move left at
     * @param distance The distance, in inches, to move the robot left for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void moveLeft(double power, double distance) {
        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive  .setPower(power);
        robot.backRightDrive .setPower(-power);

        sleep(Mecanum.duration(distance));

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot turn left
     * @param power The speed the robot will turn left at
     * @param degrees The angle to turn the robot left for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void turnLeft(double power, double degrees) {
        robot.frontLeftDrive .setPower(-power);
        robot.frontRightDrive.setPower(power);
        robot.backLeftDrive  .setPower(-power);
        robot.backRightDrive .setPower(power);

        sleep(Mecanum.angle(degrees));

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the robot turn right
     * @param power The speed the robot will turn right at
     * @param degrees The angle to turn the robot right for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void turnRight(double power, double degrees) {
        robot.frontLeftDrive .setPower(power);
        robot.frontRightDrive.setPower(-power);
        robot.backLeftDrive  .setPower(power);
        robot.backRightDrive .setPower(-power);

        sleep(Mecanum.angle(degrees));

        robot.frontLeftDrive .setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive  .setPower(0);
        robot.backRightDrive .setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the arm turn
     * @param power The speed the arm will turn at
     * @param degrees The angle turn turn the arm for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void turnArm(double power, double degrees) {
        robot.armTilt.setPower(power);

        sleep(Mecanum.angle(degrees));

        robot.armTilt.setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the claw turn
     * @param power The speed the claw will turn at
     * @param degrees The angle to turn the claw for
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void turnClaw(double power, double degrees) {
        robot.clawTilt.setPower(power);

        sleep(Mecanum.angle(degrees));

        robot.clawTilt.setPower(0);

        sleep(Mecanum.MOVEMENT_PADDING);
    }

    /**
     * Make the launcher turn
     * @param direction The direction for the launcher to turn in
     * @param position The position for the launcher to turn to
     * @see Mecanum#MOVEMENT_PADDING
     */
    public void turnLauncher(Servo.Direction direction, double position) {
        robot.launcherTilt.setDirection(direction);
        robot.launcherTilt.setPosition(position);

        sleep(Mecanum.MOVEMENT_PADDING);
    }
}
