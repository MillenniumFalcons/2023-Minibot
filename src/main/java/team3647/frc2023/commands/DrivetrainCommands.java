package team3647.frc2023.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import java.util.function.DoubleSupplier;
import team3647.frc2023.subsystems.Drivetrain;

public class DrivetrainCommands {

    private final Drivetrain drivetrain;

    public DrivetrainCommands(Drivetrain drive) {
        this.drivetrain = drive;
    }

    public Command drive(DoubleSupplier leftY, DoubleSupplier rightX) {
        return Commands.run(
                () -> {
                    SmartDashboard.putNumber("left y", leftY.getAsDouble());
                    drivetrain.drive(leftY.getAsDouble() * 0.5, rightX.getAsDouble() * 0.5);
                },
                drivetrain);
    }
}
