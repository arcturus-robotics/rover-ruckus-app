package org.firstinspires.ftc.teamcode.test.measurement;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

public class FieldWidth_Test extends MecanumAutonomous {
    @Override
    public void runOpMode() {
        super.runOpMode();

        while(opModeIsActive()) {
            turnForward(1, FIELD_DIAGONAL);
            break;
        }
    }
}
