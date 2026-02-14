/**
 * This class contains contstants for the Shooter scoring mechanism. 
 */
package frc.robot.subsystems.score;

// import static edu.wpi.first.units.Units.Gs;
// import static edu.wpi.first.units.Units.MetersPerSecond;

// import edu.wpi.first.math.util.*;

public class ShooterConstants {
    private static double MAX_SPEED = 0.2;

    public static final double Y_FINAL = 56.4; //in inches- might change based on air resistance 
    public static final double Y_INITIAL = 21.0; //TODO change based on final CAD model 
    public static final double GRAVITY = -386.4; //inches per seconds squared
    public static final int SHOOTER_ANGLE = 85; //in degrees might need to convert 
    
    /**
     * DualMotorSpeed values are entered for the left motor (forward is negative), followed by the right motor (forward is positive).
     * @param left
     * @param right
     */
    public enum DualMotorSpeed {
       MAX(-MAX_SPEED,MAX_SPEED),
        INTAKE(-0.05,0.05),
        L1(-0.3,-0.1),
        L2(-0.15,0.15),
        L3(-0.15,0.15),
        L4(-0.15,0.15)
        ; // end enum values

        private final double left;
        private final double right;
        
        DualMotorSpeed(double left, double right) {
            this.left = left;
            this.right = right;
        }

        public double getLeft() { return left; }
        public double getRight() { return right; }

    }

}
