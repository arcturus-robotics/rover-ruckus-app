package org.firstinspires.ftc.teamcode.mecanum.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * The Mecanum autonomous opmode that moves forward into the crater/depot
 */
@TeleOp(name="Mecanum: Autonomous Simple", group="Mecanum")
//@Disabled
public class MecanumAutonomousSimple extends MecanumAutonomous {
    public MecanumAutonomousSimple() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            moveForward(1, 2500);

            endOpMode();
            break;
        }
    }
}
