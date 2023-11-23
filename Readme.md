

# 2023-Minibot

This is the code for the minibot. If you are just starting out with robot code, this is the best place to start. 
>[!NOTE]
>This code is for the minibot with FLACONS AND TALONFX ENCODERS. 

>[!NOTE]
>This code uses the 2023 version of wpilib and all vendor liraries, but should work with 2024 without issues

You should start by looking at the [the subsystem](src\main\java\team3647\frc2023\subsystems\Drivetrain.java). Then move on to the [commands](src\main\java\team3647\frc2023\commands\DrivetrainCommands.java), the [RobotContainer](src\main\java\team3647\frc2023\robot\RobotContainer.java), and finally the [constants](src\main\java\team3647\frc2023\Constants\DriveTrainConstants.java)

## Make your own minibot code

Before You start, you will want to make sure that you have the right vendor libraries. You can see what libraries you have by going to the command pallete (ctrl + shift + p), typing "manage vendor libraries," and clicking "manage current libraries." You should have the [latest version of phoenix 6](https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2023-latest.json) 

To install new libraries, click "install new libraries" under "manage vendor libraries" and paste the .json link into the field.

To start, we need to set up the file structure to match all our other projects, so you can use dependency classes without issues.
### ***File Structure Adjustment***
***Current Default File Structure***

```
java
└── frc
    └── robot
        ├── commands
        │   └── ExampleCommand.java
        ├── Constants.java
        ├── Main.java
        ├── RobotContainer.java
        ├── Robot.java
        └── subsystems
            └── ExampleSubsystem.java
```

This is the default file structure. This needs to be adjusted to

```
java
└── team3647
    ├── frc2022
    │   ├── autonomous
    │   ├── commands
    │   │   └── ExampleCommand.java
    │   ├── constants
    │   │   └── Constants.java
    │   ├── robot
    │   │   ├── Main.java
    │   │   ├── RobotContainer.java
    │   │   └── Robot.java
    │   └── subsystems
    │       └── ExampleSubsystem.java
    └── lib
```

>[!NOTE]
>All folder names should be lower cased

You also need to modify this line on build.gradle from:

```
def ROBOT_MAIN_CLASS = 'frc.robot.Main'
```
to 
```
def ROBOT_MAIN_CLASS = 'team3647.frc2022.robot.Main'
```

Next, we need to copy some utility classes from one of our other projects to use here. Find the robot code from one of our main robots (usually YEAR-GAMENAME-ROBOTNAME) and copy the ```PeriodicSubsystem.java``` file from the ```lib``` folder into the ```lib``` folder in your code. Your ```Drivetrain.java``` should implement this class. We also need the ```Joysticks``` class. This can also be found in ```lib``` under ```inputs```, and you should copy that into your ```lib``` as well. **You may need to change the package statement at the top of the file if you don't put ```joysticks``` in an `inputs` folder in your code**

The prep is over! You can now use this code as a template for writing your own code to drive the minibot. Please take your time to understand each part of the code, and ask questions if you don't understand something. 






