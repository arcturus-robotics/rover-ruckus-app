package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.mecanum.Mecanum;

/**
 * The Mecanum autonomous opmode that goes to the depot
 */
@Autonomous(name="Mecanum Autonomous Depot: Crater Side", group="Mecanum Autonomous Depot")
//@Disabled
public class MecanumAutonomousDepot_Crater extends MecanumAutonomousDepot {
    public MecanumAutonomousDepot_Crater() {}

    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Move to depot
            moveForward(1, (Mecanum.LANDER / 3));
            moveLeft(1, Mecanum.LANDER / 2);
            turnRight(1, Mecanum.CIRCLE / 12);
            moveBackward(1, (long)(Mecanum.FIELD * 0.4));
            turnClaw(1, 500);
            turnClaw(-1, 500);
            turnRight(0.7, 300);
            moveForward(1, (long) (Mecanum.FIELD * 0.5));
        }
    }
}
