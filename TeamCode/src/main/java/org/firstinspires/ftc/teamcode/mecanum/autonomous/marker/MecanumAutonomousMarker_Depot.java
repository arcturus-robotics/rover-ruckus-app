package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@Autonomous(name="Mecanum Autonomous Marker: Depot Side", group="Mecanum Autonomous Marker")
//@Disabled
public class MecanumAutonomousMarker_Depot extends MecanumAutonomousMarker {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot and deploy marker
            moveForward(1, Mecanum.LANDER);
            turnClaw(Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_DURATION);
            turnClaw(-Mecanum.DEPLOY_POWER, Mecanum.DEPLOY_DURATION);

            // Move to crater
            turnRight(1, Mecanum.CIRCLE / 8);
            moveBackward(1, Mecanum.FIELD);
        }
    }
}
