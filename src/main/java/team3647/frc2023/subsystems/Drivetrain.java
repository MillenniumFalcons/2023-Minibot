package team3647.frc2023.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import team3647.lib.PeriodicSubsystem;
/**
 * defines fucntionality for drivetrain, what the drivetrain *can* do.
 * This class impliments periodicSubsystem, which is an abstract class that allows us to consolidate
 * our outputs and inputs into seperate funcitons using writePeriodicOutputs and readPeriodicInputs, which are both 
 * run in Periodic()(a function that runs repeatedly)
 * 
 * NOTE: periodicSubsystem is not included in a new project and must be copied from another robot's code.
 */
public class Drivetrain implements PeriodicSubsystem {
    private final CANSparkMax right;
    private final CANSparkMax left;



    //periodicIO consolidates the measured input and output values
    private final PeriodicIO periodicIO = new PeriodicIO();

    public Drivetrain(CANSparkMax left, CANSparkMax right) {
        this.left = left;
        this.right = right;
        

    }

    public void drive(double forward, double rotation) {
        /**
         * wheelspeeds represents the speeds of eaach wheel/motor in a differential drive. 
         *      it takes left and right speed
         *  arcadeDriveIK creates wheelspeeds with a forward and rotaion component.
         *   it calculates left and right speed by adding rotation to forward for right, and subtracing rotation from forward for left.
         */
        WheelSpeeds ws = DifferentialDrive.arcadeDriveIK(forward, rotation, false);
        setOpenloop(ws.left, ws.right);
    }

    public void setOpenloop(double leftOutput, double rightOutput) {
        periodicIO.leftOutput = leftOutput;

        periodicIO.rightOutput = leftOutput;
    }

    @Override
    /**
     * override of the method in periodicSubsystem; uses the built-in .set() method of the sparkMax controllers to 
     * set the outputs. This funciton is run in Periodic() in PeriodicSubsystem
     * [NOTE: the .set() method takes a percent output (duty cycle) value, from -1 to 1] 
     */
    public void writePeriodicOutputs() {

        
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
