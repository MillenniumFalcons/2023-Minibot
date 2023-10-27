package team3647.frc2023.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import team3647.lib.PeriodicSubsystem;

public class Drivetrain implements PeriodicSubsystem {
    private final CANSparkMax right;
    private final CANSparkMax left;
    private final SparkMaxPIDController rightController;
    private final SparkMaxPIDController leftController;

    private final PeriodicIO periodicIO = new PeriodicIO();

    public Drivetrain(CANSparkMax left, CANSparkMax right) {
        this.left = left;
        this.right = right;
        this.leftController = left.getPIDController();
        this.rightController = right.getPIDController();
    }

    public void drive(double forward, double rotation) {
        WheelSpeeds ws = DifferentialDrive.arcadeDriveIK(forward, rotation, false);
        setOpenloop(ws.left, ws.right);
    }

    public void setOpenloop(double leftOutput, double rightOutput) {
        periodicIO.leftOutput = leftOutput;

        periodicIO.rightOutput = leftOutput;
    }

    @Override
    public void writePeriodicOutputs() {
        // this.leftController.setReference(periodicIO.leftOutput, ControlType.kDutyCycle);
        // this.rightController.setReference(periodicIO.rightOutput, ControlType.kDutyCycle);
        this.left.set(periodicIO.leftOutput);
        this.right.set(periodicIO.rightOutput);
    }

    public static class PeriodicIO {
        public double feedforward = 1;
        public double leftOutput;
        public double rightOutput;
    }

    @Override
    public String getName() {
        return "Drivetrain";
    }
}
