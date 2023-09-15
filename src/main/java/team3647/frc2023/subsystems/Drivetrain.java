package team3647.frc2023.subsystems;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import team3647.lib.PeriodicSubsystem;

public class Drivetrain implements PeriodicSubsystem {
    private final TalonFX left;
    private final TalonFX right;

    private final DutyCycleOut leftDutycycle = new DutyCycleOut(0);
    private final DutyCycleOut rightDutycycle = new DutyCycleOut(0);

    private final PeriodicIO periodicIO = new PeriodicIO();

    public Drivetrain(TalonFX left, TalonFX right) {
        this.left = left;
        this.right = right;
    }

    public void drive(double forward, double rotation) {
        WheelSpeeds ws = DifferentialDrive.arcadeDriveIK(forward, rotation, false);
        setOpenloop(ws.left, ws.right);
    }

    public void setOpenloop(double leftOutput, double rightOutput) {
        periodicIO.leftOutput = leftDutycycle;
        leftDutycycle.Output = leftOutput;
        periodicIO.rightOutput = rightDutycycle;
        rightDutycycle.Output = rightOutput;
    }

    @Override
    public void init() {}

    @Override
    public void writePeriodicOutputs() {
        this.left.setControl(periodicIO.leftOutput);
        this.right.setControl(periodicIO.rightOutput);
    }

    public static class PeriodicIO {
        public double feedforward = 1;
        public ControlRequest leftOutput;
        public ControlRequest rightOutput;
    }

    @Override
    public void periodic() {
        readPeriodicInputs();
        writePeriodicOutputs();
    }

    @Override
    public String getName() {
        return "Drivetrain";
    }
}
