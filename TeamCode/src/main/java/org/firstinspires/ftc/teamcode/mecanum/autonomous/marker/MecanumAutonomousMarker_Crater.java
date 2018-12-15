package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

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
            moveForward(1, Mecanum.LANDER / 2);
            moveLeft(1, (long) 1.4 * (Mecanum.LANDER / 2));
            turnRight(1, (long) 0.4 * (Mecanum.CIRCLE / 8));
            moveBackward(1, 3250);
            turnClaw(Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_DURATION);
            turnClaw(-Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_DURATION);

            // Move to crater
            moveForward(1, Mecanum.FIELD);
        }
    }
}
