package org.firstinspires.ftc.teamcode.test.measurement;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;
import org.firstinspires.ftc.teamcode.robot.Constants;

/**
 * A test for measuring Constants.MOTOR_TURN_RATE
 * @see Constants#MOTOR_TURN_RATE
 */
@Autonomous(name = "Motor Turn Rate", group = "Measurement Tests")
//@Disabled
public class MotorTurnRateMeasurement extends RobotLinearOpMode {
    public TestMotorHardware robot = new TestMotorHardware();

    @Override
    public void runOpMode() {
        super.runOpMode();

        robot.testMotor.setPower(1);

        sleep(1000);

        robot.testMotor.setPower(0);
    }
}
