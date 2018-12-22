package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@Autonomous(name="Mecanum Autonomous Depot Side: Depot", group="Mecanum Autonomous Depot Side")
//@Disabled
public class DepotSide_Depot extends DepotSide {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, Mecanum.LANDER);
            turnClaw(Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_DURATION);
            turnClaw(-Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_DURATION);
        }
    }
}
