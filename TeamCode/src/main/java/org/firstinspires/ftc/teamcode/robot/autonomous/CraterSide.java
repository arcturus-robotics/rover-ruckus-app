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
            // Dismount the lander check Linear Opmode
            dismountLander();


            //drive left fast the lander arm and into the clearing
            driveLeft(140);
            //so the front of our robot is facing depot
            turnRight(290);
            //make sure robot is in line with wall
            driveRight(60);
            //go to depot
            driveForward(130);
            // Move to crater
            driveBackward(Constants.FIELD_DISTANCE-10);
        }
    }
}
