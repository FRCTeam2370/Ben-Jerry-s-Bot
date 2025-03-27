// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  public static WPI_TalonSRX RightDriver = new WPI_TalonSRX(4);
  public static WPI_TalonSRX RightPassenger = new WPI_TalonSRX(3);
  public static WPI_TalonSRX LeftDriver = new WPI_TalonSRX(2);
  public static WPI_TalonSRX LeftPassenger = new WPI_TalonSRX(5);

  private static DifferentialDrive mDrive = new DifferentialDrive(LeftDriver, RightDriver);


  /** Creates a new Drive. */
  public Drive() {
    ConfigureDrive();
  }

  private static void ConfigureDrive () {
    RightPassenger.follow(RightDriver);
    LeftPassenger.follow(LeftDriver);
    LeftDriver.setInverted(true);
    LeftPassenger.setInverted(true);
  }

  public static void drive (double XSpeed, double Rotation) {
    mDrive.arcadeDrive(XSpeed, Rotation);
  }

  @Override
  public void periodic() {
  }
}
