package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * A basic autonomous program that dismounts off of the lander and moves forward to the corner of
 * the field
 */
@Autonomous(name = "Basic Autonomous", group = "Robot Autonomous")
//@Disabled
public class BasicAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {


            // Drive to the corner of the field
            driveToCorner();
        }
    }
}
