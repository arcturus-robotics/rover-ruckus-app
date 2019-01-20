package org.firstinspires.ftc.teamcode.test.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * Motor test teleop
 */
@TeleOp(name = "Motor Test", group = "Robot Teleop Tests")
//@Disabled
public class MotorTest extends RobotOpMode {
    @Override
    public void loop() {
        // Latch
        if (gamepad1.x) {
            robot.latch.setPower(-1);
        } else if (gamepad1.a)
            robot.latch.setPower(1);
        else {
            robot.latch.setPower(0);
        }

        // Arm mechanism
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



        /* Unimplemented
        // Launcher tilt
        if ((!(gamepad1.left_bumper) && !(gamepad1.right_bumper))) {
            robot.launcherTilt.setPosition(0.5);
        } else {
            if (gamepad1.left_bumper && gamepad1.right_bumper) {
                robot.launcherTilt.setPosition(0.5);
            } else if (gamepad1.left_bumper) {
                robot.launcherTilt.setPosition(-1.0);
            } else if (gamepad1.right_bumper) {
                robot.launcherTilt.setPosition(1.0);
            }
        }
        */

        /*
        if (move1 > 0.8 && move1 > 0.8) ;
            robot.frontLeftDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.frontRightDrive.setPower(1);
            robot.frontRightDrive.setPower(1);
        if (move1 < -0.8 && move2 < -0.8) {
            robot.frontleftDrive.setPower(1);
            robot.frontleftDrive.setPower(1);
            robot.frontrightDrive.setPower(-1);
            robot.frontrightDrive.setPower(-1);
        }
        */


        /*
        // Use gamepad left & right Bumpers to open and close the claw
        if (gamepad1.right_bumper) {
            clawOffset += CLAW_SPEED;
        } else if (gamepad1.left_bumper) {
            clawOffset -= CLAW_SPEED;
        }
        // Move both servos to new position.  Assume servos are mirror image of each other.
        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        // robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);
        // robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);
        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad1.y) {
            robot.leftArm.setPower(robot.ARM_UP_POWER);
        } else if (gamepad1.a) {
            robot.leftArm.setPower(robot.ARM_DOWN_POWER);
        } else {
            robot.leftArm.setPower(0.0);
        }
        // Send telemetry message to signify robot running;
        telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        telemetry.addData("left",  "%.2f", left);
        telemetry.addData("right", "%.2f", right);
        */
    }
}
