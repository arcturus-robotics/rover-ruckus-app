package org.firstinspires.ftc.teamcode.test.measurement;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.RobotHardware;

/**
 * A container for our robot's hardware with an extra motor for motor testing
 */
public class TestMotorHardware extends RobotHardware {
    public DcMotor testMotor = null;

    @Override
    public void init(HardwareMap hwMap) {
        super.init(hwMap);

        // Define and initialize testMotor
        testMotor = hwMap.get(DcMotor.class, "test_motor");
        testMotor.setDirection(DcMotor.Direction.FORWARD);
        testMotor.setPower(0);
        testMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
