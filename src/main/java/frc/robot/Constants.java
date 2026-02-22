// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  /**
   * Telemetry Constants - based on (x,y) where: 
   * - (0,0) is the BOTTOM LEFT corner point, when
   * - BLUE is on the LEFT side of the field 
   */
  public static final double BLUE_HUB_X = 4.597;
  public static final double RED_HUB_X = 11.938;
  public static final double HUB_Y = 4.035;

  public static final double TOP_CORNER_Y = 7.55; // Aiming point for passing
  public static final double BOTTOM_CORNER_Y = 0.5; // Aiming point for passing
  public static final double BLUE_CORNER_X = 0.5;
  public static final double RED_CORNER_X = 16.1;

  public static final float ALIGN_TOLERANCE = 1.0f; // deg

  /**
   * Robot physical values; required for proper Swerve and operational guidance
   */
  public static final float ROBOT_MASS = (float) (148 - 20.3) * 0.453592f; // 32lbs * kg per pound
  public static final Matter CHASSIS = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final float LOOP_TIME = 0.13f; //s, 20ms + 110ms sprk max velocity lag
  public static final float MAX_SPEED = (float) Units.feetToMeters(14.5); // Maximum speed of the robot in meters per second, used to limit acceleration.

  public static final class DriveBase {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10.0; // in seconds
    public static final float DRIVE_FAST_SCALE = 1.0f;
    public static final float DRIVE_PRECISION_SCALE = 0.35f;
  }

  public static class Operator {
    // Joystick Deadband
    public static final double DEADBAND = 0.1;
    public static final double LEFT_Y_DEADBAND = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.3;
    public static final double TURN_CONSTANT = 6;
  }

  public static final class Shooter {
    public static final float END_HEIGHT = 56.4f; //in inches- might change based on air resistance 
    public static final double STARTING_HEIGHT = 22.25f; //TODO change based on final CAD model 
    public static final double GRAVITY = -386.4; //inches per seconds squared
    public static final double SHOOTER_ANGLE = 85 * (Math.PI/180); //in degrees might need to convert 
    public static final double HIGH_SHOOTER_ANGLE = 85.0; //TODO find good angles for all constants
    public static final double PASSING_ANGLE = 45.0;
    public static final double PASSING_VELOCITY = 0.5744;
    public static final double ACTUATOR_EXTENSION = 0.80;
    public static final double SHOOTINGVELOCITY_DEFAULT = -1.0;

    // testing distances 
    public static final double TESTING_DISTANCE_DEFAULT = 91.0; // distance instead of pose to test shooter
    public static final double FRONT_TRENCH = 0.777;
    public static final double FRONT_TOWER = 0.7184;
    
    public static final double kS = 0.079571; //found with sysid
    public static final double kV = 0.11073;

    public static final double PIDRPMTOLERANCE = 50; //may need to be changed

    }
  
  public static final class IndexerConstants {
    public static final int INDEXER_MOTOR_ID = 50; 
    public static final int FEEDER_CAN_ID = 51; 
    public static final double FEEDER_DEFAULT_SPEED = 0.8; //TODO chnage based on robot 
    public static final double INDEXER_DEFAULT_SPEED = -0.8; //TODO chnage based on robot 
  }

  public static final class IntakeConstants {
    public static final int INTAKE_MOTOR_ID = 30;
    public static final double INTAKE_DEFAULT_SPEED = 1.0; //change based on robot
    public static final int PISTON_ID = 2 ;
  }

  public static final class ClimberConstants {
    public static final int CLIMBER_MOTOR_ID = 60; //final
    public static final double CLIMBER_DEFAULT_SPEED = 0.5; //TODO needs to be tuned
    public static final double CLIMBER_ENCODER_EXTENSION = 2000; //TODO find max revolutions on rev
    public static final double CLIMBER_ENCODER_TOLERANCE = 10; //TODO find actual tolerance that is good
  }

  
}
