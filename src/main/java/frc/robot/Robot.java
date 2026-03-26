// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.littletonrobotics.junction.LoggedRobot; // AdvantageKit

import edu.wpi.first.networktables.DoubleArrayEntry;
import edu.wpi.first.networktables.FloatArrayEntry;
import edu.wpi.first.networktables.FloatEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends LoggedRobot {
  private Command m_autonomousCommand;

  /**
   * Dashboard variable controls. 
   * 
   * <p>Use this section to enter NetworkTables items which can be controlled
   * and updated via input from the Elastic or SmartDashboard. Make sure to 
   * set default values in Constants which would be updated by this input.
   */
  static FloatArrayEntry pidEntry; // PID Tuning, use a Double Array to hold p, i, d, and feed-forward
  static FloatEntry IndexerSpeed; 
  static FloatEntry ShooterSpeed;
  static FloatEntry IntakeSpeed;
  static FloatEntry ClimberSpeed;
  static FloatEntry FeederSpeed;
  static FloatEntry Distance;
  static FloatEntry ActuatorEntry;

  private final RobotContainer m_robotContainer;

  public Robot() {
    NetworkTableInstance defaultInst = NetworkTableInstance.getDefault();
    NetworkTable dashboard = defaultInst.getTable("SmartDashboard");

    // TODO get and publish elastic dashboard values

    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      CommandScheduler.getInstance().schedule(m_autonomousCommand);
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  public Command getM_autonomousCommand() {
    return m_autonomousCommand;
  }

  public void setM_autonomousCommand(Command m_autonomousCommand) {
    this.m_autonomousCommand = m_autonomousCommand;
  }

  public RobotContainer getM_robotContainer() {
    return m_robotContainer;
  }
}
