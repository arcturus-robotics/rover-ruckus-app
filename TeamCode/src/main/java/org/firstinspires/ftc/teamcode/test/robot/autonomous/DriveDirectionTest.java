package org.firstinspires.ftc.teamcode.test.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

@Autonomous(name = "Drive Direction Test", group = "Robot Autonomous Tests")
//@Disabled
public class DriveDirectionTest extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        double driveDistance = 5;
        long sleepDuration = 1000;

        if (opModeIsActive()) {
            telemetry.addData("Direction", "Forward");
            driveForward(driveDistance);

            sleep(sleepDuration);

            telemetry.addData("Direction", "Left");
            driveLeft(driveDistance);

            sleep(sleepDuration);

            telemetry.addData("Direction", "Backward");
            driveBackward(driveDistance);

            sleep(sleepDuration);

            telemetry.addData("Direction", "Right");
            driveRight(driveDistance);
        }
    }
}
