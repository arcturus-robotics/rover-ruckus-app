package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * A basic teleop with basic functionality.
 */
@TeleOp(name = "Basic Teleop", group = "Robot Teleop")
@Disabled
public class BasicTeleop extends RobotOpMode {
    public static final double CLAW_POWER = 0.02;

    @Override
    public void loop() {
        double leftDrive;
        double rightDrive;

        // Run wheels in tank mode.
        // NOTE: The joystick goes negative when pushed forwards, so negate it.
        leftDrive = -gamepad1.left_stick_y;
        rightDrive = -gamepad1.right_stick_y;

        robot.frontLeftDrive.setPower(leftDrive);
        robot.frontRightDrive.setPower(rightDrive);
        robot.backLeftDrive.setPower(leftDrive);
        robot.backRightDrive.setPower(rightDrive);
    }
}
