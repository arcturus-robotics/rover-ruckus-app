package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous program that moves from the lander, facing the depot side, straight to the depot
 */
@Autonomous(name = "Depot Side Straight to Depot", group = "Robot Autonomous")
//@Disabled
public class DepotSide_StraightToDepot extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            driveForward(Constants.LANDER_TO_CORNER_LENGTH);

            // Deploy marker
            deployMarker();
        }
    }
}
