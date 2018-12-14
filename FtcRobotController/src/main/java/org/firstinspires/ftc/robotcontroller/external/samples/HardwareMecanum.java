/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Mecanum hardware
 *
 * Motors:
 *   frontLeftDrive:  "front_leftDrive"  TODO: "front_left_drive"
 *   frontRightDrive: "front_rightDrive" TODO: "front_right_drive"
 *   backLeftDrive:   "back_leftDrive"   TODO: "back_left_drive"
 *   backRightDrive:  "back_rightDrive"  TODO: "back_right_drive"
 *   armTilt:         "arm_tilt"
 *   clawTilt:        "claw_tilt"
 *
 * Servos:
 *   launcherTilt: "launcher_tilt"
 *   clawLeft:     "claw_left"
 *   clawRight:    "claw_right"
 */
public class HardwareMecanum {
    public static final double MID_SERVO = 0.5;

    public DcMotor frontLeftDrive  = null;
    public DcMotor frontRightDrive = null;
    public DcMotor backLeftDrive   = null;
    public DcMotor backRightDrive  = null;
    public DcMotor armTilt         = null;
    public DcMotor clawTilt        = null;
    public Servo   launcherTilt    = null;
    public Servo   clawLeft        = null;
    public Servo   clawRight       = null;

    protected HardwareMap hwMap     = null;
    private ElapsedTime elapsedTime = new ElapsedTime();

    public HardwareMecanum() {}

    /* Initialize standard hardware interfaces */
    public void init(HardwareMap _hwMap) {
        // Save a reference to hardware map
        hwMap = _hwMap;

        /**
         * TODO: Change drive device names to completely snake case
         * To quote HardwarePushbot.java:
         * "All names are lower case and some have single spaces between words."
         */
        // Define and initialize motors
        frontLeftDrive  = hwMap.get(DcMotor.class, "front_leftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "front_rightDrive");
        backLeftDrive   = hwMap.get(DcMotor.class, "back_leftDrive");
        backRightDrive  = hwMap.get(DcMotor.class, "back_rightDrive");
        armTilt         = hwMap.get(DcMotor.class, "arm_tilt");
        clawTilt        = hwMap.get(DcMotor.class, "claw_tilt");

        // Set motor directions
        // NOTE: Set to the opposite direction if you are using AndyMark motors
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        armTilt.setDirection(DcMotor.Direction.FORWARD);
        clawTilt.setDirection(DcMotor.Direction.FORWARD);

        // Reset motor power
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        armTilt.setPower(0);
        clawTilt.setPower(0);

        // Set all motors to run without encoders
        // NOTE: You may want to use RUN_USING_ENCODERS if encoders are installed
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armTilt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        clawTilt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize servos
        launcherTilt = hwMap.get(Servo.class, "launcher_tilt");
        clawLeft = hwMap.get(Servo.class, "claw_left");
        clawRight = hwMap.get(Servo.class, "claw_right");

        // Reset servo positions
        launcherTilt.setPosition(MID_SERVO);
        clawLeft.setPosition(MID_SERVO);
        clawRight.setPosition(MID_SERVO);
    }
}