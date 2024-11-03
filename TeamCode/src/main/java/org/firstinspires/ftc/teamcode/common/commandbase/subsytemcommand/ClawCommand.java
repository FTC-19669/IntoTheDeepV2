package org.firstinspires.ftc.teamcode.common.commandbase.subsytemcommand;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.common.centerstage.ClawSide;
import org.firstinspires.ftc.teamcode.common.hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.common.subsystem.IntakeSubsystem;

public class ClawCommand extends InstantCommand {
    public ClawCommand(IntakeSubsystem.ClawState state, ClawSide side) {
        super(
                () -> RobotHardware.getInstance().intake.updateState(state, side)
        );
    }
}
