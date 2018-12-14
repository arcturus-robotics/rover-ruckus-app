package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@TeleOp(name="Mecanum: Autonomous Depot (Crater side)", group="Mecanum")
//@Disabled
public class MecanumAutonomous_Depot_Crater extends MecanumAutonomous {
    public MecanumAutonomous_Depot_Crater() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while (opModeIsActive()) {
            // Move to depot
            moveForward(1, 1250);
            moveLeft(1, 1250);
            turnRight(1, CIRCLE / 8);
            moveBackward(1, 4000);
        }
    }
}
