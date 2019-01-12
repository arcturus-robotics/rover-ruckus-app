package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

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
