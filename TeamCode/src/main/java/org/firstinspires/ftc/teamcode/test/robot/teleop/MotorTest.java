package org.firstinspires.ftc.teamcode.test.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * Motor test teleop.
 *
 * @see #gamepad1
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
    }
}
