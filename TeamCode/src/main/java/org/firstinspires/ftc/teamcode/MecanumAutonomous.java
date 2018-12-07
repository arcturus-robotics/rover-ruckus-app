package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Pushbot: Mecanum Autonomous", group="Pushbot")
public class MecanumAutonomous extends LinearOpMode {
    public static final long AUTONOMOUS_TIME = 30000;

    HardwareMecanum robot = new HardwareMecanum();
    private ElapsedTime elapsedTime = new ElapsedTime();
    private long postMovementSleep = 30;

    public MecanumAutonomous() {}

    @Override
    public void runOpMode() {
        /*
         * The init() method of the hardware class does all the work here.
         */
        robot.init(hardwareMap);

        // Wait until the start of the match (when driver presses START)
        waitForStart();

        // Reset the elapsed time
        elapsedTime.reset();

        // Run until the end of the match (when driver presses STOP)
        while (opModeIsActive()) {
            // Testing
            long ms = 1000;
            moveRight(ms);
            moveForward(ms);
            moveLeft(ms);
            moveBackward(ms);

            // If more than the maximum time has elapsed, break out of the loop
            if (elapsedTime.milliseconds() > AUTONOMOUS_TIME) { break; }

            // Wait until the end of autonomous
            sleep(AUTONOMOUS_TIME - (long) elapsedTime.milliseconds());
        }
    }

    /**
     * Make the robot move forward
     * @param ms The amount of milliseconds to move forward
     */
    public void moveForward(long ms) {
        robot.frontLeftDrive.setPower(1);
        robot.frontRightDrive.setPower(1);
        robot.backLeftDrive.setPower(1);
        robot.backRightDrive.setPower(1);

        sleep(ms);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the robot move right
     * @param ms The amount of milliseconds to move right
     */
    public void moveRight(long ms) {
        robot.frontLeftDrive.setPower(1);
        robot.frontRightDrive.setPower(-1);
        robot.backLeftDrive.setPower(-1);
        robot.backRightDrive.setPower(1);

        sleep(ms);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the robot move backward
     * @param ms The amount of milliseconds to move backward
     */
    public void moveBackward(long ms) {
        robot.frontLeftDrive.setPower(-1);
        robot.frontRightDrive.setPower(-1);
        robot.backLeftDrive.setPower(-1);
        robot.backRightDrive.setPower(-1);

        sleep(ms);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the robot move left
     * @param ms The amount of milliseconds to move left
     */
    public void moveLeft(long ms) {
        robot.frontLeftDrive.setPower(-1);
        robot.frontRightDrive.setPower(1);
        robot.backLeftDrive.setPower(1);
        robot.backRightDrive.setPower(-1);

        sleep(ms);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the robot turn left
     * @param ms The amount of milliseconds to turn left
     */
    public void turnLeft(long ms) {
        robot.frontLeftDrive.setPower(-1);
        robot.frontRightDrive.setPower(1);
        robot.backLeftDrive.setPower(-1);
        robot.backRightDrive.setPower(1);

        sleep(ms);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the robot turn right
     * @param ms The amount of milliseconds to turn right
     */
    public void turnRight(long ms) {
        robot.frontLeftDrive.setPower(1);
        robot.frontRightDrive.setPower(-1);
        robot.backLeftDrive.setPower(1);
        robot.backRightDrive.setPower(-1);

        sleep(ms);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the arm turn forward
     * @param ms The amount of milliseconds for it to turn forward
     */
    public void turnArmForward(long ms) {
        robot.armTilt.setPower(1);

        sleep(ms);

        robot.armTilt.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the arm turn backward
     * @param ms The amount of milliseconds for it to turn backward
     */
    public void turnArmBackward(long ms) {
        robot.armTilt.setPower(-1);

        sleep(ms);

        robot.armTilt.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the claw turn forward
     * @param ms The amount of milliseconds for it to turn forward
     */
    public void turnClawForward(long ms) {
        robot.clawTilt.setPower(1);

        sleep(ms);

        robot.clawTilt.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the claw turn backward
     * @param ms The amount of milliseconds for it to turn backward
     */
    public void turnClawBackward(long ms) {
        robot.clawTilt.setPower(-1);

        sleep(ms);

        robot.clawTilt.setPower(0);

        sleep(postMovementSleep);
    }

    /**
     * Make the launcher turn forward
     * @param dir The direction to go to
     * @param pos The position to go to
     */
    public void setLauncher(Servo.Direction dir, double pos) {
        robot.launcherTilt.setDirection(dir);
        robot.launcherTilt.setPosition(pos);
    }
}
