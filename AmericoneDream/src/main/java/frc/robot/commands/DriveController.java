// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Drive;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveController extends Command {
  Drive mDrive;
  DoubleSupplier XSpeed;
  DoubleSupplier Rotation;

  /** Creates a new DriveController. */
  public DriveController(Drive mDrive, DoubleSupplier XSpeed, DoubleSupplier Rotation) {
    this.mDrive = mDrive;
    this.XSpeed = XSpeed;
    this.Rotation = Rotation;
    addRequirements(mDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xval = XSpeed.getAsDouble() * Constants.DriverConstants.DriveSpeed;
    double rotationVal = Rotation.getAsDouble() * Constants.DriverConstants.DriveRotation;
    Drive.drive(xval, rotationVal);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
