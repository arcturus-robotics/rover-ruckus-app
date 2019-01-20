package org.firstinspires.ftc.teamcode.robot.teleop;

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
    @Override
    public void loop() {
        // Drive
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
        if (gamepad2.x) {
            robot.latch.setPower(-1);
        } else if (gamepad2.a) {
            robot.latch.setPower(1);
        } else {
            robot.latch.setPower(0);
        }

        // Arm
        if (gamepad2.left_trigger >= BUTTON_THRESHOLD && gamepad2.right_trigger < BUTTON_THRESHOLD) {
            robot.armLeft.setPower((-gamepad1.left_trigger));
            robot.armRight.setPower((gamepad1.left_trigger));
        } else if (gamepad2.right_trigger >= BUTTON_THRESHOLD && gamepad2.left_trigger < BUTTON_THRESHOLD  ) {
            robot.armLeft.setPower((gamepad2.right_trigger)/3);
            robot.armRight.setPower((-gamepad2.right_trigger)/3);
        } else {
            robot.armLeft.setPower(0);
            robot.armRight.setPower(0);
        }


        // Intake
        if (gamepad2.left_bumper || gamepad2.right_bumper) {
            if (gamepad2.left_bumper) {
                //robot.leftIntake.setDirection(Servo.Direction.FORWARD);
                //robot.rightIntake.setDirection(Servo.Direction.REVERSE);
            } else {
                //robot.leftIntake.setDirection(Servo.Direction.REVERSE);
                //robot.rightIntake.setDirection(Servo.Direction.FORWARD);
            }

            //robot.leftIntake.setPosition(1);
            //robot.rightIntake.setPosition(1);
        } else {
            //robot.leftIntake.setPosition(0);
            //robot.rightIntake.setPosition(0);
        }
    }
}
