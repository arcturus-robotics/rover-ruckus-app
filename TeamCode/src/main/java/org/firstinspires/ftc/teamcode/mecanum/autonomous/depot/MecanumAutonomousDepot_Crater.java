package org.firstinspires.ftc.teamcode.mecanum.autonomous.depot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

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
            moveForward(1, LANDER / 2);
            moveLeft(1, LANDER / 2);
            turnRight(1, CIRCLE / 8);
            moveBackward(1, FIELD);
        }
    }
}
