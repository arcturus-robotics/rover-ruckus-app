package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous program that moves from the lander, facing the crater side, to the depot to deploy
 * the marker, and finally moves to the crater
 */
@Autonomous(name = "Crater Side to Depot", group = "Robot Autonomous")
//@Disabled
public class CraterSide extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Dismount the lander
            dismountLander();

            // Move to depot
            driveToCrater();
            driveLeft(36);
            turnRight(Constants.CIRCLE / 20);
            driveBackward(Constants.FIELD_DISTANCE);

            // Move to crater
            driveForward(Constants.FIELD_DISTANCE);
        }
    }
}
