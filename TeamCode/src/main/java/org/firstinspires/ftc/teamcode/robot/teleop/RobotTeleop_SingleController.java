package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

/**
 * <code>RobotTeleop</code> but it only uses a single controller
 */
@TeleOp(name = "Robot Teleop w/ Single Controller", group = "Robot Teleop")
//@Disabled
public class RobotTeleop_SingleController extends RobotTeleop {
    @Override
    public void loop() {
        float frontLeft = gamepad1.left_stick_y + gamepad1.left_stick_x;
        float frontRight = gamepad1.right_stick_y - gamepad1.right_stick_x;
        float backLeft = gamepad1.left_stick_y + gamepad1.right_stick_x;
        float backRight = gamepad1.right_stick_y - gamepad1.left_stick_x;

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
            robot.latch.setPower(-1);
        } else if (gamepad1.right_trigger >= BUTTON_THRESHOLD) {
            robot.latch.setPower(1);
        } else {
            robot.latch.setPower(0);
        }

        /* Unimplemented
        // Claw
        if (gamepad1.left_trigger >= BUTTON_THRESHOLD) {
            robot.clawTilt.setPower(-CLAW_POWER);
        } else if (gamepad1.right_trigger >= BUTTON_THRESHOLD) {
            robot.clawTilt.setPower(CLAW_POWER);
        } else {
            robot.clawTilt.setPower(0);
        }

        // Arm
        if (gamepad1.left_bumper) {
            robot.armTilt.setPower(-ARM_POWER);
        } else if (gamepad1.right_bumper) {
            robot.armTilt.setPower(ARM_POWER);
        } else {
            robot.armTilt.setPower(0);
        }

        // Intake
        if (gamepad1.x || gamepad1.a) {
            if (gamepad1.x) {
                robot.leftIntake.setDirection(Servo.Direction.FORWARD);
                robot.rightIntake.setDirection(Servo.Direction.REVERSE);
            } else {
                robot.leftIntake.setDirection(Servo.Direction.REVERSE);
                robot.rightIntake.setDirection(Servo.Direction.FORWARD);
            }

            robot.leftIntake.setPosition(1);
            robot.rightIntake.setPosition(1);
        }
        */
    }
}
