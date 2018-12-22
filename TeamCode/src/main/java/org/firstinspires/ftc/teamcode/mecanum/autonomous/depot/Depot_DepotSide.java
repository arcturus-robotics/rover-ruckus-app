package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@Autonomous(name="Mecanum Autonomous Depot: Depot side", group="Mecanum Autonomous Depot")
//@Disabled
public class Depot_DepotSide extends Depot {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, Mecanum.LANDER);
        }
    }
}
