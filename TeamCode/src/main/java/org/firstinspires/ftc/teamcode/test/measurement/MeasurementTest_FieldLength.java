package org.firstinspires.ftc.teamcode.test.measurement;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * A measurement test that tries to find the field length
 */
@TeleOp(name="Measurement Test: Field Length", group="Measurement Test")
//@Disabled
public class MeasurementTest_FieldLength extends MecanumAutonomous {
    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            moveForward(1, FIELD_DIAGONAL);
            break;
        }
    }
}
