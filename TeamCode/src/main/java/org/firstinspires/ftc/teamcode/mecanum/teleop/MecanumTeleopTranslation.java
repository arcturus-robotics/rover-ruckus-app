package org.firstinspires.ftc.teamcode.mecanum.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwareMecanum;

/**
 * An opmode for the claw and arm
 */
@TeleOp(name="Mecanum Teleop: Translation", group="Mecanum Teleop")
//@Disabled
public class MecanumTeleopTranslation extends OpMode {
    protected HardwareMecanum robot   = new HardwareMecanum(); // The robot, containing each motor, servo, etc.
    protected final double CLAW_SPEED = 0.5; // Claw movement rate from 0 to 1
    protected final double ARM_SPEED  = 0.5; // Arm movement rate from 0 to 1

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
        if (gamepad2.left_trigger == 1)
            robot.clawTilt.setPower(-CLAW_SPEED);
        else if (gamepad2.right_trigger == 1)
            robot.clawTilt.setPower(CLAW_SPEED);
        else
            robot.clawTilt.setPower(0);

        // Arm
        if (gamepad2.left_bumper) {
            robot.armTilt.setPower(-ARM_SPEED);
        } else if (gamepad2.right_bumper) {
            robot.armTilt.setPower(ARM_SPEED);
        } else {
            robot.armTilt.setPower(0);
        }

        // Intake
        if (gamepad2.x || gamepad2.a) {
            if (gamepad2.x) {
                robot.clawLeft.setDirection(Servo.Direction.FORWARD);
                robot.clawRight.setDirection(Servo.Direction.REVERSE);
            } else {
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
