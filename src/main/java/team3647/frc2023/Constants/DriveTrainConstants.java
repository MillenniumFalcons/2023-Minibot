package team3647.frc2023.Constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class DriveTrainConstants {
    public static final TalonFX kLeftMotor = new TalonFX(0);
    public static final TalonFX kRightMotor = new TalonFX(1);
    private static final TalonFXConfigurator kleftConfigurator = kLeftMotor.getConfigurator();
    private static final TalonFXConfigurator krightConfigurator = kRightMotor.getConfigurator();
    private static final TalonFXConfiguration configRight = new TalonFXConfiguration();
    private static final TalonFXConfiguration configLeft = new TalonFXConfiguration();

    static {
        configRight.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        configRight.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        configLeft.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        kleftConfigurator.apply(configLeft);
        krightConfigurator.apply(configRight);
    }
}
