package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts facing the crater
 */
@Autonomous(name = "Crater Side to Depot", group = "Robot Autonomous")
//@Disabled
public class CraterSide extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Dismount the lander check Linear Opmode
            dismountLander();

            // Drive left fast the lander arm and into the clearing
            driveLeft(140);
            // So the front of our robot is facing depot
            turnRight(290);
            // Make sure robot is in line with wall
            driveRight(60);
            // Go to depot
            driveForward(130);
            // Move to crater
            driveBackward(Constants.FIELD_DISTANCE - 10);
        }
    }
}
