package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * <code>RobotTeleop</code> but it only uses a single controller
 *
 * @see #gamepad1
 */
@TeleOp(name = "Robot Teleop w/ Single Controller", group = "Robot Teleop")
//@Disabled
public class RobotTeleop_SingleController extends RobotTeleop {
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

        // Intake
        if (gamepad1.left_bumper || gamepad1.right_bumper) {
            if (gamepad1.left_bumper) {
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
