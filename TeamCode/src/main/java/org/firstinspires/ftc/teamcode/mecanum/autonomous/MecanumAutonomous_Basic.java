package org.firstinspires.ftc.teamcode.mecanum.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * The Mecanum autonomous opmode that moves forward into the crater/depot
 */
@Autonomous(name="Mecanum Autonomous: Basic", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous_Basic extends MecanumAutonomous {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            moveForward(1, Mecanum.FIELD_DIAGONAL);
        }
    }
}
