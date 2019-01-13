package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous program that moves from the lander, facing the crater side, straight to the crater
 */
@Autonomous(name = "Crater Side Straight to Crater", group = "Robot Autonomous")
//@Disabled
public class CraterSide_StraightToCrater extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to crater
            driveForward(Constants.FIELD_DIAGONAL_LENGTH);

            // Extend arm
            turnArmTilt(Constants.CIRCLE / 12);
        }
    }
}
