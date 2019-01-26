package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Conversion;

import java.util.List;

/**
 * An opmode with many utility methods for autonomous programs
 */
public class RobotLinearOpMode extends LinearOpMode {
    // Vuforia
    protected static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    protected static final String GOLD_MINERAL_LABEL = "Gold Mineral";
    protected static final String SILVER_MINERAL_LABEL = "Silver Mineral";
    protected RobotHardware robot = new RobotHardware();
    protected ElapsedTime period = new ElapsedTime();
    protected double drivePower = 0.5;
    protected VuforiaLocalizer vuforia;
    protected TFObjectDetector tfod;

    @Override
    public void runOpMode() {
        // Initialize the robot using the hardware map
        robot.init(hardwareMap);

        // Wait until the driver presses PLAY
        waitForStart();

        // Reset the elapsed time so we can accurately measure it
        period.reset();

        sleep(Constants.INITIAL_DELAY_DURATION);
    }

    /**
     * Dismount the lander
     *
     * @see #turnLatch
     */
    public void dismountLander() {
        turnLatch(-Constants.LATCH_ANGLE);
        sleep(500);
        driveRight(40);
        sleep(500);
        driveForward(20);
        sleep(500);
    }

    /**
     * Utility function for driving with the specified drive powers and a duration <code>duration</code>
     *
     * @param frontLeftPower  The power to drive the front left drive motor with
     * @param frontRightPower The power to drive the front right  drive motor with
     * @param backLeftPower   The power to drive the back left drive motor with
     * @param backRightPower  The power to drive the back right drive motor with
     * @param duration        The duration to drive for (in milliseconds)
     * @see RobotHardware#frontLeftDrive
     * @see RobotHardware#frontRightDrive
     * @see RobotHardware#backLeftDrive
     * @see RobotHardware#backRightDrive
     * @see Constants#PADDING_DURATION
     */
    public void drive(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        robot.frontLeftDrive.setPower(frontLeftPower);
        robot.frontRightDrive.setPower(frontRightPower);
        robot.backLeftDrive.setPower(backLeftPower);
        robot.backRightDrive.setPower(backRightPower);

        sleep(duration);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(Constants.PADDING_DURATION);
    }

    /**
     * Drive forward for a distance <code>inches</code>
     *
     * @param inches The distance to drive forward for
     * @see RobotLinearOpMode#drive
     * @see Conversion#inchesToDrive(double)
     */
    public void driveForward(double inches) {
        drive(
                drivePower, drivePower,
                drivePower, drivePower,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Drive left for a distance <code>inches</code>
     *
     * @param inches The distance to drive left for
     * @see RobotLinearOpMode#drive
     * 4@see Conversion#inchesToDuration(double)
     */
    public void driveLeft(double inches) {
        drive(
                drivePower, -drivePower,
                -drivePower, drivePower,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Drive backward for a distance <code>inches</code>
     *
     * @param inches The distance to drive backward for
     * @see RobotLinearOpMode#drive
     * @see Conversion#inchesToDrive(double)
     */
    public void driveBackward(double inches) {
        drive(
                -drivePower, -drivePower,
                -drivePower, -drivePower,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Drive right for a distance <code>inches</code>
     *
     * @param inches The distance to drive right for
     * @see RobotLinearOpMode#drive
     * @see Conversion#inchesToDrive(double)
     */
    public void driveRight(double inches) {
        drive(
                -drivePower, drivePower,
                drivePower, -drivePower,
                Conversion.inchesToDrive(inches)
        );
    }

    /**
     * Drive to the corner of the field from the lander
     */
    public void driveToCorner() {
        driveForward(Constants.LANDER_TO_CORNER_DISTANCE);
    }

    /**
     * Drive to the crater from the lander
     */
    public void driveToCrater() {
        driveForward(Constants.LANDER_TO_CRATER_DISTANCE);
    }

    /**
     * Turn left <code>degrees</code>
     *
     * @param degrees The angle to turn left for
     * @see RobotLinearOpMode#drive
     * @see Conversion#degreesToDrive(double)
     */
    public void turnLeft(double degrees) {
        drive(
                -drivePower, drivePower,
                -drivePower, drivePower,
                Conversion.degreesToDrive(degrees)
        );
    }

    /**
     * Turn right <code>degrees</code>
     *
     * @param degrees The angle to turn right for
     * @see RobotLinearOpMode#drive
     * @see Conversion#degreesToDrive(double)
     */
    public void turnRight(double degrees) {
        drive(
                -drivePower, drivePower,
                -drivePower, drivePower,
                Conversion.degreesToDrive(degrees)
        );
    }

    /**
     * Turn the launcher mechanism
     *
     * @param degrees The angle to turn the launcher mechanism for
     * @see Conversion#degreesToTorquenado(double)
     */
    public void turnArmTilt(double degrees) {
        if (degrees > 0) {
            robot.latch.setPower(1);
        } else {
            robot.latch.setPower(-1);
        }

        sleep(Conversion.degreesToTorquenado(Math.abs(degrees)));

        robot.latch.setPower(0);

        sleep(Constants.PADDING_DURATION);
    }

    public void initGoldCubeDetection() {
        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        initVuforia();

        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        // Wait for the game to begin
        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {
            // Activate TensorFlow Object Detection.
            if (tfod != null) {
                tfod.activate();
            }

            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        if (updatedRecognitions.size() == 1) {
                            int goldMineralX = -1;
                            int silverMineral1X = -1;
                            int silverMineral2X = -1;
                            for (Recognition recognition : updatedRecognitions) {
                                if (recognition.getLabel().equals(GOLD_MINERAL_LABEL)) {
                                    goldMineralX = (int) recognition.getLeft();
                                } else if (silverMineral1X == -1) {
                                    silverMineral1X = (int) recognition.getLeft();
                                } else {
                                    silverMineral2X = (int) recognition.getLeft();
                                }
                            }
                            if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                                if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Left");
                                } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Right");
                                } else {
                                    telemetry.addData("Gold Mineral Position", "Center");
                                }
                            }
                        }
                        telemetry.update();
                    }
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
        }
    }

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia() {

        // Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = Constants.VUFORIA_LICENSE_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "webcam");

        // Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
    }

    /**
     * Initialize the Tensor Flow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, GOLD_MINERAL_LABEL, SILVER_MINERAL_LABEL);
    }


    /**
     * Turn the latch
     *
     * @param degrees The angle to turn the latch for
     * @see Conversion#degreesToTorquenado(double)
     */
    public void turnLatch(double degrees) {
        if (degrees > 0) {
            robot.latch.setPower(1);
        } else {
            robot.latch.setPower(-1);
        }

        sleep(Conversion.degreesToTorquenado(Math.abs(degrees)));

        robot.latch.setPower(0);

        sleep(Constants.PADDING_DURATION);
    }

    public void rotateLeftIntake(double degrees) {
        if (degrees > 0) {
            robot.leftIntake.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.leftIntake.setDirection(Servo.Direction.REVERSE);
        }

        robot.rightIntake.setPosition(Conversion.degreesToServoPosition(Math.abs(degrees)));

        sleep(Constants.PADDING_DURATION);
    }

    public void rotateRightIntake(double degrees) {
        if (degrees > 0) {
            robot.rightIntake.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.rightIntake.setDirection(Servo.Direction.REVERSE);
        }

        robot.rightIntake.setPosition(Conversion.degreesToServoPosition(Math.abs(degrees)));

        sleep(Constants.PADDING_DURATION);
    }
}
