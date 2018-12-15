package org.firstinspires.ftc.teamcode.test.autonomous.measure;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.marker.MecanumAutonomous_Marker;

/**
 * The measurement test that tries to find the amount of time it takes to turn in a full circle
 */
@Autonomous(name="Test Autonomous: Measure Circle", group="Test Autonomous")
//@Disabled
public class MeasurementTest_Circle extends MecanumAutonomous_Marker {
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
