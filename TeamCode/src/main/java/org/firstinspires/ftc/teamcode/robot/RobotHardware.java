package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A container for our robot's hardware
 *
 * <p>
 * Motors:
 * frontLeftDrive:  {@value #FRONT_LEFT_DRIVE}
 * frontRightDrive: {@value #FRONT_RIGHT_DRIVE}
 * backLeftDrive:   {@value #BACK_LEFT_DRIVE}
 * backRightDrive:  {@value #BACK_RIGHT_DRIVE}
 * latch:           {@value #LATCH}
 * armLeft:         {@value #ARM_LEFT}
 * armRight:        {@value #ARM_RIGHT}
 *
 * <p>
 * Servos:
 * leftIntake:   {//@value #LEFT_INTAKE} (Not implemented)
 * rightIntake:  {//@value #RIGHT_INTAKE} (Not implemented
 */
public class RobotHardware {
    public static final String FRONT_LEFT_DRIVE = "front_left_drive";
    public static final String FRONT_RIGHT_DRIVE = "front_right_drive";
    public static final String BACK_LEFT_DRIVE = "back_left_drive";
    public static final String BACK_RIGHT_DRIVE = "back_right_drive";
    public static final String LATCH = "latch";
    public static final String ARM_LEFT = "arm_left";
    public static final String ARM_RIGHT = "arm_right";
    public static final String LEFT_INTAKE = "left_intake";
    public static final String RIGHT_INTAKE = "right_intake";

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor latch;
    public DcMotor armLeft;
    public DcMotor armRight;
    public Servo leftIntake;
    public Servo rightIntake;

    protected HardwareMap hardwareMap;
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
        latch = hwMap.get(DcMotor.class, LATCH);
        armLeft = hwMap.get(DcMotor.class, ARM_LEFT);
        armRight = hwMap.get(DcMotor.class, ARM_RIGHT);


        // Set motor directions
        // NOTE: Set to the opposite direction if we are using AndyMark motors
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        latch.setDirection(DcMotor.Direction.FORWARD);
        armLeft.setDirection(DcMotor.Direction.FORWARD);
        armRight.setDirection(DcMotor.Direction.FORWARD);

        // Reset motor power
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        latch.setPower(0);
        armLeft.setPower(0);

        // Set all motors to run without encoders
        // NOTE: We may want to use RUN_USING_ENCODERS if we ever install encoders
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        latch.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize servos
        leftIntake = hwMap.get(Servo.class, LEFT_INTAKE);
        rightIntake = hwMap.get(Servo.class, RIGHT_INTAKE);

        // Reset servo positions
        leftIntake.setPosition(Constants.MID_SERVO);
        rightIntake.setPosition(Constants.MID_SERVO);
    }
}
