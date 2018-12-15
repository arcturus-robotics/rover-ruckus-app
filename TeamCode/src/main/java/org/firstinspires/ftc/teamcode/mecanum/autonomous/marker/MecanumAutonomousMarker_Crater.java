package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@Autonomous(name="Mecanum Autonomous Marker: Crater Side", group="Mecanum Autonomous Marker")
//@Disabled
public class MecanumAutonomousMarker_Crater extends MecanumAutonomousMarker {
    public MecanumAutonomousMarker_Crater() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, (LANDER / 2));
            moveLeft(1, (long) 1.4 * (LANDER / 2));
            turnRight(1, (long) (0.40*(CIRCLE / 8)));
            moveBackward(1, 3250);
            turnClaw(DEPLOY_SPEED, DEPLOY_DURATION);
            turnClaw(-DEPLOY_SPEED, DEPLOY_DURATION);

            // Move to crater
            moveForward(1, AUTONOMOUS_DURATION - (long) elapsedTime.time());
        }
    }
}
