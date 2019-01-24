package org.firstinspires.ftc.teamcode.test.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

@Autonomous(name = "Translation Test", group = "Robot Autonomous Test")
//@Disabled
public class TranslationTest extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveLeft(5);

            sleep(1000);

            driveRight(5);
        }
    }
}
