package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * An opmode with many utility methods for autonomous programs
 */
public class RobotLinearOpMode extends LinearOpMode {
    protected RobotHardware robot = new RobotHardware();
    protected ElapsedTime period = new ElapsedTime();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        // Initialize the robot using the hardware map
        robot.init(hardwareMap);

        // Wait until the driver presses PLAY
        waitForStart();

        // Reset the elapsed time so we can accurately measure it
        period.reset();

        sleep(Constants.INITIAL_DELAY_DURATION);
    }

    /**
     * Utility function for driving with the specified drive powers and a duration <code>duration</code>
     *
     * @param frontLeftPower  The power to drive the front left drive motor with
     * @param frontRightPower The power to drive the front right  drive motor with
     * @param backLeftPower   The power to drive the back left drive motor with
     * @param backRightPower  The power to drive the back right drive motor with
     * @param duration        The duration to drive for (in milliseconds)
     * @see RobotHardware#frontLeftDrive
     * @see RobotHardware#frontRightDrive
     * @see RobotHardware#backLeftDrive
     * @see RobotHardware#backRightDrive
     * @see Constants#PADDING_DURATION
     */
    private void drive(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        robot.frontLeftDrive.setPower(-frontLeftPower);
        robot.frontRightDrive.setPower(-frontRightPower);
        robot.backLeftDrive.setPower(-backLeftPower);
        robot.backRightDrive.setPower(-backRightPower);

        sleep(duration);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(Constants.PADDING_DURATION);
    }

    /**
     * Deploy marker
     *
     * @see Constants#DEPLOY_ANGLE
     */
    public void deployMarker() {
        /* Unimplemented
        turnClawTilt(Constants.DEPLOY_ANGLE);
        turnClawTilt(Constants.DEPLOY_ANGLE);
        */
    }

    /**
     * Drive forward for a distance <code>inches</code>
     *
     * @param inches The distance to drive forward for
     * @see RobotLinearOpMode#drive
     * @see Conversion#inchesToDrive(double)
     */
    public void driveForward(double inches) {
        drive(
                1, 1,
                1, 1,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Drive left for a distance <code>inches</code>
     *
     * @param inches The distance to drive left for
     * @see RobotLinearOpMode#drive
     * 4@see Conversion#inchesToDuration(double)
     */
    public void driveLeft(double inches) {
        drive(
                -1, 1,
                1, -1,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Drive backward for a distance <code>inches</code>
     *
     * @param inches The distance to drive backward for
     * @see RobotLinearOpMode#drive
     * @see Conversion#inchesToDrive(double)
     */
    public void driveBackward(double inches) {
        drive(
                -1, -1,
                -1, -1,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Drive right for a distance <code>inches</code>
     *
     * @param inches The distance to drive right for
     * @see RobotLinearOpMode#drive
     * @see Conversion#inchesToDrive(double)
     */
    public void driveRight(double inches) {
        drive(
                1, -1,
                -1, 1,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Turn left <code>degrees</code>
     *
     * @param degrees The angle to turn left for
     * @see RobotLinearOpMode#drive
     * @see Conversion#degreesToDrive(double)
     */
    public void turnLeft(double degrees) {
        drive(
                -1, 1,
                -1, 1,
                Conversion.degreesToDrive(degrees)
        );
    }

    /**
     * Turn right <code>degrees</code>
     *
     * @param degrees The angle to turn right for
     * @see RobotLinearOpMode#drive
     * @see Conversion#degreesToDrive(double)
     */
    public void turnRight(double degrees) {
        drive(
                -1, 1,
                -1, 1,
                Conversion.degreesToDrive(degrees)
        );
    }

    /**
     * Turn the launcher mechanism
     *
     * @param degrees The angle to turn the launcher mechanism for
     * @see Conversion#degreesToTorquenado(double)
     */
    public void turnArmTilt(double degrees) {
        /* Unimplemented
        if (degrees > 0) {
            robot.latchMechanism.setPower(1);
        } else {
            robot.latchMechanism.setPower(-1);
        }

        sleep(Conversion.degreesToTorquenado(degrees));

        robot.latchMechanism.setPower(0);

        sleep(Constants.PADDING_DURATION);
        */
    }

    /**
     * Turn the launcher mechanism
     *
     * @param degrees The angle to turn the launcher mechanism for
     * @see Conversion#degreesToTorquenado(double)
     */
    public void turnClawTilt(double degrees) {
        /* Unimplemented
        if (degrees > 0) {
            robot.latchMechanism.setPower(1);
        } else {
            robot.latchMechanism.setPower(-1);
        }

        sleep(Conversion.degreesToTorquenado(degrees));

        robot.latchMechanism.setPower(0);

        sleep(Constants.PADDING_DURATION);
        */
    }

    /**
     * Turn the latch mechanism
     *
     * @param degrees The angle to turn the latch mechanism for
     * @see Conversion#degreesToTorquenado(double)
     */
    public void turnLatchMechanism(double degrees) {
        if (degrees > 0) {
            robot.latchMechanism.setPower(1);
        } else {
            robot.latchMechanism.setPower(-1);
        }

        sleep(Conversion.degreesToTorquenado(degrees));

        robot.latchMechanism.setPower(0);

        sleep(Constants.PADDING_DURATION);
    }

    public void rotateLauncherTilt(double degrees) {
        /* Unimplemented
        if (degrees > 0) {
            robot.launcherTilt.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.launcherTilt.setDirection(Servo.Direction.REVERSE);
        }

        robot.launcherTilt.setPosition(Conversion.degreesToServoPosition(degrees));

        sleep(Constants.PADDING_DURATION);
        */
    }

    public void rotateClawLeft(double degrees) {
        /* Unimplemented
        if (degrees > 0) {
            robot.clawLeft.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.clawLeft.setDirection(Servo.Direction.REVERSE);
        }

        robot.clawRight.setPosition(Conversion.degreesToServoPosition(degrees));

        sleep(Constants.PADDING_DURATION);
        */
    }

    public void rotateClawRight(double degrees) {
        /* Unimplemented
        if (degrees > 0) {
            robot.clawRight.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.clawRight.setDirection(Servo.Direction.REVERSE);
        }

        robot.clawRight.setPosition(Conversion.degreesToServoPosition(degrees));

        sleep(Constants.PADDING_DURATION);
        */
    }
}
