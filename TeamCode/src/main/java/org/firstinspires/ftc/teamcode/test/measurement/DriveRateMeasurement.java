package org.firstinspires.ftc.teamcode.test.measurement;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;
import org.firstinspires.ftc.teamcode.Constants;

/**
 * A test for measuring Constants.DRIVE_RATE.
 *
 * @see Constants#DRIVE_RATE
 */
@Autonomous(name = "Drive Rate", group = "Measurement Tests")
//@Disabled
public class DriveRateMeasurement extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            robot.frontLeftDrive.setPower(1);
            robot.frontRightDrive.setPower(1);
            robot.backLeftDrive.setPower(1);
            robot.backRightDrive.setPower(1);

            sleep(1000);

            robot.frontLeftDrive.setPower(0);
            robot.frontRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            robot.backRightDrive.setPower(0);
        }
    }
}
