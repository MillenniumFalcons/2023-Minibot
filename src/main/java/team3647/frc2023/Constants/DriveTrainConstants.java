package team3647.frc2023.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;

public class DriveTrainConstants {

     //Declares the 2 motors. the deviceID is the can ID of the device, and can be cheked in rev hardware client.
    public static final CANSparkMax kRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    public static final CANSparkMax kLeftMotor = new CANSparkMax(3, MotorType.kBrushless);

    //seperate PID controller objects are not requried for TalonFX
    private static final SparkMaxPIDController kleftPidController = kLeftMotor.getPIDController();
    private static final SparkMaxPIDController krightPidController = kRightMotor.getPIDController();

    static {
        kRightMotor.setInverted(true);
        //Idle mode (Neutral Mode in TalonFX) governs the behavior when there is no input. The 2 options are brake and coast
        kRightMotor.setIdleMode(IdleMode.kBrake);
        kLeftMotor.setIdleMode(IdleMode.kBrake);

        /**
         * The methods below set the PID gains for the left and right motors
         * 
         * For more information, see 
         * https://docs.wpilib.org/en/stable/docs/software/advanced-controls/introduction/introduction-to-pid.html#introduction-to-pid
         *  for a conceptual explanation, and 
         * https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/pidcontroller.html#pid-control-in-wpilib
         * for in-code implementation
         */
        kleftPidController.setP(0);
        kleftPidController.setI(0);
        kleftPidController.setD(0);
       
        krightPidController.setP(0);
        krightPidController.setI(0);
        krightPidController.setD(0);
    }
}
