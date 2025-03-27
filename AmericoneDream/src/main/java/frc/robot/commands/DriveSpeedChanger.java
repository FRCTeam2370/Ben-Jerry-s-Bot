// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveSpeedChanger extends Command {
  private static double Speed;
  private static double PreviousDriveSpeed;
  /** Creates a new DriveSpeedChanger. */
  @SuppressWarnings("static-access")
  public DriveSpeedChanger(double Speed) {
    this.Speed = Speed;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    PreviousDriveSpeed = Constants.DriverConstants.DriveSpeed;
    Constants.DriverConstants.DriveSpeed = Speed;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Constants.DriverConstants.DriveSpeed = PreviousDriveSpeed;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
