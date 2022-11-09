package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.shplib.commands.Command;
import org.firstinspires.ftc.teamcode.shplib.utility.Clock;
import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;

public class ClawMoveCommand extends Command {
    private final ClawSubsystem claw;
    private double startTime;

    public ClawMoveCommand(ClawSubsystem claw) {
        // Pass through any subsystems that are uninterruptible
        super(claw);

        this.claw = claw;
    }

    @Override
    public void init() {
        startTime = Clock.now();
        claw.setState(ClawSubsystem.State.OPEN);
    }

    @Override
    public void execute() {
        //closes the claw
        //check time it needs for the thing to open

        if (Clock.hasElapsed(startTime, 1)) claw.setState(ClawSubsystem.State.CLOSED);
    }

    @Override
    public boolean isFinished() {
        //opens claw afterwards
        return Clock.hasElapsed(startTime, 2);
    }
}
