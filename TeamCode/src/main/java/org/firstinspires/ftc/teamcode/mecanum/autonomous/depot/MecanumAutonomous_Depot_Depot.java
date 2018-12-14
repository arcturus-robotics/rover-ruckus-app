package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@TeleOp(name="Mecanum Autonomous: Depot (Depot)", group="Mecanum Autonomous")
//@Disabled
public class MecanumAutonomous_Depot_Depot extends MecanumAutonomous {
    public MecanumAutonomous_Depot_Depot() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while (opModeIsActive()) {
            // Move to depot
            moveForward(1, 2500);
        }
    }
}
