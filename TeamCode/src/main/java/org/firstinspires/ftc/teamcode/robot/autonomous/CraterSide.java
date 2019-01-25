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

            // Move to the line of materials
            driveForward(16);
            //drive left fast the lander arm and into the clearing
            driveLeft(42);
            //so the front of our robot is facing depot
            turnRight(Constants.CIRCLE / 20);
            //make sure robot is in line with wall
            driveRight(5);
            //go to depot
            driveForward(20);
            // Move to crater
            driveBackward(Constants.FIELD_DISTANCE-10);
        }
    }
}
