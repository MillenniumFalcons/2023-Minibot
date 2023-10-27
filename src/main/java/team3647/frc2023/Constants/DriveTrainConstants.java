package team3647.frc2023.Constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;

public class DriveTrainConstants {
    public static final CANSparkMax kRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    public static final CANSparkMax kLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
    private static final SparkMaxPIDController kleftPidController = kLeftMotor.getPIDController();
    private static final SparkMaxPIDController krightPidController = kRightMotor.getPIDController();
    private static final TalonFXConfiguration configRight = new TalonFXConfiguration();
    private static final TalonFXConfiguration configLeft = new TalonFXConfiguration();

    static {
        kRightMotor.setInverted(true);
        kRightMotor.setIdleMode(IdleMode.kBrake);
        kLeftMotor.setIdleMode(IdleMode.kCoast);

        // configRight.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        // configRight.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        // configLeft.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        // kleftConfigurator.apply(configLeft);
        // krightConfigurator.apply(configRight);
    }
}
