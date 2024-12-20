package org.firstinspires.ftc.teamcode.common.hardware;

import com.arcrobotics.ftclib.command.CommandScheduler;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

import org.firstinspires.ftc.teamcode.common.hardware.drivetrain.MecanumDrive;
import org.firstinspires.ftc.teamcode.common.vision.SampleAlignmentProcessor;
import org.firstinspires.ftc.teamcode.common.util.wrappers.*;
import org.firstinspires.ftc.teamcode.common.util.Constants.*;

import java.util.ArrayList;

public class Robot extends MecanumDrive {

    public Telemetry telemetry;
    private ElapsedTime runtime = new ElapsedTime();
    public WebcamName webcam;
    public VisionPortal visionPortal;

    public SampleAlignmentProcessor sampleAlignmentProcessor;
    private static Robot instance = null;
    public static RobotData data = new RobotData();
    public ArrayList<WSubsystemBase> subsystems = new ArrayList<>();

    public void initialize(HardwareMap hardwareMap, Telemetry telemetry) {
        initializePedro(hardwareMap);

        telemetry = telemetry;
        subsystems = new ArrayList<>();

        CommandScheduler.getInstance().reset();
    }

    public void write() {
        // this.data.write(telemetry);
    }

    public void periodic() {
        for (WSubsystemBase subsystem : subsystems) {
            subsystem.periodic();
        }
    }

    public void updateData() {
        for (WSubsystemBase subsystem : subsystems) {
            subsystem.updateData();
        }
        // this.data.currentPose = this.getPose();
    }

    // private void startCamera() {
    //     sampleAlignmentProcessor = new SampleAlignmentProcessor();
    //     visionPortal = new VisionPortal.Builder()
    //             .addProcessor(sampleAlignmentProcessor)
    //             .setCamera(webcam)
    //             .build();
    // }

    public static Robot getInstance() {
        if (instance == null) {
            instance = new Robot();
        }
        return instance;
    }

}