package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BaseRobot;
import org.firstinspires.ftc.teamcode.commands.DumpCargoCommand;
import org.firstinspires.ftc.teamcode.commands.MoveArmCommand;
import org.firstinspires.ftc.teamcode.commands.TestOpenClawCommand;
import org.firstinspires.ftc.teamcode.shplib.commands.RunCommand;
import org.firstinspires.ftc.teamcode.shplib.commands.Trigger;
import org.firstinspires.ftc.teamcode.subsystems.ScoopSubsystem;


@TeleOp
public class CommandBasedTeleOp extends BaseRobot {

    @Override
    public void init() {
        super.init();



        // Default command runs when no other commands are scheduled for the subsystem
//        drive.setDefaultCommand(
//                new RunCommand(
//                        () -> drive.mecanum(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x)
//                )
//        );
        arm.slide.resetEncoder();
    }

    @Override
    public void start() {
        super.start();


        // Add anything that needs to be run a single time when the OpMode starts
    }

    @Override
    public void loop() {
        // Allows CommandScheduler.run() to be called - DO NOT DELETE!

        super.loop();
        //my code
        new Trigger(gamepad1.dpad_left, new TestOpenClawCommand(claw, TestOpenClawCommand.Direction.CLOSED));
        new Trigger(gamepad1.dpad_right, new TestOpenClawCommand(claw, TestOpenClawCommand.Direction.OPEN));
//
        new Trigger(gamepad1.dpad_up, new MoveArmCommand(arm, MoveArmCommand.Direction.TOP));
        new Trigger(gamepad1.b, new MoveArmCommand(arm, MoveArmCommand.Direction.MIDDLE));
        new Trigger(gamepad1.a, new MoveArmCommand(arm, MoveArmCommand.Direction.BOTTOM));

//        new Trigger(gamepad1.dpad_down, new MoveArmCommand(arm, MoveArmCommand.Direction.BOTTOM));
        //my code end

//        new Trigger(gamepad1.b && !arm.atBottom(), new DumpCargoCommand(scoop));
//
//        // Dump cargo macro
//        new Trigger(gamepad1.a,
//                new RunCommand((() -> {
//                    scoop.setState(ScoopSubsystem.State.MIDDLE);
//                }), scoop)
//                        .then(new MoveArmCommand(arm, MoveArmCommand.Direction.TOP))
//                        .then(new DumpCargoCommand(scoop))
//                        .then(new MoveArmCommand(arm, MoveArmCommand.Direction.MIDDLE))
//                        .then(new MoveArmCommand(arm, MoveArmCommand.Direction.BOTTOM))
//        );
//
//        intake.setPower(gamepad1.left_trigger - gamepad1.right_trigger);
//        if (gamepad1.a) {
//            claw.setPosition(0.5);
//        } else if (gamepad1.b) {
//            claw.setPosition(0.1);
//        }
    }
}
