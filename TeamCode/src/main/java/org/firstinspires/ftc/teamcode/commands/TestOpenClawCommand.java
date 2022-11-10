package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.shplib.commands.Command;
import org.firstinspires.ftc.teamcode.shplib.utility.Clock;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;

public class TestOpenClawCommand extends Command {
    private final ClawSubsystem claw;
    private final Direction direction;
    private double startTime;

    public enum Direction {
        //up and down relates to actuator
        OPEN, CLOSED;
    }

    public TestOpenClawCommand(ClawSubsystem claw, Direction direction) {
        // Pass through any subsystems that are uninterruptible
        super(claw);

        this.claw = claw;
        this.direction = direction;
    }

    @Override
    public void init() {
        startTime = Clock.now();
        if (direction == TestOpenClawCommand.Direction.OPEN) claw.setState(ClawSubsystem.State.OPEN);
        else if(direction == TestOpenClawCommand.Direction.CLOSED) claw.setState(ClawSubsystem.State.CLOSED);
    }

//    @Override
//    public void execute() {
//        //closes the claw
//        //check time it needs for the thing to open
//        if (Clock.hasElapsed(startTime, 1)) claw.setState(ClawSubsystem.State.CLOSED);
//    }

    @Override
    public boolean isFinished() {
        //opens claw afterwards
        return Clock.hasElapsed(startTime, 0.5);
    }
}