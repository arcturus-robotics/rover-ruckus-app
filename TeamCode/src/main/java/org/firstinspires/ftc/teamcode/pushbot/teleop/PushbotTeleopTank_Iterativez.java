package org.firstinspires.ftc.teamcode.pushbot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Pushbot Teleop Tankz
 */
@TeleOp(name="Pushbot Teleop: Tankz", group="Pushbot Teleop")
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

        telemetry.addData("Status", "Waiting for guac...");
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