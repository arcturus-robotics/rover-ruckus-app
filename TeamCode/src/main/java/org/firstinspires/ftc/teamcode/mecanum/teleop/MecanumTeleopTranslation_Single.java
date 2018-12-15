/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.mecanum.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;

/**
 * An opmode for the claw and arm
 */
@TeleOp(name="Mecanum Teleop: Translation (Single Controller)", group="Mecanum Teleop")
//@Disabled
public class MecanumTeleopTranslation_Single extends OpMode {
    protected HardwareMecanum robot   = new HardwareMecanum(); // The robot, containing each motor, servo, etc.
    final double CLAW_SPEED = 0.5; // Claw movement rate from 0 to 1
    final double ARM_SPEED  = 0.5; // Arm movement rate from 0 to 1

    @Override
    public void init() {
        // Initialize the robot with the hardware map
        robot.init(hardwareMap);

        telemetry.addData("Status", "Waiting...");
    }

    @Override
    public void init_loop() {}

    @Override
    public void start() {
        telemetry.addData("Status", "Started");
    }

    @Override
    public void loop() {
        float frontLeft = gamepad1.left_stick_y - gamepad1.left_stick_x; // Front left drive
        float frontRight = gamepad1.right_stick_y + gamepad1.right_stick_x; // Front right drive
        float backLeft = gamepad1.left_stick_y + gamepad1.right_stick_x; // Back left drive
        float backRight = gamepad1.right_stick_y - gamepad1.left_stick_x; // Back right drive

        frontLeft = -Range.clip(frontLeft, -1,1);
        frontRight = -Range.clip(frontRight, -1,1);
        backLeft = -Range.clip(backLeft, -1,1);
        backRight = -Range.clip(backRight, -1,1);

        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);

        // Claw
        if (gamepad1.left_trigger == 1)
            robot.clawTilt.setPower(-CLAW_SPEED);
        else if (gamepad1.right_trigger == 1)
            robot.clawTilt.setPower(CLAW_SPEED);
        else
            robot.clawTilt.setPower(0);

        // Arm
        if (gamepad1.left_bumper)
            robot.armTilt.setPower(-ARM_SPEED);
        else if (gamepad1.right_bumper)
            robot.armTilt.setPower(ARM_SPEED);
        else
            robot.armTilt.setPower(0);

        // Intake
        if (gamepad1.x || gamepad1.a) {
            if (gamepad1.x) {
                robot.clawLeft.setDirection(Servo.Direction.FORWARD);
                robot.clawRight.setDirection(Servo.Direction.REVERSE);
            } else if (gamepad1.a) {
                robot.clawLeft.setDirection(Servo.Direction.REVERSE);
                robot.clawRight.setDirection(Servo.Direction.FORWARD);
            }

            robot.clawLeft.setPosition(1);
            robot.clawRight.setPosition(1);
        }
    }

    @Override
    public void stop() {
        telemetry.addData("Status",  "Stopped");
    }
}
