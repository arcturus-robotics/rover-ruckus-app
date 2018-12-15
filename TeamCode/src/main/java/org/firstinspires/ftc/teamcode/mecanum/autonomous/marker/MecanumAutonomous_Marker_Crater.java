package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum Autonomous: Marker (Crater)", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous_Marker_Crater extends MecanumAutonomous_Marker {
    public MecanumAutonomous_Marker_Crater() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, LANDER / 2);
            moveLeft(1, LANDER / 2);
            turnRight(1, CIRCLE / 8);
            moveBackward(1, 4000);
            turnClaw(DEPLOY_SPEED, DEPLOY_DURATION);
            turnClaw(-DEPLOY_SPEED, DEPLOY_DURATION);

            // Move to crater
            moveForward(1, AUTONOMOUS_DURATION - (long) elapsedTime.time());
        }
    }
}
