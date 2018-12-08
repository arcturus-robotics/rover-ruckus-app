package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum: Autonomous Deploy Marker (Crater)", group="Mecanum")
//@Disabled
public class MecanumAutonomousMarkerDepot extends MecanumAutonomousMarker {
    public MecanumAutonomousMarkerDepot() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, 2500);
            turnClaw(DEPLOY_SPEED, DEPLOY_DURATION);
            turnClaw(-DEPLOY_SPEED, DEPLOY_DURATION);

            endOpMode();
            break;
        }
    }
}
