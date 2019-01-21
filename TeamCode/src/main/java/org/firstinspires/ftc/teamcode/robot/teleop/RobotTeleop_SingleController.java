package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * <code>RobotTeleop</code> but it only uses a single controller
 */
@TeleOp(name = "Robot Teleop w/ Single Controller", group = "Robot Teleop")
//@Disabled
public class RobotTeleop_SingleController extends RobotTeleop {
    @Override
    public void loop() {
        float[] drive = getDrive();
        float frontLeft = drive[0], frontRight = drive[1], backLeft = drive[2], backRight = drive[3];

        frontLeft = -Range.clip(frontLeft, -1, 1);
        frontRight = -Range.clip(frontRight, -1, 1);
        backLeft = -Range.clip(backLeft, -1, 1);
        backRight = -Range.clip(backRight, -1, 1);

        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);


        // Latch mechanism
        if (gamepad1.x) {
            robot.latch.setPower(-1);
        } else if (gamepad1.a) {
            robot.latch.setPower(1);
        } else {
            robot.latch.setPower(0);
        }

        // Arm
        if (gamepad1.left_trigger >= BUTTON_THRESHOLD && gamepad1.right_trigger < BUTTON_THRESHOLD) {
            robot.armLeft.setPower((-gamepad1.left_trigger));
            robot.armRight.setPower((gamepad1.left_trigger));
        } else if (gamepad1.right_trigger >= BUTTON_THRESHOLD && gamepad1.left_trigger < BUTTON_THRESHOLD) {
            robot.armLeft.setPower((gamepad1.right_trigger) / 3);
            robot.armRight.setPower((-gamepad1.right_trigger) / 3);
        } else {
            robot.armLeft.setPower(0);
            robot.armRight.setPower(0);
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
