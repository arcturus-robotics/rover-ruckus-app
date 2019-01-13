package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous program that moves from the lander, facing the depot side, to the depot to deploy
 * the marker, and finally moves to the crater
 */
@Autonomous(name = "Depot Side to Crater", group = "Robot Autonomous")
//@Disabled
public class DepotSide_DepotToCrater extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            driveForward(Constants.LANDER_TO_CORNER_LENGTH);

            // Deploy marker
            deployMarker();

            // Move to crater
            turnLeft(Constants.CIRCLE / 20);
            driveBackward(Constants.FIELD_LENGTH);

            // Extend arm
            turnArmTilt(Constants.CIRCLE / 12);
        }
    }
}
