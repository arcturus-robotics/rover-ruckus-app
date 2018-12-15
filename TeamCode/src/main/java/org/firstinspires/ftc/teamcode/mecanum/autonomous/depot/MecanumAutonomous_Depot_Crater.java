package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@TeleOp(name="Mecanum Autonomous: Depot (Crater)", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous_Depot_Crater extends MecanumAutonomous_Depot {
    public MecanumAutonomous_Depot_Crater() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, MOVEMENT_DURATION / 2);
            moveLeft(1, MOVEMENT_DURATION / 2);
            turnRight(1, CIRCLE / 8);
            moveBackward(1, 4000);
        }
    }
}
