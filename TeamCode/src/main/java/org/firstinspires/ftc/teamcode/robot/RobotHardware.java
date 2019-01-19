package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A container for our robot's hardware
 *
 * <p>
 * Motors:
 * frontLeftDrive:  "front_left_drive"
 * frontRightDrive: "front_right_drive"
 * backLeftDrive:   "back_left_drive"
 * backRightDrive:  "back_right_drive"
 * latchMechanism:  "latch_mechanism"
 *
 * <p>
 * Servos:
 * launcherTilt: "launcher_tilt"
 * leftIntake:   "left_intake"
 * rightIntake:  "right_intake"
 */
public class RobotHardware {
    public static final String FRONT_LEFT_DRIVE = "front_left_drive";
    public static final String FRONT_RIGHT_DRIVE = "front_right_drive";
    public static final String BACK_LEFT_DRIVE = "back_left_drive";
    public static final String BACK_RIGHT_DRIVE = "back_right_drive";
    public static final String LATCH_MECHANISM = "latch_mechanism";
    public static final String ARM_TILT = "arm_tilt";

    public static final String LEFT_INTAKE = "left_intake";
    public static final String RIGHT_INTAKE = "right_intake";

    public DcMotor frontLeftDrive = null;
    public DcMotor frontRightDrive = null;
    public DcMotor backLeftDrive = null;
    public DcMotor backRightDrive = null;
    public DcMotor latchMechanism = null;
    public DcMotor armTilt = null;
    public Servo leftIntake = null;
    public Servo rightIntake = null;

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
        frontLeftDrive = hwMap.get(DcMotor.class, FRONT_LEFT_DRIVE);
        frontRightDrive = hwMap.get(DcMotor.class, FRONT_RIGHT_DRIVE);
        backLeftDrive = hwMap.get(DcMotor.class, BACK_LEFT_DRIVE);
        backRightDrive = hwMap.get(DcMotor.class, BACK_RIGHT_DRIVE);
        latchMechanism = hwMap.get(DcMotor.class, LATCH_MECHANISM);
        armTilt = hwMap.get(DcMotor.class, ARM_TILT);

        // Set motor directions
        // NOTE: Set to the opposite direction if we are using AndyMark motors
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        latchMechanism.setDirection(DcMotor.Direction.FORWARD);
        armTilt.setDirection(DcMotor.Direction.FORWARD);

        // Reset motor power
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        latchMechanism.setPower(0);
        armTilt.setPower(0);

        // Set all motors to run without encoders
        // NOTE: We may want to use RUN_USING_ENCODERS if we ever install encoders
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        latchMechanism.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armTilt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize servos
        leftIntake = hwMap.get(Servo.class, LEFT_INTAKE);
        rightIntake = hwMap.get(Servo.class, RIGHT_INTAKE);

        // Reset servo positions
        leftIntake.setPosition(Constants.MID_SERVO);
        rightIntake.setPosition(Constants.MID_SERVO);
    }
}
