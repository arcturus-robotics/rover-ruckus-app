package org.firstinspires.ftc.teamcode.test.autonomous.measurement;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.marker.MecanumAutonomousMarker;

/**
 * The measurement test that tries to find the amount of time it takes to turn in a full circle
 */
@Autonomous(name="Measurement Test: Circle", group="Measurement Test")
//@Disabled
public class MeasurementTest_Circle extends MecanumAutonomousMarker {
    public MeasurementTest_Circle() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            turnRight(1, CIRCLE);
            break;
        }
    }
}