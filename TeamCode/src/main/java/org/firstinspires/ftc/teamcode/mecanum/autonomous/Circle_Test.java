package org.firstinspires.ftc.teamcode.mecanum.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.marker.MecanumAutonomousMarker;

/**
 * The Mecanum autonomous opmode that deploys the marker
 */
@TeleOp(name="Mecanum: Circle Test", group="Mecanum")
//@Disabled
public class Circle_Test extends MecanumAutonomousMarker {
    public Circle_Test() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            turnRight(1, CIRCLE);
            break;
        }
    }
}
