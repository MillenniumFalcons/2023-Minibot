

# 2023-Minibot

This is the code for the minibot. If you are just starting out with robot code, this is the best place to start. 
>[!NOTE]
>This code is for the minibot with NEOS AND SPARKMAX ENCODERS. 
>[!NOTE]
>This code uses the 2023 version of wpilib and all vendor liraries
before You start, you will want to make sure that you have the right vendor libraries. You can see what libraries you have by 
going to the command pallete (ctrl + shift + p), typing "manage vendor libraries," and clicking "manage current libraries." You should have:
-the latest version of revlib
    -[You can get it from here](https://docs.revrobotics.com/sparkmax/software-resources/spark-max-api-information#c++-and-java)
-Wpilib New Commands (included in wpilib)

To install new libraries, click "install new libraries" under "manage vendor libraries" and paste the .jason link into the field.

To start, you should go the [constants file](src\main\java\team3647\frc2023\Constants\DriveTrainConstants.java). Then move on to [the subsystem](src\main\java\team3647\frc2023\subsystems\Drivetrain.java), the [commands](src\main\java\team3647\frc2023\commands\DrivetrainCommands.java), and finally [RobotContainer](src\main\java\team3647\frc2023\robot\RobotContainer.java).