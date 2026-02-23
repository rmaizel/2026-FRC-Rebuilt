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
  public static final float BLUE_HUB_X = 4.597f;
  public static final float RED_HUB_X = 11.938f;
  public static final float HUB_Y = 4.035f;

  public static final float TOP_CORNER_Y = 7.55f; // Aiming point for passing
  public static final float BOTTOM_CORNER_Y = 0.5f; // Aiming point for passing
  public static final float BLUE_CORNER_X = 0.5f;
  public static final float RED_CORNER_X = 16.1f;

  public static final float ALIGN_TOLERANCE = 1.0f; // deg

  /**
   * Robot physical values; required for proper Swerve and operational guidance
   */
  public static final float ROBOT_MASS = (float) (148 - 20.3) * 0.453592f; // 32lbs * kg per pound
  public static final Matter CHASSIS = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final float LOOP_TIME = 0.13f; //s, 20ms + 110ms sprk max velocity lag
  public static final float MAX_SPEED = (float) Units.feetToMeters(14.5); // Maximum speed of the robot in meters per second, used to limit acceleration.

  /**
   * DriveBase Constants - stores constants required for Swerve
   */
  public static final class DriveBase {

    // Hold time on motor brakes when disabled
    public static final float WHEEL_LOCK_TIME = 10f; // in seconds
    public static final float DRIVE_FAST_SCALE = 1f;
    public static final float DRIVE_PRECISION_SCALE = 0.35f;
  }

  public static class Operator {
    // Joystick Deadband
    public static final float DEADBAND = 0.1f;
    public static final float LEFT_Y_DEADBAND = 0.1f;
    public static final float RIGHT_X_DEADBAND = 0.3f;
    public static final float TURN_CONSTANT = 6f;
  }

  public static final class Shooter {
    public static final float END_HEIGHT = 56.4f; //in inches- might change based on air resistance 
    public static final float STARTING_HEIGHT = 22.25f; //TODO change based on final CAD model 
    public static final float GRAVITY = -386.4f; //inches per seconds squared
    public static final float SHOOTER_ANGLE = (float)(85f * Math.PI/180); //in degrees might need to convert 
    public static final float HIGH_SHOOTER_ANGLE = 85f;
    public static final float PASSING_ANGLE = 48f;
    public static final float PASSING_VELOCITY = 0.5744f;
    public static final float ACTUATOR_EXTENSION = 0.80f;
    public static final float SHOOTINGVELOCITY_DEFAULT = -1.0f;

    // testing distances 
    public static final float TESTING_DISTANCE_DEFAULT = 91.0f; // distance instead of pose to test shooter
    public static final float FRONT_TRENCH = 0.777f;
    public static final float FRONT_TOWER = 0.7184f;
    
    public static final float kS = 0.079571f; //found with sysid
    public static final float kV = 0.11073f;

    public static final float PIDRPMTOLERANCE = 50f; //may need to be changed

    }
  
  public static final class Indexer {
    public static final float FEEDER_DEFAULT_SPEED = 0.8f; //TODO chnage based on robot 
    public static final float INDEXER_DEFAULT_SPEED = -0.8f; //TODO chnage based on robot 
  }

  public static final class Intake {
    public static final float INTAKE_DEFAULT_SPEED = 1.0f; //change based on robot
  }

  public static final class Climber {
    public static final float CLIMBER_DEFAULT_SPEED = 0.5f; //TODO needs to be tuned
    public static final float CLIMBER_ENCODER_EXTENSION = 2000f; //TODO find max revolutions on rev
    public static final float CLIMBER_ENCODER_TOLERANCE = 10f; //TODO find actual tolerance that is good
  }

  
}
