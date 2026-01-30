/**
 * This class contains contstants for the Shooter scoring mechanism. 
 */
package frc.robot.subsystems.score;

public class ShooterConstants {
    private static double MAX_SPEED = 0.2;
    public enum MotorSpeed {
        /**
         * MotorSpeed values are entered for the left motor (forward is negative), followed by the right motor (forward is positive).
         * @param left
         * @param right
         */
        MAX(-MAX_SPEED,MAX_SPEED),
        INTAKE(-0.05,0.05),
        L1(-0.3,-0.1),
        L2(-0.15,0.15),
        L3(-0.15,0.15),
        L4(-0.15,0.15)
        ; // end enum values

        private final double left;
        private final double right;
        
        MotorSpeed(double left, double right) {
            this.left = left;
            this.right = right;
        }

        public double getLeft() { return left; }
        public double getRight() { return right; }

    }

}
