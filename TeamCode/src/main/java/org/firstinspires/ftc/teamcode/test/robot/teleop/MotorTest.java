package org.firstinspires.ftc.teamcode.test.robot.teleop;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 *
 */
public class MotorTest extends RobotOpMode {
    @Override
    public void loop() {
        // Y
        if (gamepad1.y) {
            robot.frontLeftDrive.setPower(1);
        } else {
            robot.frontLeftDrive.setPower(0);
        }

        // B
        if (gamepad1.b) {
            robot.frontRightDrive.setPower(1);
        } else {
            robot.frontRightDrive.setPower(0);
        }

        // A
        if (gamepad1.a) {
            robot.backRightDrive.setPower(1);
        } else {
            robot.backRightDrive.setPower(0);
        }
        // X
        if (gamepad1.x) {
            robot.backLeftDrive.setPower(1);
        } else {
            robot.backLeftDrive.setPower(0);
        }

        // Launcher Mechanism
        if (gamepad1.left_trigger == 1) {
            robot.launcherMechanism.setPower(-1);
        } else if (gamepad1.right_trigger == 1)
            robot.launcherMechanism.setPower(1);
        else {
            robot.launcherMechanism.setPower(0);
        }

        // Launcher
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
