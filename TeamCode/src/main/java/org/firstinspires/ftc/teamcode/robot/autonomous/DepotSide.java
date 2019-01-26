package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts facing the depot
 */
@Autonomous(name = "Depot Side to Crater", group = "Robot Autonomous")
//@Disabled
public class DepotSide extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Dismount off the lander.
            dismountLander();

            // Move till line of materials.
            driveForward(1);
            // Move until we are clear of line of materials an a little of farther.
            driveRight(1);
            // Move so we are facing the depot.
            turnLeft(18);
            // Go to depot.
            driveForward(1);
            // Extend arm to deploy the marker.
            turnArm(30);
            // Move backward to crater.
            driveBackward(1);
        }
    }
}
