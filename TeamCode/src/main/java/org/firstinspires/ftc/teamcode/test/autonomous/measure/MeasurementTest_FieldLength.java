package org.firstinspires.ftc.teamcode.test.autonomous.measure;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * A measurement test that tries to find the field length
 */
@Autonomous(name="Test Autonomous: Measure Field Length", group="Test Autonomous")
//@Disabled
public class MeasurementTest_FieldLength extends MecanumAutonomous {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            moveForward(1, FIELD_DIAGONAL);
        }
    }
}
