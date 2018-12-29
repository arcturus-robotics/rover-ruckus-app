package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * 1. Move to depot
 * 2. Deploy marker
 * 3. Move to crater
 */
@Autonomous(name="Mecanum Autonomous Depot Side: Crater", group="Mecanum Autonomous Depot Side")
//@Disabled
public class DepotSide_Crater extends DepotSide {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, Mecanum.LANDER / 3);
            moveLeft(1,(Mecanum.LANDER / 2) + 154);
            turnRight(1, Mecanum.CIRCLE / 12);
            moveBackward(1, (long) (Mecanum.FIELD * 0.4));

            // Deploy marker
            deployMarker();

            // Move to crater
            turnLeft(1, 154);
            moveForward(1, Mecanum.FIELD / 2);
            turnArm(-1, 500);
        }
    }
}
