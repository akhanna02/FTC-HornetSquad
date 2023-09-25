package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
// naming Parts
public class Automous extends LinearOpMode {
    private Blinker control_Hub;
    private IMU imu;
    // naming motors
    private DcMotor RFMotor;
    private DcMotor RBMotor;
    private DcMotor LFMotor;
    private DcMotor LBMotor;

    // todo: write your code here
    @Override
    public void runOpMode() {
        // Mapping hardware devices
        RFMotor = hardwareMap.get(DcMotor.class, "motorRF");
        RBMotor = hardwareMap.get(DcMotor.class, "motorRB");
        LBMotor = hardwareMap.get(DcMotor.class, "motorLB");
        LFMotor = hardwareMap.get(DcMotor.class, "motorLF");

        telemetry.addData("Status", "Running");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double RFtgtPower = 0;
            double LFtgtPower = 0;
            double RBtgtPower = 0;
            double LBtgtPower = 0;

            RFMotor.setPower(0.5);
            LFMotor.setPower(0.5);
            LBMotor.setPower(0.5);
            RBMotor.setPower(0.5);
            sleep(500);
            RFMotor.setPower(-0.5);
            LFMotor.setPower(0.5);
            LBMotor.setPower(0.5);
            RBMotor.setPower(-0.5);
            sleep(1000);
            RFMotor.setPower(0.5);
            LFMotor.setPower(-0.5);
            LBMotor.setPower(-0.5);
            RBMotor.setPower(0.5);
            sleep(800);

            /*
             * RFtgtPower = gamepad1.right_stick_y;
             * RBtgtPower = gamepad1.left_stick_y;
             * LFtgtPower = gamepad1.left_stick_x;
             * LBtgtPower = gamepad1.right_stick_x;
             */

            RFMotor.setPower(RFtgtPower);
            RBMotor.setPower(RBtgtPower);
            LFMotor.setPower(LFtgtPower);
            LBMotor.setPower(LBtgtPower);

            telemetry.addData("RF Target Power", RFtgtPower);
            telemetry.addData("RB Target Power", RBtgtPower);
            telemetry.addData("LF Target Power", LFtgtPower);
            telemetry.addData("LB Target Power", LBtgtPower);

            /*
             * while (opModeIsActive()) {
             * double RBtgtPower = 0;
             * RBtgtPower = gamepad1.right_stick_y;
             * RBMotor.setPower(RBtgtPower);
             * telemetry.addData("BF Target Power", RBtgtPower);
             */

        }

    }
}