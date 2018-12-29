package org.firstinspires.ftc.teamcode.mecanum.autonomous.crater;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * 1. Move to depot
 * 2. Deploy marker
 * 3. Move to crater
 */
@Autonomous(name="Mecanum Autonomous Crater Side: Depot", group="Mecanum Autonomous Crater Side")
//@Disabled
public class CraterSide_Depot extends CraterSide {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, Mecanum.FIELD_DIAGONAL);
            moveLeft(1, 36);
            turnRight(1, Mecanum.CIRCLE / 20);
            moveBackward(1, Mecanum.FIELD_LENGTH);

            // Deploy marker
            deployMarker();

            // Move to crater
            moveForward(1, Mecanum.FIELD_LENGTH);
        }
    }
}
