package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * TODO: Change device names to completely snake case
 * A container for our robot's hardware
 * <p>
 * Motors:
 * frontLeftDrive:    "front_leftDrive"  TODO: "front_left_drive"
 * frontRightDrive:   "front_rightDrive" TODO: "front_right_drive"
 * backLeftDrive:     "back_leftDrive"   TODO: "back_left_drive"
 * backRightDrive:    "back_rightDrive"  TODO: "back_right_drive"
 * armTilt:           "arm_tilt"
 * clawTilt:          "claw_tilt"
 * launcherMechanism: "launchermotor"    TODO: "launcher_mechanism"
 * <p>
 * Servos:
 * launcherTilt: "launcher_tilt"
 * clawLeft:     "claw_left"
 * clawRight:    "claw_right"
 */
public class RobotHardware {
    public DcMotor frontLeftDrive = null;
    public DcMotor frontRightDrive = null;
    public DcMotor backLeftDrive = null;
    public DcMotor backRightDrive = null;
    public DcMotor armTilt = null;
    public DcMotor clawTilt = null;
    public Servo launcherTilt = null;
    public Servo clawLeft = null;
    public Servo clawRight = null;
    public DcMotor launcherMechanism = null;

    protected HardwareMap hardwareMap = null;
    private ElapsedTime period = new ElapsedTime();

    public RobotHardware() {
    }

    /**
     * Initialize the hardware map with each device on the robot
     *
     * @param hwMap A reference to a hardware map
     * @see RobotHardware#hardwareMap
     */
    public void init(HardwareMap hwMap) {
        // Save a reference to hardware map
        hardwareMap = hwMap;

        // Define and initialize motors
        frontLeftDrive = hwMap.get(DcMotor.class, "front_leftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "front_rightDrive");
        backLeftDrive = hwMap.get(DcMotor.class, "back_leftDrive");
        backRightDrive = hwMap.get(DcMotor.class, "back_rightDrive");
        armTilt = hwMap.get(DcMotor.class, "arm_tilt");
        clawTilt = hwMap.get(DcMotor.class, "claw_tilt");
        launcherMechanism = hwMap.get(DcMotor.class, "launchermotor");

        // Set motor directions
        // NOTE: Set to the opposite direction if we are using AndyMark motors
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        armTilt.setDirection(DcMotor.Direction.FORWARD);
        clawTilt.setDirection(DcMotor.Direction.FORWARD);
        launcherMechanism.setDirection(DcMotor.Direction.FORWARD);

        // Reset motor power
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        armTilt.setPower(0);
        clawTilt.setPower(0);
        launcherMechanism.setPower(0);

        // Set all motors to run without encoders
        // NOTE: We may want to use RUN_USING_ENCODERS if we ever install encoders
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armTilt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        clawTilt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        launcherMechanism.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize servos
        launcherTilt = hwMap.get(Servo.class, "launcher_tilt");
        clawLeft = hwMap.get(Servo.class, "claw_left");
        clawRight = hwMap.get(Servo.class, "claw_right");

        // Reset servo positions
        launcherTilt.setPosition(Constants.MID_SERVO);
        clawLeft.setPosition(Constants.MID_SERVO);
        clawRight.setPosition(Constants.MID_SERVO);
    }
}
