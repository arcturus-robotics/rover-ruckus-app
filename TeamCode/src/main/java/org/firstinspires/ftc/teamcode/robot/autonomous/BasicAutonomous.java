package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * A basic autonomous program that only moves forward to the corner of the field
 */
@Autonomous(name = "Basic Autonomous", group = "Robot Autonomous")
//@Disabled
public class BasicAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(Constants.FIELD_DIAGONAL_LENGTH);
        }
    }
}
