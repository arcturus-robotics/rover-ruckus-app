package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * The main teleop for our robot
 */
@TeleOp(name = "Robot Teleop", group = "Robot Teleop")
//@Disabled
public class RobotTeleop extends RobotOpMode {
    public static final double ARM_POWER = 0.5;
    public static final double CLAW_POWER = 0.5;

    @Override
    public void loop() {
        float frontLeft = gamepad1.left_stick_y + gamepad1.left_stick_x;
        float frontRight = gamepad1.right_stick_y - gamepad1.right_stick_x;
        float backLeft = gamepad1.left_stick_y - gamepad1.right_stick_x;
        float backRight = gamepad1.right_stick_y + gamepad1.left_stick_x;

        frontLeft = Range.clip(frontLeft, -1, 1);
        frontRight = Range.clip(frontRight, -1, 1);
        backLeft = Range.clip(backLeft, -1, 1);
        backRight = Range.clip(backRight, -1, 1);

        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);

        // Latch mechanism
        if (gamepad1.left_trigger >= BUTTON_THRESHOLD) {
            robot.latchMechanism.setPower(-1);
        } else if (gamepad1.right_trigger >= BUTTON_THRESHOLD) {
            robot.latchMechanism.setPower(1);
        } else {
            robot.latchMechanism.setPower(0);
        }

        /* Unimplemented
        // Arm
        if (gamepad2.left_bumper) {
            robot.armTilt.setPower(-ARM_POWER);
        } else if (gamepad2.right_bumper) {
            robot.armTilt.setPower(ARM_POWER);
        } else {
            robot.armTilt.setPower(0);
        }

        // Claw
        if (gamepad2.left_trigger >= BUTTON_THRESHOLD) {
            robot.clawTilt.setPower(-CLAW_POWER);
        } else if (gamepad2.right_trigger == BUTTON_THRESHOLD) {
            robot.clawTilt.setPower(CLAW_POWER);
        } else {
            robot.clawTilt.setPower(0);
        }

        // Intake
        if (gamepad2.x || gamepad2.a) {
            if (gamepad2.x) {
                robot.clawLeft.setDirection(Servo.Direction.FORWARD);
                robot.clawRight.setDirection(Servo.Direction.REVERSE);
            } else {
                robot.clawLeft.setDirection(Servo.Direction.REVERSE);
                robot.clawRight.setDirection(Servo.Direction.FORWARD);
            }

            robot.clawLeft.setPosition(1);
            robot.clawRight.setPosition(1);
        }
        */
    }
}
