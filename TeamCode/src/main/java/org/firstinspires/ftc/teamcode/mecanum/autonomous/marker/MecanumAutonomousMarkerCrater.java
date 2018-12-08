package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.marker.MecanumAutonomousMarker;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum: Autonomous Deploy Marker (Crater)", group="Mecanum")
//@Disabled
public class MecanumAutonomousMarkerCrater extends MecanumAutonomousMarker {
    public MecanumAutonomousMarkerCrater() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, 1250);
            moveLeft(1, 1250);
            turnRight(1, CIRCLE / 8);
            moveBackward(1, 4000);
            turnClaw(DEPLOY_SPEED, DEPLOY_DURATION);
            turnClaw(-DEPLOY_SPEED, DEPLOY_DURATION);

            // Move to crater
            moveForward(1, AUTONOMOUS_DURATION - (long) elapsedTime.time());

            break;
        }
    }
}
