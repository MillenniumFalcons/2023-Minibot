package team3647.frc2023.subsystems;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import team3647.lib.PeriodicSubsystem;

/**
 * defines fucntionality for drivetrain, what the drivetrain *can* do. This class impliments
 * periodicSubsystem, which is an abstract class that allows us to consolidate our outputs and
 * inputs into seperate funcitons using writePeriodicOutputs and readPeriodicInputs, which are both
 * run in Periodic()(a function that runs repeatedly)
 *
 * <p>NOTE: periodicSubsystem is not included in a new project and must be copied from another
 * robot's code.
 */
public class Drivetrain implements PeriodicSubsystem {
    private final TalonFX left;
    private final TalonFX right;

    /**
     * DutyCycleOut is the control request for open loop (see
     * https://v6.docs.ctr-electronics.com/en/2023-v6/docs/api-reference/api-usage/control-requests.html)
     */
    private final DutyCycleOut leftDutycycle = new DutyCycleOut(0);

    private final DutyCycleOut rightDutycycle = new DutyCycleOut(0);

    // periodicIO consolidates the measured input and output values
    private final PeriodicIO periodicIO = new PeriodicIO();

    public Drivetrain(TalonFX left, TalonFX right) {
        this.left = left;
        this.right = right;
    }

    public void drive(double forward, double rotation) {
        /**
         * wheelspeeds represents the speeds of eaach wheel/motor in a differential drive. it takes
         * left and right speed arcadeDriveIK creates wheelspeeds with a forward and rotaion
         * component. it calculates left and right speed by adding rotation to forward for right,
         * and subtracing rotation from forward for left.
         */
        WheelSpeeds ws = DifferentialDrive.arcadeDriveIK(forward, rotation, false);
        setOpenloop(ws.left, ws.right);
    }

    public void setOpenloop(double leftOutput, double rightOutput) {
        // gives the empty dutyCycleOut object an output
        leftDutycycle.Output = leftOutput;
        // sets the generic controlRequest object to a DutyCycleOut with the defined ouput
        periodicIO.leftOutput = leftDutycycle;

        periodicIO.rightOutput = rightDutycycle;
        rightDutycycle.Output = rightOutput;
    }

    @Override
    public void writePeriodicOutputs() {
        // setControl() takes a controlRequest Object and applies it's output to the motor
        this.left.setControl(periodicIO.leftOutput);
        this.right.setControl(periodicIO.rightOutput);
    }

    public static class PeriodicIO {
        public double feedforward = 1;
        // generic ControlRequest, so we can make it specific to control mode later
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
