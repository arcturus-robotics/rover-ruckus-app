package org.firstinspires.ftc.teamcode.test.measurement;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;
import org.firstinspires.ftc.teamcode.Constants;

/**
 * A test for measuring Constants.MOTOR_TURN_RATE.
 *
 * @see Constants#MOTOR_TURN_RATE
 */
@Autonomous(name = "Motor Turn Rate", group = "Measurement Tests")
//
public class MotorTurnRateMeasurement extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        robot.frontLeftDrive.setPower(1);

        sleep(1000);

        robot.frontLeftDrive.setPower(0);
    }
}
