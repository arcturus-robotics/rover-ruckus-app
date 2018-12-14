package org.firstinspires.ftc.teamcode.test.measurement;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.marker.MecanumAutonomous_Marker;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum: Circle Test", group="Mecanum")
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
