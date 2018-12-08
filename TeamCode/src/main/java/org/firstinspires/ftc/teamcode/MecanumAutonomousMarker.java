package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Pushbot: Mecanum Autonomous (Deploy Marker)", group="Pushbot")
//@Disabled
public class MecanumAutonomousMarker extends MecanumAutonomous {
    final double DEPLOY_SPEED  = 0.5; // The power at which the marker will be deployed
    final long DEPLOY_DURATION = 600; // The amount of time the marker will be deployed for

    private ElapsedTime elapsedTime = new ElapsedTime(); // Keep track of the time so you know when to stop
    private long movementPadding = 30; // A divider between each movement

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

            // Move forward for the rest of autonomous
            moveForward(1, AUTONOMOUS_DURATION - (long) elapsedTime.milliseconds());
            break;
        }
    }
}
