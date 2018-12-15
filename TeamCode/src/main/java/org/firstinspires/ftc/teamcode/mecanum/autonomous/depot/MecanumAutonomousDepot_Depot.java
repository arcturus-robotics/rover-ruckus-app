package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@Autonomous(name="Mecanum Autonomous Depot: Depot side", group="Mecanum Autonomous Depot")
//@Disabled
public class MecanumAutonomousDepot_Depot extends MecanumAutonomousDepot {
    public MecanumAutonomousDepot_Depot() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, LANDER);
        }
    }
}