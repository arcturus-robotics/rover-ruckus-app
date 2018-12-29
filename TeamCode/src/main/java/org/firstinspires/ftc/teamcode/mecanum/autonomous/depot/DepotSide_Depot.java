package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * 1. Move to depot
 * 2. Deploy marker
 */
@Autonomous(name="Mecanum Autonomous Depot Side: Depot", group="Mecanum Autonomous Depot Side")
//@Disabled
public class DepotSide_Depot extends DepotSide {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, Mecanum.FIELD_DIAGONAL);

            // Deploy marker
            deployMarker();
        }
    }
}
