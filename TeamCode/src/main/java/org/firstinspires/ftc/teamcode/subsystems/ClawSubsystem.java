package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.shplib.commands.Subsystem;
import org.firstinspires.ftc.teamcode.shplib.hardware.units.MotorUnit;

public class ClawSubsystem extends Subsystem {
    // Declare devices
    public Servo claw;

    public enum State {
        OPEN,
        CLOSED,
    }

    private State state;

    public ClawSubsystem(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, Constants.Claw.kClawName);

        this.state = ClawSubsystem.State.CLOSED;
    }

    public void setState(State state) {
        this.state = state;
    }

    // Add control methods
    // Example:
    // private void setPower(double power) { motor.setPower(power); }

    @Override
    public void periodic(Telemetry telemetry) {
        switch (state){
            case OPEN:
                telemetry.addData("new", "OPEN");
                claw.setPosition(Constants.Claw.kOpen);
                telemetry.addData("pos", claw.getPosition());
                break;
            case CLOSED:
                telemetry.addData("new", "CLOSED");
                telemetry.addData("pos", claw.getPosition());
                claw.setPosition(Constants.Claw.kClosed);
                break;
        }
    }
}
