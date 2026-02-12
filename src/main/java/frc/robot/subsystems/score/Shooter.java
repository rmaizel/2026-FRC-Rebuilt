// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.score;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.units.Units.*;
import frc.robot.Config;

public class Shooter extends SubsystemBase {
  private SparkFlexConfig motorConfig = new SparkFlexConfig();
  private SparkFlex shooterMotor = new SparkFlex(Config.CAN.SHOOTER_MOTOR.getID(), MotorType.kBrushless);

  /**
   * Launches the Fuel (yellow ball) out of the shooter. 
   * @param range (float) distance to hub in inches
   */
  public void shootFuel(double range){
    float shooterVelocityInches = (float) (
      range / (
        Math.sqrt(
          (
            2 / ShooterConstants.GRAVITY * (
              ShooterConstants.Y_FINAL - ShooterConstants.Y_INITIAL - Math.tan(ShooterConstants.SHOOTER_ANGLE) * range
            )
          )
        ) * Math.cos(ShooterConstants.SHOOTER_ANGLE)
      )
    ); // Really need to simplify this one. 

    float shooterVelocityRpm = (float) shooterVelocityInches * (float) (120/(4*Math.PI));
    float percentSpeed = (shooterVelocityRpm/6784);

    if (shooterVelocityRpm < 6784 && shooterVelocityRpm > 970) {
      shooterMotor.set(percentSpeed);
    } else {
      shooterMotor.set(1.0);
    }
  }

  /** Creates a new Shooter. */
  public Shooter() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
