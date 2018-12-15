package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@Autonomous(name="Mecanum Autonomous: Depot (Depot)", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous_Depot_Depot extends MecanumAutonomous_Depot {
    public MecanumAutonomous_Depot_Depot() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, LANDER);
        }
    }
}
