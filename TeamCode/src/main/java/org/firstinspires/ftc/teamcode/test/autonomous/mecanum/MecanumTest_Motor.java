package org.firstinspires.ftc.teamcode.test.autonomous.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;

/**
 * An opmode for testing motors
 */
@TeleOp(name="Mecanum Test: Motor", group="Mecanum Test")
//@Disabled
public class MecanumTest_Motor extends OpMode {
    protected HardwareMecanum robot = new HardwareMecanum(); // The robot, containing each motor, servo, etc.
    protected double clawOffset               = 0.0; // Claw offset
    protected final double CLAW_SPEED         = 0.02; // Claw movement rate

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        // Initialize the robot using the hardware map
        robot.init(hardwareMap);

        telemetry.addData("Status", "Waiting...");
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
        telemetry.addData("Status", "Started");
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        // y
        if (gamepad1.y)
            robot.frontLeftDrive.setPower(1);
        else
            robot.frontLeftDrive.setPower(0);

        // b
        if (gamepad1.b)
            robot.frontRightDrive.setPower(1);
        else
            robot.frontRightDrive.setPower(0);

        // a
        if (gamepad1.a)
            robot.backRightDrive.setPower(1);
        else
            robot.backRightDrive.setPower(0);

        // x
        if (gamepad1.x)
            robot.backLeftDrive.setPower(1);
        else
            robot.backLeftDrive.setPower(0);

        // Launcher
        if ((!(gamepad1.left_bumper) && !(gamepad1.right_bumper)))
            robot.launcherTilt.setPosition(0.5);
        else {
            if (gamepad1.left_bumper && gamepad1.right_bumper)
                robot.launcherTilt.setPosition(0.5);
            else if (gamepad1.left_bumper)
                robot.launcherTilt.setPosition(-1.0);
            else if (gamepad1.right_bumper)
                robot.launcherTilt.setPosition(1.0);
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

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        telemetry.addData("Status",  "Stopped");
    }
}