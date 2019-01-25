package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous program that moves from the lander, facing the depot side, to the depot to deploy
 * the marker, and finally moves to the crater
 */
@Autonomous(name = "Depot Side to Crater", group = "Robot Autonomous")
//@Disabled
public class DepotSide extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Dismount off the lander
            dismountLander();

            // Move till line of matierals
            driveForward(1);
            //move until we are clear of line of matierals an a little of farther
            driveRight(1);
            // Move so we are facing the depot
            turnLeft(Constants.CIRCLE / 20);
            //go to depot
            driveForward(1);
            // Extend arm or servo to deploy the marker
            turnArmTilt(Constants.CIRCLE / 12);
            //move backward to crater
            driveBackward(1);
        }
    }
}
