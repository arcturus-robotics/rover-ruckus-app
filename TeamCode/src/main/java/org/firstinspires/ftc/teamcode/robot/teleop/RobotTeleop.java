package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * The main teleop for our robot
 *
 * @see #gamepad1
 * @see #gamepad2
 */
@TeleOp(name = "Robot Teleop", group = "Robot Teleop")
//@Disabled
public class RobotTeleop extends RobotOpMode {
    @Override
    public void loop() {
        // Drive
        float frontLeft = -Range.clip(gamepad1.left_stick_y + gamepad1.left_stick_x, -1, 1);
        float frontRight = -Range.clip(gamepad1.right_stick_y - gamepad1.right_stick_x, -1, 1);
        float backLeft = -Range.clip(gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1);
        float backRight = -Range.clip(gamepad1.right_stick_y + gamepad1.left_stick_x, -1, 1);

        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);

        // Latch
        if (gamepad1.x) {
            robot.latch.setPower(-1);
        } else if (gamepad1.a) {
            robot.latch.setPower(1);
        } else {
            robot.latch.setPower(0);
        }

        // Arm
        if (gamepad2.x) {
            robot.arm.setPower(-1);
        } else if (gamepad2.a) {
            robot.arm.setPower(1);
        } else {
            robot.arm.setPower(0);
        }

        // Intake tilt
        if (gamepad2.y || gamepad2.b) {
            if (gamepad2.y) {
                robot.intakeTilt.setDirection(Servo.Direction.REVERSE);
            } else {
                robot.intakeTilt.setDirection(Servo.Direction.FORWARD);
            }

            robot.intakeTilt.setPosition(1);
        } else {
            robot.intakeTilt.setPosition(0);
        }

        // Intake
        if (gamepad2.left_bumper || gamepad2.right_bumper) {
            if (gamepad2.left_bumper) {
                robot.leftIntake.setDirection(Servo.Direction.FORWARD);
                robot.rightIntake.setDirection(Servo.Direction.REVERSE);
            } else {
                robot.leftIntake.setDirection(Servo.Direction.REVERSE);
                robot.rightIntake.setDirection(Servo.Direction.FORWARD);
            }

            robot.leftIntake.setPosition(1);
            robot.rightIntake.setPosition(1);
        } else {
            robot.leftIntake.setPosition(0);
            robot.rightIntake.setPosition(0);
        }
    }
}
