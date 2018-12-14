package org.firstinspires.ftc.teamcode.mecanum.autonomous.marker;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum: Autonomous Marker", group="Mecanum")
//@Disabled
public class MecanumAutonomousMarker extends MecanumAutonomous {
    protected final double DEPLOY_SPEED  = 0.5; // The power at which the marker will be deployed
    protected final long DEPLOY_DURATION = 600; // The amount of time the marker will be deployed for

    public MecanumAutonomousMarker() {}

    @Override
    public void runOpMode() {
        super.runOpMode();
    }
}
