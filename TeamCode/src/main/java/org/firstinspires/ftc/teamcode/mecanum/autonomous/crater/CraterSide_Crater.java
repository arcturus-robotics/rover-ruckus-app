package org.firstinspires.ftc.teamcode.mecanum.autonomous.crater;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * 1. Move to crater
 */
@Autonomous(name="Mecanum Autonomous Crater Side: Crater", group="Mecanum Autonomous Crater Side")
//@Disabled
public class CraterSide_Crater extends CraterSide {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to crater
            moveForward(1, Mecanum.FIELD_DIAGONAL);
        }
    }
}
