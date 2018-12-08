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
 * The Mecanum autonomous opmode
 */
@TeleOp(name="Pushbot: Mecanum Autonomous (Deploy Marker)", group="Pushbot")
//@Disabled
public class MecanumAutonomousMarker extends MecanumAutonomous {
    final double DEPLOY_SPEED = 0.2;

    private ElapsedTime elapsedTime = new ElapsedTime(); // Keep track of the time so you know when to stop
    private long movementPadding = 30; // A divider between each movement

    public MecanumAutonomousMarker() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            moveForward(1, 500);
            moveLeft(1, 500);
            turnRight(1, 250);
            moveBackward(1, 2500);
            turnClaw(DEPLOY_SPEED, 300);

            endOpMode();
            break;
        }
    }
}
