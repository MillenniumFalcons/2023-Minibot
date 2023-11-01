package team3647.frc2023.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import java.util.function.DoubleSupplier;
import team3647.frc2023.subsystems.Drivetrain;

/**
 * We use the commands class to define everything we are *going* to do with the subystem.
 * For example, in a cube shooter, we define methods to run the rollers and wrist in the subsystem, then we
 *  use these methods to set specific values and setpoints in the commands. 
 * For more info on commands, see https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html
 */
public class DrivetrainCommands {

    private final Drivetrain drivetrain;

    public DrivetrainCommands(Drivetrain drive) {
        this.drivetrain = drive;
    }

    /**
     * doubleSuppliers are functions that return doubles, and their values are continuouisly called.
     * If we used doubles, we would only be able to pass in one value for the whole time the command is active, 
     *  so the value of the joystick when the command is initialized would be the speed the whole time.
     */
    public Command drive(DoubleSupplier drive, DoubleSupplier turn) {
        return Commands.run(
                () -> {
                    SmartDashboard.putNumber("drive", drive.getAsDouble());
                    SmartDashboard.putNumber("turn", turn.getAsDouble());
                    //uses the .drive method from the drivetrain class; multiplying by 0.5 makes it run at half sped.
                    drivetrain.drive(drive.getAsDouble() * 0.5, turn.getAsDouble() * 0.5);
                },
                drivetrain);
    }

   
}
