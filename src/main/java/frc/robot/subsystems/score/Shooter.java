// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.score;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config;
import frc.robot.Constants;

/**
 * Shooter subsystem launches the fuel (yellow ball) at high speed from the robot. 
 * It can be used to score, or to pass fuel across the field during matches, and 
 * contains the following components: 
 * <p> - Shooter Hood: determines the angle of release, controlled by a linear actuator, 
 * and can accept angles from 48 degrees (actuator set 0) to 85 degrees (actuator set 1)
 * <p> - Shooter Flywheel: determines the speed of fuel, controlled by a single motor. 
 */
public class Shooter extends SubsystemBase {
  // Configures components
  private SparkFlex shooterFlywheel = new SparkFlex(Config.CAN.SHOOTER_MOTOR.getID(), MotorType.kBrushless);
  private RelativeEncoder shooterEncoder = shooterFlywheel.getEncoder();
  private Servo shooterHood = new Servo(Config.PWM.SHOOTER_HOOD_ACTUATOR.getPort());
  private SparkClosedLoopController shooterController = shooterFlywheel.getClosedLoopController();
  private SparkFlexConfig shooterConfig = new SparkFlexConfig();
  private ClosedLoopConfig pidConfig = new ClosedLoopConfig().pid(0.0017,0,0).outputRange(0, 1);

  // Consider moving the Spark Configurations to Robot or Config so that they can be persisted when things spin up originally. 

  /**
   * Launches the Fuel (yellow ball) out of the shooter, at the speed and angle 
   * @param angle (float) desired angle of the shooter hood in degrees
   * @param rpm OPTIONAL - (float) desired speed of shooter wheel in RPMs, MAX if omitted
   */
  public void run(float angle, float rpm) {
    /*
     * Sets Hood Angle
     * - The angle can be in the range of 48 to 85 degrees, based on the length of the linear actuator.
     * - Should take in the desired angle, and then extend or retract to the actuator accordingly. 
     */
    if (angle <= Constants.Shooter.PASSING_ANGLE) {
      shooterHood.setPosition(1.0);
    } else if (angle >= Constants.Shooter.HIGH_SHOOTER_ANGLE) {
      shooterHood.setPosition(0.0);
    } else {
      // Calculates the percentage of extension needed to achieve angles between passing (48) and high angle (85)
      double calcPosition = 1 - ((angle - Constants.Shooter.PASSING_ANGLE) / (Constants.Shooter.HIGH_SHOOTER_ANGLE-Constants.Shooter.PASSING_ANGLE));
      shooterHood.setPosition(calcPosition);      
    }

    /*
     * TODO Set Flywheel Speed
     * - based on the input RPM parameter, use the encoder and a PID loop to accelerate the flywheel to the desired RPMs
     * - It should get to the target RPM quickly, and recover quickly when it's feeding in fuel
     */
    
    shooterController.setSetpoint(rpm, ControlType.kVelocity);
  }

  //Overload - run with max RPM
  public void run(int angle) {
    run(angle, 6500);
  }

    /** Creates a new Shooter. */
  public Shooter() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
