package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.autonomous.MecanumAutonomous;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@TeleOp(name="Mecanum: Autonomous Depot (Depot side)", group="Mecanum")
//@Disabled
public class MecanumAutonomousDepotDepot extends MecanumAutonomous {
    public MecanumAutonomousDepotDepot() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        while (opModeIsActive()) {
            // Move to depot
            moveForward(1, 2500);
        }
    }
}
