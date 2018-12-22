package org.firstinspires.ftc.teamcode.mecanum.autonomous.crater;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@Autonomous(name="Mecanum Autonomous Crater Side: Depot", group="Mecanum Autonomous Crater Side")
//@Disabled
public class CraterSide_Depot extends CraterSide {
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
