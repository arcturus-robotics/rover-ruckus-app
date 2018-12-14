package org.firstinspires.ftc.teamcode.test.measurement;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

public class FieldDiagonal_Test extends MecanumAutonomous {
    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            moveForward(1, FIELD);
            break;
        }
    }
}
