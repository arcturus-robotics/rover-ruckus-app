package org.firstinspires.ftc.teamcode.test.autonomous.measurement;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;
import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * Find the meters per second
 */
@Autonomous(name="Measurement Test: Degrees per second", group="Measurement Test")
public class Test_DegreesPerSecond extends MecanumAutonomous {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            turnRight(1, 1000);
        }
    }
}
