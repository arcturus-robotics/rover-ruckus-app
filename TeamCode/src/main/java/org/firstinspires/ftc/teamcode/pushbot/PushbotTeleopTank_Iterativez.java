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

package org.firstinspires.ftc.teamcode.pushbot;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Pushbot Teleop Tankz
 */
@TeleOp(name="Pushbot: Teleop Tankz", group="Pushbot")
@Disabled
public class PushbotTeleopTank_Iterativez extends OpMode {
    HardwarePushbot robot       = new HardwarePushbot(); // use the class created to define a Pushbot's hardware
    double          clawOffset  = 0.0; // Claw offset
    final double    CLAW_SPEED  = 0.02; // Claw movement rate from 0 to 1

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        // Initialize the robot with the hardware map
        robot.init(hardwareMap);

        telemetry.addData("Status", "Waiting for Guac...");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {}

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        telemetry.addData("Status","Started");
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double left;
        double right;
        double testLeft;
        double testRight;

        // Run wheels in tank mode
        // NOTE: The joystick is negative when pushed forwards, so negate it
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;
        testLeft = -gamepad1.left_stick_x;
        testRight = -gamepad1.right_stick_x;

        robot.leftDrive.setPower(left);
        robot.rightDrive.setPower(right);

        telemetry.addData("Left test", "%.2f", testLeft);
        telemetry.addData("Right test", "%.2f", testRight);

        /*
        // Use gamepad left & right Bumpers to open and close the claw
        if (gamepad1.right_bumper)
            clawOffset += CLAW_SPEED;
        else if (gamepad1.left_bumper)
            clawOffset -= CLAW_SPEED;

        // Move both servos to new position.  Assume servos are mirror image of each other.
        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);
        robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);

        // Use gamepad buttons to move the arm up (Y) and down (A)
        if (gamepad1.y)
            robot.leftArm.setPower(robot.ARM_UP_POWER);
        else if (gamepad1.a)
            robot.leftArm.setPower(robot.ARM_DOWN_POWER);
        else
            robot.leftArm.setPower(0.0);

        // Send telemetry message to signify robot running;
        telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        telemetry.addData("left",  "%.2f", left);
        telemetry.addData("right", "%.2f", right);
        */
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        telemetry.addData("Status",  "Stopped");
    }
}
