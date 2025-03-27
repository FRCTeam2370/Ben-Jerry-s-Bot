// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

    RightDriver.configPeakCurrentLimit(40);
    RightPassenger.configPeakCurrentLimit(40);
    LeftDriver.configPeakCurrentLimit(40);
    LeftPassenger.configPeakCurrentLimit(40);
  }

  public static void drive (double XSpeed, double Rotation) {
    double bias = 0;
  
    if (XSpeed < 0) {
      //bias = 0.55 * Math.pow(XSpeed, 2) + 0.1;
      bias = XSpeed + 0.2;
      XSpeed *= 1.5;
    }

    mDrive.arcadeDrive(XSpeed, Rotation - bias);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drive Left Amps", LeftDriver.getMotorOutputVoltage());
    SmartDashboard.putNumber("Drive Right Amps", RightDriver.getMotorOutputVoltage());
  }
}
