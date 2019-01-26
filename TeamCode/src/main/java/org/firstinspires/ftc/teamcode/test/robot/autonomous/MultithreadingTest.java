package org.firstinspires.ftc.teamcode.test.robot.autonomous;

import org.firstinspires.ftc.teamcode.Conversion;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

public class MultithreadingTest extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        LatchThread latchThread = new LatchThread();
        DriveThread driveThread = new DriveThread();

        latchThread.run();
        driveThread.run();
    }

    private class LatchThread extends Thread {
        @Override
        public void run() {
            try {
                turnLatch(Conversion.revolutionsToDegrees(-5));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class DriveThread extends Thread {
        @Override
        public void run() {
            try {
                driveForward(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
