package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@Autonomous(name="Mecanum Autonomous Marker: Depot Side", group="Mecanum Autonomous Marker")
//@Disabled
public class MecanumAutonomousMarker_Depot extends MecanumAutonomousMarker {
    public MecanumAutonomousMarker_Depot() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, LANDER);
            turnClaw(DEPLOY_SPEED, DEPLOY_DURATION);
            turnClaw(-DEPLOY_SPEED, DEPLOY_DURATION);

            // Move to crater
            turnRight(1, CIRCLE / 8);
            moveBackward(1, AUTONOMOUS_DURATION - (long) elapsedTime.time());
        }
    }
}
