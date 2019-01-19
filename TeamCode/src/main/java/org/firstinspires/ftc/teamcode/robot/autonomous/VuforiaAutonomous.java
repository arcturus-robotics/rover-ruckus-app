package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

@Autonomous(name = "Vuforia Autonomous", group = "Robot Autonomous")
//@Disabled
public class VuforiaAutonomous extends RobotLinearOpMode {
    protected VuforiaLocalizer vuforia;
    protected VuforiaLocalizer.Parameters parameters;
    protected VuforiaTrackables targets;
    protected VuforiaTrackable target;
    protected VuforiaTrackable bluePerimeter;
    protected VuforiaTrackable redPerimeter;
    protected VuforiaTrackable frontPerimeter;
    protected VuforiaTrackable backPerimeter;
    protected VuforiaTrackableDefaultListener listener;

    private OpenGLMatrix lastKnownLocation;
    private OpenGLMatrix phoneLocation;
    private float robotX = 0;
    private float robotY = 0;
    private float robotAngle = 0;

    @Override
    public void runOpMode() {
        setupVuforia();

        // We don't know where the robot is, so set it to the origin
        // If we don't include this, it would be null, which would cause errors later on
        lastKnownLocation = createMatrix(0, 0, 0, 0, 0, 0);

        waitForStart();

        // Start tracking the targets
        targets.activate();

        while (opModeIsActive()) {
            // Ask the listener for the latest information on where the robot is
            OpenGLMatrix latestLocation = listener.getUpdatedRobotLocation();

            // The listener will sometimes return null, so we check for that to prevent errors
            if (latestLocation != null) {
                lastKnownLocation = latestLocation;
            }

            float[] coordinates = lastKnownLocation.getTranslation().getData();

            robotX = coordinates[0];
            robotY = coordinates[1];
            robotAngle = Orientation.getOrientation(lastKnownLocation, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;

            // Send information about whether the target is visible, and where the robot is
            telemetry.addData("Tracking " + target.getName(), listener.isVisible());
            telemetry.addData("Last Known Location", formatMatrix(lastKnownLocation));

            // Send telemetry and idle to let hardware catch up
            telemetry.update();
            idle();
        }
    }

    private void setupVuforia() {
        // Setup parameters to create localizer
        parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId); // To remove the camera view from the screen, remove the R.id.cameraMonitorViewId
        parameters.vuforiaLicenseKey = Constants.VUFORIA_LICENSE_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        parameters.useExtendedTracking = false;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // These are the vision targets that we want to use
        // The string needs to be the name of the appropriate .xml file in the assets folder
        targets = vuforia.loadTrackablesFromAsset("RoverRuckus");
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

        bluePerimeter = targets.get(0);
        bluePerimeter.setName("Blue Perimeter");
        bluePerimeter.setLocation(createMatrix(0, 0, 0, 0, 0, 0));

        redPerimeter = targets.get(1);
        redPerimeter.setName("Red Perimeter");
        redPerimeter.setLocation(createMatrix(0, 0, 0, 0, 0, 0));

        frontPerimeter = targets.get(2);
        frontPerimeter.setName("Front Perimeter");
        frontPerimeter.setLocation(createMatrix(0, 0, 0, 0, 0, 0));

        backPerimeter = targets.get(3);
        backPerimeter.setName("Back Perimeter");
        backPerimeter.setLocation(createMatrix(0, 0, 0, 0, 0, 0));

        // Setup listener and inform it of phone information
        listener = (VuforiaTrackableDefaultListener) target.getListener();
        listener.setPhoneInformation(phoneLocation, parameters.cameraDirection);
    }

    // Creates a matrix for determining the locations and orientations of objects
    // Units are millimeters for x, y, and z, and degrees for u, v, and w
    private OpenGLMatrix createMatrix(float x, float y, float z, float u, float v, float w) {
        return OpenGLMatrix.translation(x, y, z).
                multiplied(Orientation.getRotationMatrix(
                        AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, u, v, w));
    }

    // Formats a matrix into a readable string
    private String formatMatrix(OpenGLMatrix matrix) {
        return matrix.formatAsTransform();
    }
}
