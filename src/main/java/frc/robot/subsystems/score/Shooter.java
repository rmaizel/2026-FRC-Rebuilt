// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.score;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config;

public class Shooter extends SubsystemBase {
    private SparkMaxConfig motorConfig = new SparkMaxConfig();
    private SparkMax rightShooterMotor = new SparkMax(Config.CAN.SHOOTER_MOTOR_R.getID(), MotorType.kBrushless);
    private SparkMax leftShooterMotor = new SparkMax(Config.CAN.SHOOTER_MOTOR_L.getID(), MotorType.kBrushless);
    private DigitalInput coralSensor = new DigitalInput(Config.DIO.CORAL_SENSOR_F.getPort());

  /** Creates a new Shooter. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
