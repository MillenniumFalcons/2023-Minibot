package team3647.frc2023.robot;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import team3647.frc2023.Constants.DriveTrainConstants;
import team3647.frc2023.commands.DrivetrainCommands;
import team3647.frc2023.subsystems.Drivetrain;
import team3647.lib.inputs.Joysticks;

public class RobotContainer {

    private final Drivetrain drivetrain =
            new Drivetrain(DriveTrainConstants.kLeftMotor, DriveTrainConstants.kRightMotor);
    private final Joysticks mainController = new Joysticks(0);
    private final DrivetrainCommands drivetrainCommands = new DrivetrainCommands(drivetrain);

    public RobotContainer() {
        CommandScheduler.getInstance().registerSubsystem(drivetrain);
        drivetrain.setDefaultCommand(
                drivetrainCommands.drive(
                        mainController::getLeftStickY, mainController::getRightStickX));
    }
}
