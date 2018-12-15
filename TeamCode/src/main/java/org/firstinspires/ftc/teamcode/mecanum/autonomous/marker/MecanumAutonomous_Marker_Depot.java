package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum Autonomous: Marker (Depot)", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous_Marker_Depot extends MecanumAutonomous_Marker {
    public MecanumAutonomous_Marker_Depot() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, 2500);
            turnClaw(DEPLOY_SPEED, DEPLOY_DURATION);
            turnClaw(-DEPLOY_SPEED, DEPLOY_DURATION);

            // Move to crater
            turnRight(1, CIRCLE / 8);
            moveBackward(1, AUTONOMOUS_DURATION - (long) elapsedTime.time());
        }
    }
}
