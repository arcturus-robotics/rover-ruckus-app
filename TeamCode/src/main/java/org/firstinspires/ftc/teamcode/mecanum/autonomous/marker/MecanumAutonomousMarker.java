package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum: Autonomous Deploy Marker (Crater)", group="Mecanum")
//@Disabled
public class MecanumAutonomousMarker extends MecanumAutonomous {
    protected final double DEPLOY_SPEED  = 0.5; // The power at which the marker will be deployed
    protected final long DEPLOY_DURATION = 600; // The amount of time the marker will be deployed for

    public MecanumAutonomousMarker() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, 1250);
            moveLeft(1, 1250);
            turnRight(1, 800);
            moveBackward(1, 4000);
            turnClaw(DEPLOY_SPEED, DEPLOY_DURATION);
            turnClaw(-DEPLOY_SPEED, DEPLOY_DURATION);

            endOpMode();
            break;
        }
    }
}
