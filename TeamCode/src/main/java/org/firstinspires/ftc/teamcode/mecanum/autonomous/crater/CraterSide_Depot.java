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
            moveForward(1, Mecanum.LANDER / 2);
            moveLeft(1, (long) (1.4 * (Mecanum.LANDER / 2)));
            turnRight(1, (long) (0.4 * (Mecanum.CIRCLE / 8)));
            moveBackward(1, 3250);

            // Deploy marker
            deployMarker();

            // Move to crater
            moveForward(1, Mecanum.FIELD);
        }
    }
}
